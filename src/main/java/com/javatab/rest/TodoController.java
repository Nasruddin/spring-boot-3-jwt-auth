package com.javatab.rest;

import com.javatab.domain.entity.Task;
import com.javatab.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nasir on 4/2/16.
 */
@RestController
@RequestMapping("${javatab.route.todo}")
public class TodoController extends BaseController{

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Task>> getAllTask() {

        List<Task> tasks = todoService.getAllTasks();

        if (tasks.size() <= 0) {
            logger.info("Data is empty? No task found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> getTask(@PathVariable("id") long id) {

        Task task = todoService.getTaskById(id);

        if (task == null) {
            logger.info("Unable to fetch task with id - {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> createTask(@RequestBody Task task) {

        if (task.getTask() == null || StringUtils.isEmpty(task.getTask())) {
            logger.info("Unable to create task with empty task", task);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Task savedTask = todoService.createTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteTask(@PathVariable("id") long id) {

        Task task = todoService.getTaskById(id);
        if (task == null) {
            logger.info("Unable to find task with id - {}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        todoService.delete(id);

        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

}
