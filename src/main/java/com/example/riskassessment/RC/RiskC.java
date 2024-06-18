package com.example.riskassessment.RC;
import com.example.riskassessment.DAO.Entities.Risk;
import com.example.riskassessment.Services.Interfaces.IRiskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

@RequestMapping("/Risk")
public class RiskC {
    private final IRiskService riskRest;

    @PostMapping("/addRisk")
    Risk ajouterRisk(@RequestBody Risk r, @RequestParam long aid,@RequestParam long vid, @RequestParam long tid,@RequestParam long sid){
        return riskRest.addRisk(r, aid, vid,tid,sid);
    }

    @PutMapping("/updateRisk/{id}")
    Risk updateRisk(@PathVariable long id, @RequestBody Risk x){        return riskRest.updateRisk(id, x);}

    @DeleteMapping("/deleteRisk")
    void deleteRisk(Risk x){        riskRest.deleteRisk(x);}

    @DeleteMapping("/deleteRiskById/{id}")
    void  deleteRiskById(@PathVariable long id){        riskRest.deleteRisk(id);}

    @GetMapping("/findAllRisks/")
    List<Risk> findAll(){        return riskRest.findAll();}

    @GetMapping("/findOneRiskById/{id}")
    Risk findById(@PathVariable long id){        return riskRest.findById(id);}


    @PostMapping("/linkRisktoCtrl")
    void linkRisktoCtrl(long idctrl, long idrisk){
        riskRest.linkRisktoCtrl(idctrl, idrisk);
    }
}