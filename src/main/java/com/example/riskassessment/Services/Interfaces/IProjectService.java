package com.example.riskassessment.Services.Interfaces;

import com.example.riskassessment.DAO.Entities.Project;

import java.util.List;

public interface IProjectService {
    Project addProject(Project a);
    Project findById(long id);
    List<Project> findAll();
    Project updateProject(long id, Project project);
    void deleteProject(long id);
    void deleteProject(Project a);
}