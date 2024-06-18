package com.example.riskassessment.DAO.Repositories;
import com.example.riskassessment.DAO.Entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface assetRepo extends JpaRepository<Asset, Long> {

}