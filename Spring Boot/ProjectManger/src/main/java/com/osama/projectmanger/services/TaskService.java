package com.osama.projectmanger.services;

import com.osama.projectmanger.models.Project;
import com.osama.projectmanger.models.Task;
import com.osama.projectmanger.models.User;
import com.osama.projectmanger.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // returns all the projects
    public List<Task> allTasks() {
        return taskRepository.findAll();
    }

    // creates a project
    public Task createTask(Task b, User user, Project project) {
        b.setOwner(user);
        b.setProject(project);
        return taskRepository.save(b);
    }

}
