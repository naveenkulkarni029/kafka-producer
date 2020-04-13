package org.nbk.demo.kafka.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
	this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String message) {
	System.out.println(message);
	kafkaTemplate.send("testMessage", message);
    }

}
