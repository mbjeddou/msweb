package com.example.voiture.service.Iservice;

import com.example.voiture.VoitureDTO.VoitureDTO;
import com.example.voiture.entity.Voiture;

public interface IvoitureService {
    public VoitureDTO getVoitureById(Long id);
    public VoitureDTO saveVoiture(Voiture voiture);
}
