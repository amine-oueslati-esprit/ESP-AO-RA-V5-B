package com.example.riskassessment.Services.Interfaces;

import com.example.riskassessment.DAO.Entities.Threat;

import java.util.List;

public interface IThreatService {
    Threat addMenace(Threat a);
    Threat findById(long id);
    List<Threat> findAll();
    Threat updateMenace(long id, Threat updatedThreat);
    void deleteMenace(long id);
    void deleteMenace(Threat a);
    void affecterMenaceAVuln(long idvuln, long idmenace);
}
