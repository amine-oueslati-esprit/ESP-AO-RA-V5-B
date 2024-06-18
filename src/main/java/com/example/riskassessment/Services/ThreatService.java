package com.example.riskassessment.Services;

import com.example.riskassessment.DAO.Entities.Threat;
import com.example.riskassessment.DAO.Repositories.threatRepo;
import com.example.riskassessment.Services.Interfaces.IThreatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ThreatService implements IThreatService {
    private final threatRepo mRepo;

    @Override
    public Threat addMenace(Threat a) {
        return mRepo.save(a);
    }

    @Override
    public Threat findById(long id) {return mRepo.findById(id).get();
    }

    @Override
    public List<Threat> findAll() {
        return mRepo.findAll();
    }

    @Override
    public void deleteMenace(long id) {
        mRepo.deleteById(id);
    }

    @Override
    public void deleteMenace(Threat a) {
        mRepo.delete(a);
    }

    @Override
    public void affecterMenaceAVuln(long idvuln, long idmenace) {
    }

    @Override
    public Threat updateMenace(long id, Threat updatedThreat) {
        return null;
    }

}
