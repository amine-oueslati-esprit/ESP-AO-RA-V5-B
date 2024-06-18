package com.example.riskassessment.Services.Interfaces;
import com.example.riskassessment.DAO.Entities.Asset;

import java.util.List;

public interface IAssetService {
    Asset addActif(Asset a);
    Asset findById(long id);
    List<Asset> findAll();
    Asset updateActif(long id, Asset asset);
    void deleteActif(long id);
    void deleteActif(Asset a);
    void setRiskAsset(long ididasset, long idrisk);

}