package com.choco.messagequeue.kafka;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Scanner;


public class MyProducer {
    private static Scanner scanner;

    public void connectionKafka(Producer<String, String> producer) {
        scanner = new Scanner(System.in);

        String value = "hhhh";

        producer.send(new ProducerRecord<String, String>("my-topic", value));

    }

}


