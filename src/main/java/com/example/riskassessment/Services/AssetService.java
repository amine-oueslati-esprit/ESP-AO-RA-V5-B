package com.example.riskassessment.Services;

import com.example.riskassessment.DAO.Entities.Asset;
import com.example.riskassessment.DAO.Entities.Risk;
import com.example.riskassessment.DAO.Repositories.assetRepo;
import com.example.riskassessment.DAO.Repositories.riskRepo;
import com.example.riskassessment.Services.Interfaces.IAssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetService implements IAssetService {
    private final assetRepo aRepo;
    private final riskRepo rRepo;

    @Override
    public Asset addActif(Asset a) {return aRepo.save(a);}


    @Override
    public Asset findById(long id) {return aRepo.findById(id).get();
    }

    @Override
    public List<Asset> findAll() {
        return aRepo.findAll();
    }

    @Override
    public Asset updateActif(long id, Asset asset) {
        return null;
    }

    @Override
    public void deleteActif(long id) {
        aRepo.deleteById(id);
    }

    @Override
    public void deleteActif(Asset a) {
        aRepo.delete(a);
    }

    @Override
    public void setRiskAsset(long idasset, long idrisk) {
        Asset asset = aRepo.findById(idasset).get(); //child
        Risk risk= rRepo.findById(idrisk).get();//parent
        risk.setAsset(asset);
        rRepo.save(risk);
    }
}