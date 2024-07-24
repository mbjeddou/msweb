package com.example.remorquage.services.Iservice;

import com.example.remorquage.RemorquageDTO.RemorquageDTO;
import com.example.remorquage.entity.Remorquage;

public interface IremorquageService {
    public RemorquageDTO getRemorquageById( String id);
    public RemorquageDTO saveRemorquage(Remorquage remorquage);
}
