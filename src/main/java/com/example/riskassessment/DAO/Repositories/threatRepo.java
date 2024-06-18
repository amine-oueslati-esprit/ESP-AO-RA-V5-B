package com.example.riskassessment.DAO.Repositories;

import com.example.riskassessment.DAO.Entities.Threat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface threatRepo extends JpaRepository<Threat, Long> {
}
