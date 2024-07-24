package com.example.voiture.mapper;


import com.example.voiture.VoitureDTO.VoitureDTO;
import com.example.shared.RemorquageDTO;
import com.example.voiture.entity.Voiture;
import com.example.voiture.entity.Remorquage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class MapToDto {

    public VoitureDTO maptoVoitureDTO(RemorquageDTO remorquage, Voiture voiture){

        VoitureDTO voitureDTO=new VoitureDTO();
        voitureDTO.setId(voiture.getId());
        voitureDTO.setName(voiture.getName());
        voitureDTO.setRemorquageZone(remorquage.getZone());
    return voitureDTO;
    }
}
