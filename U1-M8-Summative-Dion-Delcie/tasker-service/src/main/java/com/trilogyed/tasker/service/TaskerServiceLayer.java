package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    @Autowired
    private AdClient client;

    TaskerDao dao;

    @Autowired
    public TaskerServiceLayer(AdClient client, TaskerDao dao) {
        this.client = client;
        this.dao = dao;
    }


    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());

        // TODO - get ad from Adserver and put in tvm
        tvm.setAdvertisement(client.getRandomAd());

        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task> tList = dao.getAllTasks();
        List<TaskViewModel> tvmList = new ArrayList<>();
        // ...
        for (Task task: tList) {
            TaskViewModel tvm = buildTaskViewModel(task);
            tvmList.add(tvm);
        }

        return tvmList;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> tList = dao.getTasksByCategory(category);
        List<TaskViewModel> tvmList = new ArrayList<>();
        // ...
        for (Task task: tList) {
            TaskViewModel tvm = buildTaskViewModel(task);
            tvmList.add(tvm);
        }
        return tvmList;
    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getId());

        // TODO - get ad from Adserver and put in taskViewModel
        taskViewModel.setAdvertisement(client.getRandomAd());

        return taskViewModel;
    }

    public void deleteTask(int id) {
        // Maybe add functionality to delete ads too? Not sure?
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setId(taskViewModel.getId());
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
//            if (taskViewModel.getId() == task.getId()) {
                dao.updateTask(task);

//            }
    }

    private TaskViewModel buildTaskViewModel(Task task) {

        TaskViewModel tvm = new TaskViewModel();
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        tvm.setAdvertisement(client.getRandomAd());

        return tvm;

    }
}
