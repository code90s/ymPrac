package com.ymPrac.mq.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

import java.util.Properties;
import java.util.Random;

public class NativeProducer {
    public static void main(String[] args) {
		String topic= "test";
		long events = 100;
        Random rand = new Random();
 
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.8.8:9092");
        props.put("acks", "all");
        props.put("retries ", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<Object, Object> producer = new KafkaProducer<>(props);
 
        for (int nEvents = 0; nEvents < events; nEvents++) {
//            producer.send(new ProducerRecord<>("my-topic", Integer.toString(nEvents), Integer.toString(nEvents)));
        }
        producer.close();
	}

}