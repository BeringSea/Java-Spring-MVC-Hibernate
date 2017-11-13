package com.springboot.service;

import com.springboot.DAO.TaskRepository;
import com.springboot.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 2017-11-09.
 */
@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll(){
        List<Task> tasks = new ArrayList<>();
        for (Task task : taskRepository.findAll()) {
            tasks.add(task);
        }
        return tasks;
    }

    public void save(Task task){
        taskRepository.save(task);
    }

    public Task findTask(int id){
        return taskRepository.findOne(id);
    }

    public void delete(int id){
        taskRepository.delete(id);
    }
}
