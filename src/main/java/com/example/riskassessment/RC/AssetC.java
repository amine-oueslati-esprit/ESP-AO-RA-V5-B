package com.example.riskassessment.RC;
import com.example.riskassessment.DAO.Entities.Asset;
import com.example.riskassessment.Services.Interfaces.IAssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/Actifs")

public class AssetC {
    private final IAssetService actifRest;

    @PostMapping("/addActif")
    public Asset ajouterActif(@RequestBody Asset x){

        return actifRest.addActif(x);
    }

    @PutMapping("/updateActif/{id}")
    Asset updateActif(@PathVariable long id, @RequestBody Asset x){
        return actifRest.updateActif(id, x);
    }

    @DeleteMapping("/deleteActif")
    void deleteActif(Asset x){
        actifRest.deleteActif(x);
    }

    @DeleteMapping("/deleteActifById/{id}")
    void  deleteActifById(@PathVariable long id){
        actifRest.deleteActif(id);
    }

    @GetMapping("/findAllActifs/")
    List<Asset> findAll(){
        return actifRest.findAll();
    }

    @GetMapping("/findOneActifById/{id}")
    Asset findById(@PathVariable long id){
        return actifRest.findById(id);
    }

    @PutMapping("/setRiskAsset")
    void setRiskAsset(@RequestParam long idasset, @RequestParam long idrisk) {
        actifRest.setRiskAsset(idasset,idrisk);
    }

}