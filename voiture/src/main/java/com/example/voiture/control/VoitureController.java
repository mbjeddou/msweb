package com.example.voiture.control;

import com.example.voiture.VoitureDTO.VoitureDTO;
import com.example.voiture.entity.Voiture;
import com.example.voiture.service.VoitureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voiture")
public class VoitureController {

    @Autowired
    VoitureServiceImpl voitureService;
    @GetMapping("/{id}")
    public VoitureDTO getVoitureWithRemorquage(@PathVariable Long id) {
        return voitureService.getVoitureById(id);
    }

    @PostMapping
    public VoitureDTO createVoiture(@RequestBody Voiture voiture) {
        return voitureService.saveVoiture(voiture);
    }
}
