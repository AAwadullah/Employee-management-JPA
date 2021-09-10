package com.pwc.tassignment.company.services;


import com.pwc.tassignment.company.entities.Project;
import com.pwc.tassignment.company.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectsRepository projectsRepository;

    public Project create(Project project) {
        return projectsRepository.saveAndFlush(project);
    }

    public List<Project> findAllProjects() {
        return projectsRepository.findAll();
    }

    public Project update(Project project) {
        return projectsRepository.save(project);
    }


    public void deleteById(Long projectID){
        projectsRepository.deleteById(projectID);
    }

    public Project findProjectById(Long Id) {
        Optional<Project> project = projectsRepository.findById(Id);

        if (project.isPresent()) {
            return project.get();
        } else {
            throw new RuntimeException("Project id not found, ID = " + Id);
        }
    }
}
