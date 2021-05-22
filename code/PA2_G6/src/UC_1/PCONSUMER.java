/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UC_1;

import Message.Message;
import java.time.Duration;
import java.util.Arrays;
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
            });

            this.consumer.commitAsync(); 
        }
    }

    
}
