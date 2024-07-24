package com.example.voiture.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Remorquage {


    @Id
    private String id;

    private String zone;

    // Getters and setters

    // Optionally, a method to generate or set the ID
    public void generateId() {
        this.id = UUID.randomUUID().toString(); // Example for generating a unique ID
    }

}
