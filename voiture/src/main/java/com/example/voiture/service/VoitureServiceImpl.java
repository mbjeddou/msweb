package com.example.voiture.service;

import com.example.voiture.VoitureDTO.VoitureDTO;
import com.example.shared.RemorquageDTO;
import com.example.voiture.entity.Voiture;
import com.example.voiture.mapper.MapToDto;
import com.example.voiture.repo.VoitureRepository;
import com.example.voiture.service.Iservice.IvoitureService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class VoitureServiceImpl implements IvoitureService {
    @Autowired
    VoitureRepository voitureRepo;
    @Autowired
    MapToDto mapToDto;
    @Autowired
    private RemorquageClient remorquageClient;
    @Autowired
    private RestTemplate restTemplate;

    private static final String STOCK_SERVICE_URL = "http://localhost:9999/api/remorquage";


    @Override
    public VoitureDTO getVoitureById(Long id) {
        Voiture voiture=voitureRepo.findById(id).get();
        RemorquageDTO remorquage=remorquageClient.getRemorquageById(voiture.getRemorquageId());
        VoitureDTO dto =mapToDto.maptoVoitureDTO(remorquage,voiture);
        return dto;
    }

//    @Override
//    public VoitureDTO saveVoiture(Voiture voiture) {
//
//        Voiture prod=voitureRepo.save(voiture);
//        Remorquage remorquage=remorquageClient.getRemorquageById(voiture.getRemorquageId());
//        VoitureDTO dto =mapToDto.maptoVoitureDTO(remorquage,prod);
//        return dto;
//    }
    public RemorquageDTO getRemorquageById(String remorquageId) {
        return restTemplate.getForObject(STOCK_SERVICE_URL + "/" + remorquageId, RemorquageDTO.class);
    }

    public VoitureDTO saveVoiture( Voiture voiture) {
        RemorquageDTO remorquage = getRemorquageById(voiture.getRemorquageId());
        Voiture prod=voitureRepo.save(voiture);
        VoitureDTO dto =mapToDto.maptoVoitureDTO(remorquage,prod);
        return dto;
    }

}
