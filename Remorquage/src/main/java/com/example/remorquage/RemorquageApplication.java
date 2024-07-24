package com.example.remorquage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RemorquageApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemorquageApplication.class, args);
    }

}
