package com.example.remorquage.control;

import com.example.remorquage.RemorquageDTO.RemorquageDTO;
import com.example.remorquage.entity.Remorquage;
import com.example.remorquage.services.Iservice.IremorquageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/remorquage")
public class remorquageController {
    @Autowired
    IremorquageService remorquageS;

    @GetMapping("/{id}")
    public RemorquageDTO getRemorquageById(@PathVariable String id) {
        return remorquageS.getRemorquageById(id);
    }

    @PostMapping
    public RemorquageDTO createRemorquage(@RequestBody Remorquage remorquage) {
        return remorquageS.saveRemorquage(remorquage);
    }
}
