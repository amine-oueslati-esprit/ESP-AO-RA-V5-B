package com.example.riskassessment.RC;

import com.example.riskassessment.DAO.Entities.AssetType;
import com.example.riskassessment.Services.Interfaces.IAssetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

@RequestMapping("/AssetTypes")
public class AssetTypeC {
    private final IAssetTypeService assetTypeRest;

    @PostMapping("/addAssetType")
    public AssetType ajouterAssetType(@RequestBody AssetType x){
        return assetTypeRest.addAssetType(x);
    }

    @PutMapping("/updateAssetType/{id}")
    AssetType updateAssetType(@PathVariable long id, @RequestBody AssetType x){
        return assetTypeRest.updateAssetType(id, x);
    }

    @DeleteMapping("/deleteAssetType")
    void deleteAssetType(AssetType x){
        assetTypeRest.deleteAssetType(x);
    }

    @DeleteMapping("/deleteAssetTypeById/{id}")
    void  deleteAssetTypeById(@PathVariable long id){
        assetTypeRest.deleteAssetType(id);
    }

    @GetMapping("/findAllAssetTypes/")
    List<AssetType> findAll(){
        return assetTypeRest.findAll();
    }

    @GetMapping("/findOneAssetTypeById/{id}")
    AssetType findById(@PathVariable long id){
        return assetTypeRest.findById(id);
    }

}