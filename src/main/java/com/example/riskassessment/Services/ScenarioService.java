package com.example.riskassessment.Services;

import com.example.riskassessment.DAO.Entities.Scenario;
import com.example.riskassessment.DAO.Repositories.scenarioRepo;
import com.example.riskassessment.Services.Interfaces.IScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScenarioService implements IScenarioService {
    private final scenarioRepo sRepo;

    @Override
    public Scenario addScenario(Scenario x) {
        return null;
    }

    @Override
    public Scenario findById(long id) {
        return null;
    }

    @Override
    public List<Scenario> findAll() {
        return List.of();
    }

    @Override
    public Scenario updateScenario(long id, Scenario updatedScenario) {
        return null;
    }

    @Override
    public void deleteScenario(long id) {

    }

    @Override
    public void deleteScenario(Scenario x) {

    }
}