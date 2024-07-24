package com.example.voiture.service;

import com.example.shared.RemorquageDTO;
import com.example.voiture.entity.Remorquage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "remorquage-service", url = "http://localhost:9999/api/remorquage")
public interface RemorquageClient {
    @GetMapping("/{id}")
    RemorquageDTO getRemorquageById(@PathVariable("id") String id);
}
