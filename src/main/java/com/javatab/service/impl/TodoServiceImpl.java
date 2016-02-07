package com.javatab.service.impl;

import com.javatab.domain.entity.Task;
import com.javatab.repository.TaskRepository;
import com.javatab.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nasir on 4/2/16.
 */
@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true)
public class TodoServiceImpl implements TodoService {

    private TaskRepository repository;

    @Autowired
    public TodoServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(
            propagation = Propagation.SUPPORTS,
            readOnly = false)
    public Task createTask(Task task) {
        return repository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public Task getTaskById(long id) {
        return repository.findOne(id);
    }

    @Override
    @Transactional(
            propagation = Propagation.SUPPORTS,
            readOnly = false)
    public void delete(long id) {
        repository.delete(id);
    }

}

