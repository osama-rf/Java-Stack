package com.osama.projectmanger.services;

import com.osama.projectmanger.models.Project;
import com.osama.projectmanger.models.User;
import com.osama.projectmanger.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public List<Project> allProjects() {
        return projectRepository.findAll();
    }

    public List<Project> allProjectsNotContain(User user) {
        return projectRepository.findByMembersNotContaining(user);
    }

    public List<Project> allProjectsContain(User user) {
        return projectRepository.findByMembersContaining(user);
    }

    public List<Project> allProjectsByUser(User user) {
        return projectRepository.findByUser(user);
    }


    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // retrieves a project
    public Project findProject(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }


    public Project updateProject(Project project, Long id) {// update
        Project optionalProject = findProject(id);
        optionalProject.setTitle(project.getTitle());
        optionalProject.setDescription(project.getDescription());
        optionalProject.setDueDate(project.getDueDate());
        return projectRepository.save(optionalProject);
    }

    public void JoinProject(Project project, Long id, User user) {
        Project optionalProject = findProject(id);
        optionalProject.setMember((List<User>) user);
        projectRepository.save(optionalProject);
    }

    public void OutJoinProject(Project project, Long id, User user) {
        Project optionalProject = findProject(id);
        optionalProject.removeMember(user);
        projectRepository.save(optionalProject);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }


}
