package com.example.riskassessment.RC;

import com.example.riskassessment.DAO.Entities.Control;
import com.example.riskassessment.Services.Interfaces.IControlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

@RequestMapping("/Controles")
public class ControlC {
    private final IControlService ControleRest;

    @PostMapping("/addControle")
    Control ajouterControle(@RequestBody Control x){
        return ControleRest.addControle(x);
    }

    @PutMapping("/updateControle/{id}")
    Control updateControle(@PathVariable long id, @RequestBody Control updatedControl){
        return ControleRest.updateControle(id, updatedControl);
    }

    @DeleteMapping("/deleteControle")
    void deleteControle(Control x){
        ControleRest.deleteControle(x);
    }

    @DeleteMapping("/deleteControleById/{id}")
    void  deleteControleById(@PathVariable long id){
        ControleRest.deleteControle(id);
    }

    @GetMapping("/findAllControles/")
    List<Control> findAll(){
        return ControleRest.findAll();
    }

    @GetMapping("/findOneControleById/{id}")
    Control findById(@PathVariable long id){
        return ControleRest.findById(id);
    }

    @PostMapping("/linkCtrltoRisk")
    void linkCtrltoRisk(long idctrl, long idrisk){ ControleRest.linkCtrltoRisk(idctrl,idrisk); }
}
