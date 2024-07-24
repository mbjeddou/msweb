package com.example.remorquage.services;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RemorquageService {

    @KafkaListener(topics = "voitureTop", groupId = "remorquage-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}
