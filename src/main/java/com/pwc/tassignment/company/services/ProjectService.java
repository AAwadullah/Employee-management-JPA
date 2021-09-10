package com.pwc.tassignment.company.services;


import com.pwc.tassignment.company.entities.Project;
import com.pwc.tassignment.company.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project create(Project project) {
        return projectRepository.saveAndFlush(project);
    }

    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    public Project update(Project project) {
        return projectRepository.save(project);
    }


    public void deleteById(Long projectID){
        projectRepository.deleteById(projectID);
    }

    public Project findProjectById(Long Id) {
        Optional<Project> project = projectRepository.findById(Id);

        if (project.isPresent()) {
            return project.get();
        } else {
            throw new RuntimeException("Project id not found, ID = " + Id);
        }
    }
}
