package com.example.riskassessment.RC;

import com.example.riskassessment.DAO.Entities.Project;
import com.example.riskassessment.Services.Interfaces.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

@RequestMapping("/Project")
public class ProjectC {
    private final IProjectService projectRest;

    @PostMapping("/addProject")
    public Project ajouterProject(@RequestBody Project x){
        return projectRest.addProject(x);
    }

    @PutMapping("/updateProject/{id}")
    Project updateProject(@PathVariable long id, @RequestBody Project x){
        return projectRest.updateProject(id, x);
    }

    @DeleteMapping("/deleteProject")
    void deleteProject(Project x){
        projectRest.deleteProject(x);
    }

    @DeleteMapping("/deleteProjectById/{id}")
    void  deleteProjectById(@PathVariable long id){
        projectRest.deleteProject(id);
    }

    @GetMapping("/findAllProject/")
    List<Project> findAll(){
        return projectRest.findAll();
    }

    @GetMapping("/findOneProjectById/{id}")
    Project findById(@PathVariable long id){
        return projectRest.findById(id);
    }
    
}