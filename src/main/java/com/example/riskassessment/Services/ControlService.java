package com.example.riskassessment.Services;

import com.example.riskassessment.DAO.Entities.Control;
import com.example.riskassessment.DAO.Entities.Risk;
import com.example.riskassessment.DAO.Repositories.controlRepo;
import com.example.riskassessment.DAO.Repositories.riskRepo;
import com.example.riskassessment.Services.Interfaces.IControlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ControlService implements IControlService {
    private final controlRepo cRepo;
    private final riskRepo rRepo;

    @Override
    public Control addControle(Control x) {
        cRepo.save(x);
        calcEfficaciteCtrl(x);
        calcValRedImpact(x);
        calcValRedProbabilite(x);
        return cRepo.save(x);
    }

    @Override
    public Control findById(long id) {
        return cRepo.findById(id).get();
    }

    @Override
    public List<Control> findAll() { return cRepo.findAll();}


    @Override
    public Control updateControle(long id, Control updatedControl) {
        Control existingControl = cRepo.findById(id).orElseThrow(() -> new RuntimeException("Control not found with id: " + id));
        existingControl.setControlCategory(updatedControl.getControlCategory());
        existingControl.setConception(updatedControl.getConception());
        existingControl.setPerformance(updatedControl.getPerformance());
        existingControl.setEfficacite(updatedControl.getEfficacite());
        existingControl.setPonderationSurImpact(updatedControl.getPonderationSurImpact());
        existingControl.setPonderationSurProbabilite(updatedControl.getPonderationSurProbabilite());
        existingControl.setValeurReductionImpact(updatedControl.getValeurReductionImpact());
        existingControl.setValeurReductionProbabilite(updatedControl.getValeurReductionProbabilite());
        existingControl.setExists(updatedControl.isExists());
        return cRepo.save(existingControl);
    }
    @Override
    public void deleteControle(long id) { cRepo.deleteById(id);    }

    @Override
    public void deleteControle(Control x) { cRepo.delete(x);    }

    @Override
    public void calcEfficaciteCtrl(Control x) {
        x.setEfficacite(x.getConception()*x.getPerformance());
        cRepo.save(x);
    }

    @Override
    public void linkCtrltoRisk(long idctrl, long idrisk) {
        Control control =cRepo.findById(idctrl).get(); //child
        Risk risk=rRepo.findById(idrisk).get();//parent
        //On affecte le child au parent
        risk.getControlList().add(control);
    }

    @Override
    public float calcValRedImpact(Control x) {
        x.setValeurReductionImpact((x.getEfficacite()*x.getPonderationSurImpact())/4);
        cRepo.save(x);
        return x.getValeurReductionImpact();
    }

    @Override
    public float calcValRedProbabilite(Control x) {
        x.setValeurReductionProbabilite((x.getEfficacite()*x.getPonderationSurProbabilite())/4);
        cRepo.save(x);
        return x.getValeurReductionProbabilite();
    }
}