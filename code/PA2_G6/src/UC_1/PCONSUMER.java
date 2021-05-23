/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UC_1;

import Message.Message;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 *
 * @author tomascosta
 */
public class PCONSUMER extends Thread {

    private final int consumerId;
    private final GUICONSUMER guiConsumer;
    private final Properties properties;
    private static final String topic = "Sensor";
    private final KafkaConsumer<String, Message> consumer;
    private final HashMap<String, Integer> totalNumberRecords;
    
    public PCONSUMER(int consumerId) {
        this.consumerId = consumerId;
        this.guiConsumer = new GUICONSUMER();
        
        this.properties = new Properties();
        this.properties.put("bootstrap.servers", "localhost:9092"); // Conection to the kafka cluster
        this.properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // Serializer class for key
        this.properties.put("value.deserializer", "Message.MessageDeserializer"); // Serializer class for value (message)
        this.properties.put("allow.auto.create.topics", false); // One copy of each message. Records wil not be duplicated.
        this.properties.put("enable.auto.commit", true);
        this.properties.put("session.timeout.ms", "30000");
        this.properties.put("auto.offset.reset", "latest");
        this.properties.put("max.poll.records", 10); 
        this.properties.put("fetch.min.bytes","100000");
        this.properties.put("group.id", "0");

        this.consumer = new KafkaConsumer<>(properties);
        this.consumer.subscribe(Arrays.asList(this.topic));
        
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
        
        this.guiConsumer.setNewLocation(this.consumerId);
        this.guiConsumer.setVisible(true);
        this.guiConsumer.updateTitleArea(Integer.toString(this.consumerId));

        while (true) {
            ConsumerRecords<String, Message> records = this.consumer.poll(Duration.ofMillis(100));

            records.forEach(record -> {
                Message msg = record.value();
                this.guiConsumer.updateTextArea("Consumed from Kafka: " + msg.toString());
                this.totalNumberRecords.put("total", this.totalNumberRecords.get("total")+1);
                this.totalNumberRecords.put(msg.getId(), this.totalNumberRecords.get(msg.getId())+1);
                

            });
            
            guiConsumer.updateNumberRecords("total", this.totalNumberRecords.get("total"));
            guiConsumer.updateNumberRecords("0", this.totalNumberRecords.get("0"));
            guiConsumer.updateNumberRecords("1", this.totalNumberRecords.get("1"));
            guiConsumer.updateNumberRecords("2", this.totalNumberRecords.get("2"));
            guiConsumer.updateNumberRecords("3", this.totalNumberRecords.get("3"));
            guiConsumer.updateNumberRecords("4", this.totalNumberRecords.get("4"));
            guiConsumer.updateNumberRecords("5", this.totalNumberRecords.get("5"));

            this.consumer.commitAsync(); 
        }
    }

    
}
