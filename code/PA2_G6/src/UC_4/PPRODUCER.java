/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UC_4;

import Message.Message;
import java.net.Socket;
import java.io.*;
import java.net.InetAddress;
import java.util.HashMap;
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
    private final HashMap<String, Integer> totalNumberRecords;

    public PPRODUCER (int producerId) {
        this.producerId = producerId;
        this.guiProducer = new GUIPRODUCER();
        
        this.properties = new Properties();
        this.properties.put("bootstrap.servers", "localhost:9092"); // Conection to the kafka cluster
        this.properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); // Serializer class for key
        this.properties.put("value.serializer", "Message.MessageSerializer"); // Serializer class for value (message)
        this.properties.put("acks", "1"); //  Will not wait for full acknowledgment from all, records can be lost but the possibility is minimized.
        this.properties.put("batch_size", "100000");
        this.properties.put("linger.ms", "0");
        this.properties.put("max.in.flight.requests.per.connection", 1);                                                                               //  1: there is no risk of message reordering due to retries.
                                                                                     //  Will keep original order of all records.
        this.producer = new KafkaProducer<>(properties);
        
        this.totalNumberRecords = new HashMap<>();
        this.totalNumberRecords.put("total", 0);
        this.totalNumberRecords.put("0", 0);
        this.totalNumberRecords.put("1", 0);
        this.totalNumberRecords.put("2", 0);
        this.totalNumberRecords.put("3", 0);
        this.totalNumberRecords.put("4", 0);
        this.totalNumberRecords.put("5", 0);
    }
    
    @Override
    public void run() {    
        try {
            
            this.guiProducer.setNewLocation(this.producerId);
            this.guiProducer.setVisible(true);
            this.guiProducer.updateTitleArea(Integer.toString(producerId));
        
            InetAddress ip = InetAddress.getByName("localhost");

            while (true) {
                
                Socket s = new Socket(ip, 7777);
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                
                dos.writeUTF("ready");   // sinalize server (source) that producer is ready to accept data
                  
                String received = dis.readUTF();  // data received from source
                //System.out.println("Received from Source: " + received);
                
                dis.close();
                dos.close();
                s.close();
                
                if(received.equals("end")) {
                    guiProducer.updateNumberRecords("total", this.totalNumberRecords.get("total"));
                    guiProducer.updateNumberRecords("0", this.totalNumberRecords.get("0"));
                    guiProducer.updateNumberRecords("1", this.totalNumberRecords.get("1"));
                    guiProducer.updateNumberRecords("2", this.totalNumberRecords.get("2"));
                    guiProducer.updateNumberRecords("3", this.totalNumberRecords.get("3"));
                    guiProducer.updateNumberRecords("4", this.totalNumberRecords.get("4"));
                    guiProducer.updateNumberRecords("5", this.totalNumberRecords.get("5"));
                    break;
                } 
                
                String[] msgArgs = received.split(" ");
                Message msg = new Message(msgArgs[0], Double.parseDouble(msgArgs[1]), Integer.parseInt(msgArgs[2]));
                 
                producer.send(new ProducerRecord<>(this.topic, 0,msgArgs[0], msg));  // send to kafka
                guiProducer.updateTextArea("Sent to Kafka: " + msg.toString());
                
                this.totalNumberRecords.put("total", this.totalNumberRecords.get("total")+1);
                this.totalNumberRecords.put(msgArgs[0], this.totalNumberRecords.get(msgArgs[0])+1);
                
            }
            producer.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }
    
}
