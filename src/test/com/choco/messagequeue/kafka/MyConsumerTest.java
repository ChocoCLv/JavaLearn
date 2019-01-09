package com.choco.messagequeue.kafka;

import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

public class MyConsumerTest {
    private Properties props;

    @Before
    public void init() {
        props = new Properties();
        props.put("bootstrap.servers", "192.168.1.223:9092");
        props.put("group.id", "testConsumer");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    }

    @Test
    public void consume() {
        System.out.println("begin consumer");
        new MyConsumer().connectionKafka(props);
        System.out.println("finish consumer");
    }

}