package com.osama.projectmanger.repositories;

import com.osama.projectmanger.models.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findAll();
}
