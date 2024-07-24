package com.example.remorquage.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class config {
    @Bean
    public NewTopic webDistribTopic() {
        return TopicBuilder
                .name("remorquageTopic")
                .build();
    }
}

