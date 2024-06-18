package com.example.riskassessment.Services.Interfaces;

import com.example.riskassessment.DAO.Entities.Asset;
import com.example.riskassessment.DAO.Entities.Risk ;
import com.example.riskassessment.DAO.Enumerations.riskLevel;

import java.util.List;

public interface IRiskService {
    public Risk addRisk(Risk r, long aid, long vid, long tid, long sid);
    Risk  findById(long id);
    List<Risk > findAll();
    Risk  updateRisk (long id, Risk  risk );
    void deleteRisk (long id);
    void deleteRisk (Risk  a);
    float calcInherentRiskScore(float vh, float ih);
    void calcRealRiskScore(Risk s);
    void calcResidualRiskScore(Risk s);
    riskLevel determineRiskLevel(float riskscore);
    void linkRisktoCtrl(long idctrl, long idrisk);

}
