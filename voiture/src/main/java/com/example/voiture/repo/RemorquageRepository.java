package com.example.voiture.repo;

import com.example.voiture.entity.Remorquage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemorquageRepository extends JpaRepository<Remorquage, String> {
    Remorquage findRemorquageByZone(String zone);
}