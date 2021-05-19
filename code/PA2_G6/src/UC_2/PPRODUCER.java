/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UC_2;

import Message.Message;
import java.net.Socket;
import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 *
 * @author tomascosta
 */
public class PPRODUCER extends Thread {
    
    private int producerId;
    private GUIPRODUCER guiProducer;
    private Properties properties;
    private static final String topic = "Sensor";
    private KafkaProducer<String, Message> producer;

    public PPRODUCER (int producerId) {
        this.producerId = producerId;
        this.guiProducer = new GUIPRODUCER();
        
        this.properties = new Properties();
        this.properties.put("bootstrap.servers", "localhost:9092"); // Conection to the kafka cluster
        this.properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); // Serializer class for key
        this.properties.put("value.serializer", "Message.MessageSerializer"); // Serializer class for value (message)
        this.properties.put("acks", "0"); // Acknowledgment received. 0: Will not wait, decords can be lost.
        this.properties.put("max.in.flight.requests.per.connection", 1); // Maximum number of unacknowledged requests the client will send.
                                                                                     //  1: there is no risk of message reordering due to retries.
                                                                                     //  Will keep original order of all records.

        this.producer = new KafkaProducer<>(properties);
    }
    
    @Override
    public void run() {    
        try {
            
            this.guiProducer.setNewLocation(this.producerId);
            this.guiProducer.setVisible(true);
            this.guiProducer.updateTitleArea(Integer.toString(this.producerId));
            
            InetAddress ip = InetAddress.getByName("localhost");

            while (true) {
                
                Socket s = new Socket(ip, 7777);
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                
                dos.writeUTF("ready");   // sinalize server (source) that producer is ready to accept data
                  
                String received = dis.readUTF();  // data received from source
                System.out.println("Producer " + this.producerId + " / Received from Source: " + received);
                
                dis.close();
                dos.close();
                s.close();
                
                if(received.equals("end")) {
                    break;
                } 
                
                String[] msgArgs = received.split(" ");
                Message msg = new Message(msgArgs[0], Double.parseDouble(msgArgs[1]), Integer.parseInt(msgArgs[2]));
                guiProducer.updateTextArea("Received from Source: " + msg.toString());
                 
                producer.send(new ProducerRecord<>(this.topic, Integer.parseInt(msgArgs[0]),msgArgs[0], msg));  // send to kafka
                guiProducer.updateTextArea("Sent to Kafka: " + msg.toString());
                
                
                if(received.equals("end")) {
                    break;
                } 
            }
            producer.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }
    
}
