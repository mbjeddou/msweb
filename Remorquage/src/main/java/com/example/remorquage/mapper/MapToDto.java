package com.example.remorquage.mapper;



import com.example.remorquage.RemorquageDTO.RemorquageDTO;
import com.example.remorquage.entity.Remorquage;
import org.springframework.stereotype.Component;

@Component
public class MapToDto {

    public RemorquageDTO maptoRemorquageDTO(Remorquage remorquage){

        RemorquageDTO remorquageDTO=new RemorquageDTO();
        remorquageDTO.setId(remorquage.getId());
        remorquageDTO.setZone(remorquage.getZone());

    return remorquageDTO;
    }
}
