package com.example.riskassessment.Services.Interfaces;

import com.example.riskassessment.DAO.Entities.AssetType;

import java.util.List;

public interface IAssetTypeService {
    AssetType addAssetType(AssetType a);
    AssetType findById(long id);
    List<AssetType> findAll();
    AssetType updateAssetType(long id, AssetType AssetType);
    void deleteAssetType(long id);
    void deleteAssetType(AssetType a);
}