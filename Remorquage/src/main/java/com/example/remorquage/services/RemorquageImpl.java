package com.example.remorquage.services;

import com.example.remorquage.RemorquageDTO.RemorquageDTO;
import com.example.remorquage.entity.Remorquage;
import com.example.remorquage.mapper.MapToDto;
import com.example.remorquage.repo.RemorquageRepo;
import com.example.remorquage.services.Iservice.IremorquageService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor
public class RemorquageImpl implements IremorquageService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    RemorquageRepo remorquageRepository;
    @Autowired
    MapToDto mapToDto;

    @Override
    public RemorquageDTO getRemorquageById(String id) {
        return mapToDto.maptoRemorquageDTO(remorquageRepository.findById(id).get());
    }
    @Override
    public RemorquageDTO saveRemorquage(Remorquage remorquage) {
        RemorquageDTO remorquageDTO= mapToDto.maptoRemorquageDTO(remorquageRepository.save(remorquage));
        log.info(remorquageDTO.toString());
        RemorquageDTO remorquageDto = RemorquageDTO.builder()
                .zone(remorquage.getZone())
                .build();
        Gson gson = new Gson(); // Create Gson instance
        String json = gson.toJson(remorquageDto); // Serialize Remorquage to JSON
        kafkaTemplate.send("remorquageTopic", json);
        return remorquageDTO;
    }

}
