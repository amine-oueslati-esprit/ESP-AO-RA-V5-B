package com.example.riskassessment.DAO.Repositories;

import com.example.riskassessment.DAO.Entities.AssetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface assetTypeRepo extends JpaRepository<AssetType, Long> {
}