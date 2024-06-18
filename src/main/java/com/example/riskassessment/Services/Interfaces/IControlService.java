package com.example.riskassessment.Services.Interfaces;
import com.example.riskassessment.DAO.Entities.Control;

import java.util.List;

public interface IControlService {
    Control addControle(Control x);
    Control findById(long id);
    List<Control> findAll();
    void deleteControle(long id);
    void deleteControle(Control x);
    Control updateControle(long id, Control updatedControl);

    void calcEfficaciteCtrl(Control x);

    void linkCtrltoRisk(long idctrl, long idrisk);

    float calcValRedImpact(Control x);
    float calcValRedProbabilite(Control x);
}