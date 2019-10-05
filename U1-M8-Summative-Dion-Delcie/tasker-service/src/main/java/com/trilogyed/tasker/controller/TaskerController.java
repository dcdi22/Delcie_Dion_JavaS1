package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import com.trilogyed.tasker.util.feign.AdClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
@RequestMapping(value = "/tasks")
public class TaskerController {



    @Autowired
    TaskerServiceLayer service;

    // =========== CREATE TASK ===========

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public TaskViewModel newTask(@RequestBody @Valid TaskViewModel tvm) {
        return service.newTask(tvm);
    }

    // =========== FIND ALL TASKS ===========

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> fetchAllTasks() {
        return service.fetchAllTasks();
    }

    // =========== FIND TASKS BY CATEGORY ===========

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TaskViewModel> fetchTasksByCategory(@PathVariable String category) {
        return service.fetchTasksByCategory(category);
    }

    // =========== FIND TASKS BY ID ===========

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TaskViewModel fetchTask(@PathVariable int id) {
        return service.fetchTask(id);
    }

    // =========== UPDATE TASK ===========

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTask(@RequestBody @Valid TaskViewModel tvm, @PathVariable int id) {
        tvm.setId(id);
        service.updateTask(tvm);
    }

    @RequestMapping(value = "/tasks{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }
}
