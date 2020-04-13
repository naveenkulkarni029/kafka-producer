package org.nbk.demo.kafka.producer.controller;

import org.nbk.demo.kafka.producer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaRequestController {

    private KafkaProducerService kafkaProducerService;

    @Autowired
    public KafkaRequestController(KafkaProducerService kafkaProducerService) {
	this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping(value = "/kafka/sendMessage")
    public ResponseEntity<Object> getMessage(@RequestParam(name = "message") String message) {
	kafkaProducerService.sendMessage(message);
	return ResponseEntity.ok().body(message);
    }

}
