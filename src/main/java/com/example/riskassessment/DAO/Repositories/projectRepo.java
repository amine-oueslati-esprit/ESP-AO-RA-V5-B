package com.example.riskassessment.DAO.Repositories;

import com.example.riskassessment.DAO.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface projectRepo extends JpaRepository<Project, Long> {

}
