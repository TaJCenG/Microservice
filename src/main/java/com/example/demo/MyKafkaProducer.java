package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Service
public class MyKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MyKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @RequestMapping(value="/") 
    public void sendMessage(String message) {
    	final org.slf4j.Logger logger = LoggerFactory.getLogger(MyKafkaProducer.class);
		logger .info("Welcome to MyKafkaProducer service");
    	String message1 = "Hi This is Producer";
        kafkaTemplate.send("my-topic", message1);
    }
}
