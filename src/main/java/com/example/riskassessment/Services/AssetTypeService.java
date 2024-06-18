package com.example.riskassessment.Services;

import com.example.riskassessment.DAO.Entities.AssetType;
import com.example.riskassessment.DAO.Repositories.assetTypeRepo;
import com.example.riskassessment.Services.Interfaces.IAssetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetTypeService implements IAssetTypeService {
    private final assetTypeRepo atRepo;

    @Override
    public AssetType addAssetType(AssetType x) {
        return atRepo.save(x);
    }

    @Override
    public AssetType findById(long id) {
        return atRepo.findById(id).orElse(null);
    }

    @Override
    public List<AssetType> findAll() {
        return atRepo.findAll();
    }

    @Override
    public AssetType updateAssetType(long id, AssetType updatedAssetType) {
        return null;
    }

    @Override
    public void deleteAssetType(long id) { atRepo.deleteById(id);   }

    @Override
    public void deleteAssetType(AssetType x) { atRepo.delete(x);    }
}