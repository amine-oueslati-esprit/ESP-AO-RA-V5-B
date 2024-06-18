package com.example.riskassessment.RC;

import com.example.riskassessment.DAO.Entities.Threat;
import com.example.riskassessment.Services.Interfaces.IThreatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/Menace")
public class ThreatC {
    private final IThreatService menaceService;

    @PostMapping("/addMenace")
    Threat ajouterMenace(@RequestBody Threat threat) {
        return menaceService.addMenace(threat) ;
    }

    @DeleteMapping("/deleteMenace")
    void deleteMenace(@RequestBody Threat threat) {
        menaceService.deleteMenace(threat);
    }

    @DeleteMapping("/deleteMenaceById/{id}")
    void deleteMenaceById(@PathVariable long id) {
        menaceService.deleteMenace(id);
    }

    @GetMapping("/findAllMenaces")
    List<Threat> findAll() {
        return menaceService.findAll();
    }

    @GetMapping("/findMenaceById/{id}")
    Threat findById(@PathVariable long id) {
        return menaceService.findById(id);
    }

    @PutMapping("/updateMenace/{id}")
    Threat updateMenace(@PathVariable long id, @RequestBody Threat updatedThreat) {
        return menaceService.updateMenace(id, updatedThreat);
    }
}
