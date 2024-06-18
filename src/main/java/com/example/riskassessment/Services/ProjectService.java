package com.example.riskassessment.Services;

import com.example.riskassessment.DAO.Entities.Project;
import com.example.riskassessment.DAO.Repositories.projectRepo;
import com.example.riskassessment.Services.Interfaces.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService implements IProjectService {
    private final projectRepo pRepo;

    @Override
    public Project addProject(Project x) {
        return pRepo.save(x);
    }

    @Override
    public Project findById(long id) {
        return pRepo.findById(id).orElse(null);
    }

    @Override
    public List<Project> findAll() {
        return pRepo.findAll();
    }

    @Override
    public Project updateProject(long id, Project updatedProject) {
        return null;
    }

    @Override
    public void deleteProject(long id) {pRepo.deleteById(id);    }

    @Override
    public void deleteProject(Project x) {pRepo.delete(x);    }
}