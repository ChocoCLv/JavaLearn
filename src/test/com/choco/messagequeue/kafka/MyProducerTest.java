package com.choco.messagequeue.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

public class MyProducerTest {
    private Properties props;
    private Producer<String, String> producer;

    @Before
    public void init() {
        props = new Properties();
        props.put("bootstrap.servers", "192.168.1.223:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        producer = new KafkaProducer<>(props);
    }

    @Test
    public void produce() {
        System.out.println("begin produce");
        new MyProducer().connectionKafka(producer);
        System.out.println("finish produce");
    }

    @After
    public void destroy() {
        producer.close();
    }

}