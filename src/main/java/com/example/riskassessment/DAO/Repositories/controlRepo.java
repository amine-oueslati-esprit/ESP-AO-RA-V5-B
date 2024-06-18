package com.example.riskassessment.DAO.Repositories;

import com.example.riskassessment.DAO.Entities.Control;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface controlRepo extends JpaRepository<Control, Long> {
}