package com.example.voiture.service;

import com.example.shared.RemorquageDTO;
import com.example.voiture.entity.Remorquage;
import com.example.voiture.repo.RemorquageRepository;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class RemorquageService {

    @Autowired
    private RemorquageRepository remorquageRepository;

    private final Gson gson = new Gson();

    @KafkaListener(topics = "voitureTop", groupId = "myGroup")
    public void upDateRemorquage(String message) {
        RemorquageDTO remorquageDto = gson.fromJson(message, RemorquageDTO.class); // Deserialize JSON to RemorquageDto object
        log.info(remorquageDto.toString());

        Remorquage remorquage = remorquageRepository.findRemorquageByZone(remorquageDto.getZone());

        if (remorquage != null) {
            boolean updated = false;

            if (!Objects.equals(remorquage.getZone(), remorquageDto.getZone())) {
                remorquage.setZone(remorquageDto.getZone());
                updated = true;
            }

            if (updated) {
                remorquageRepository.save(remorquage);
                log.info("Remorquage updated: {}", remorquage);
            } else {
                log.info("Remorquage already up-to-date, no changes made");
            }

        } else {
            remorquage = new Remorquage();
            remorquage.generateId();
            remorquage.setZone(remorquageDto.getZone());

            remorquageRepository.save(remorquage);
            log.info("New remorquage created: {}", remorquage);
        }
    }
    public String generateId() {
       return UUID.randomUUID().toString(); // Example for generating a unique ID
    }
}
