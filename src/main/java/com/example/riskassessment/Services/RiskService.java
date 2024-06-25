package com.example.riskassessment.Services;
import com.example.riskassessment.DAO.Entities.*;
import com.example.riskassessment.DAO.Enumerations.riskLevel;
import com.example.riskassessment.DAO.Repositories.controlRepo;
import com.example.riskassessment.DAO.Repositories.riskRepo;
import com.example.riskassessment.DAO.Repositories.assetRepo;
import com.example.riskassessment.DAO.Repositories.vulnerabilityRepo;
import com.example.riskassessment.DAO.Repositories.threatRepo;
import com.example.riskassessment.DAO.Repositories.scenarioRepo;
import com.example.riskassessment.Exceptions.DuplicateRiskException;
import com.example.riskassessment.Services.Interfaces.IRiskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class RiskService implements IRiskService {
    private final assetRepo aRepo;
    private final riskRepo rRepo;
    private final vulnerabilityRepo vRepo;
    private final threatRepo tRepo;
    private final scenarioRepo sRepo;
    private final controlRepo cRepo;

    @Override
    public Risk addRisk(Risk r, long aid, long vid, long tid, long sid) {

        boolean exists = rRepo.duplicatesCheck(aid, vid, tid, sid);
        if (exists) {
            throw new DuplicateRiskException("A Risk with the same Asset ID, Vulnerability ID, Threat ID, and Scenario ID already exists.");
        }
        Asset a= aRepo.getReferenceById(aid);
        r.setAsset(a);

        Vulnerability v= vRepo.getReferenceById(vid);
        r.setVulnerability(v);

        Threat t= tRepo.getReferenceById(tid);
        r.setThreat(t);

        Scenario s= sRepo.getReferenceById(sid);
        r.setScenario(s);

        r.setInherentRiskScore(calcInherentRiskScore(r.getInherentProbability(), r.getInherentImpact()));
        r.setInherentRiskLevel(determineRiskLevel(r.getInherentRiskScore()));

        r.setRealRiskLevel(r.getInherentRiskLevel());
        r.setRealRiskScore(r.getInherentRiskScore());

        r.setResidualRiskLevel(r.getInherentRiskLevel());
        r.setRealRiskScore(r.getInherentRiskScore());

        return rRepo.save(r);
    }

    @Override
    public Risk findById(long id) {
        return rRepo.findById(id).orElseThrow(() -> new RuntimeException("Risk not found with id: " + id));
    }

    @Override
    @Transactional
    public List<Risk> findAll() {
     return  rRepo.findAllWithControls();
    }

    @Override
    public void deleteRisk(long id) {
        rRepo.deleteById(id);
    }

    @Override
    public void deleteRisk(Risk x) {
        rRepo.delete(x);
    }

    @Override
    public float calcInherentRiskScore(float vh, float ih) {
        return Math.max(0,vh * ih);
    }

    @Override
    public void calcRealRiskScore(Risk s) {
        List<Control> ls = s.getControlList();
        for (Control x : ls) {
            if (x.isExists()) {
                    s.setRealImpact(Math.max(0,s.getInherentImpact() - x.getValeurReductionImpact()));
                    s.setRealProbability(Math.max(0,s.getInherentProbability() - x.getValeurReductionProbabilite()));

            }
        }
        s.setRealRiskScore(s.getRealProbability() * s.getRealImpact());
        s.setRealRiskLevel(determineRiskLevel(s.getRealRiskScore()));
        rRepo.save(s);
    }

    @Override
    public void calcResidualRiskScore(Risk s) {
        List<Control> ls = s.getControlList();

        for (Control x : ls) {
            if (!x.isExists()) { // Si controle pas encore mis en place
                s.setResidualImpact(Math.max(0, s.getRealImpact() - x.getValeurReductionImpact()));
                s.setResidualProbability(Math.max(0, s.getRealProbability() - x.getValeurReductionProbabilite()));
            }
        }
        s.setResidualScore(s.getResidualProbability() * s.getResidualImpact());
        s.setResidualRiskLevel(determineRiskLevel(s.getResidualScore()));
        rRepo.save(s);
    }


    @Override
    public riskLevel determineRiskLevel(float riskscore) {
        if (riskscore <= 3) {
            return riskLevel.low;
        } else if (riskscore <= 8) {
            return riskLevel.medium;
        } else if (riskscore <= 19) {
            return riskLevel.high;
        } else if (riskscore <= 25) {
            return riskLevel.veryHigh;
        } else {
return null;        }
    }

    @Override
    public Risk updateRisk(long id, Risk updatedRisk) {
        Risk existingRisk = rRepo.findById(id).orElseThrow(() -> new RuntimeException("Risk not found with id: " + id));
        existingRisk.setInherentImpact(updatedRisk.getInherentImpact());
        existingRisk.setInherentProbability(updatedRisk.getInherentProbability());
        existingRisk.setRealImpact(updatedRisk.getRealImpact());
        existingRisk.setRealProbability(updatedRisk.getRealProbability());
        existingRisk.setResidualImpact(updatedRisk.getResidualImpact());
        existingRisk.setResidualProbability(updatedRisk.getResidualProbability());
        existingRisk.setInherentRiskScore(updatedRisk.getInherentRiskScore());
        existingRisk.setRealRiskScore(updatedRisk.getRealRiskScore());
        existingRisk.setResidualScore(updatedRisk.getResidualScore());
        existingRisk.setInherentRiskLevel(updatedRisk.getInherentRiskLevel());
        existingRisk.setRealRiskLevel(updatedRisk.getRealRiskLevel());
        existingRisk.setResidualRiskLevel(updatedRisk.getResidualRiskLevel());
        existingRisk.setControlList(updatedRisk.getControlList());
        return rRepo.save(existingRisk);
    }

    @Override
    public void linkRisktoCtrl(long idctrl, long idrisk) {
        Control control =cRepo.findById(idctrl).get(); //child
        Risk risk=rRepo.findById(idrisk).get();//parent
        //On affecte le child au parent
        risk.getControlList().add(control);

        calcRealRiskScore(risk);
        calcResidualRiskScore(risk);
        rRepo.save(risk);
    }

}