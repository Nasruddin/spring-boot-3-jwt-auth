package com.javatab.service;

import com.javatab.domain.entity.Task;

import java.util.List;

/**
 * Created by nasir on 4/2/16.
 */
public interface TodoService {

    Task createTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(long id);

    void delete(long id);
}
