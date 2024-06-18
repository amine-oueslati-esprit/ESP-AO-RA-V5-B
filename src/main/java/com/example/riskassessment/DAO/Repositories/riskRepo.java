package com.example.riskassessment.DAO.Repositories;
import com.example.riskassessment.DAO.Entities.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface riskRepo extends JpaRepository<Risk, Long> {
    @Query("SELECT r FROM Risk r LEFT JOIN FETCH r.controlList")
    List<Risk> findAllWithControls();
}