package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskerDaoTest {

    @Autowired
    private TaskerDao taskerDao;

    private Task task1, task2;

    @Before
    public void setUp() throws Exception {
        taskerDao.getAllTasks().forEach(t -> {
            taskerDao.deleteTask(t.getId());
        });

        task1 = new Task();
        task1.setDescription("Do This");
        task1.setCreateDate(LocalDate.of(2018, 06, 19));
        task1.setDueDate(LocalDate.of(2018, 06, 19));
        task1.setCategory("Must Do");

        task2 = new Task();
        task2.setDescription("Don't DO This");
        task2.setCreateDate(LocalDate.of(2018, 06, 19));
        task2.setDueDate(LocalDate.of(2018, 06, 19));
        task2.setCategory("Must NOT Do");
    }

    @Test
    public void getAddDeleteTask(){
        task1 = taskerDao.createTask(task1);

        Task taskTest = taskerDao.getTask(task1.getId());

        assertEquals(taskTest, task1);

        taskerDao.deleteTask(task1.getId());

        taskTest = taskerDao.getTask(task1.getId());

        assertNull(taskTest);

    }

    @Test
    public void getAllTasks() {
        task1 = taskerDao.createTask(task1);
        task2 = taskerDao.createTask(task2);

        List<Task> taskList = taskerDao.getAllTasks();

        assertEquals(2, taskList.size());
    }

    @Test
    public void getTasksByCategory() {
        task1 = taskerDao.createTask(task1);
        task2 = taskerDao.createTask(task2);

        List<Task> taskList = taskerDao.getTasksByCategory("Must Do");

        assertEquals(1, taskList.size());
    }

    @Test
    public void updateTask() {
        task1 = taskerDao.createTask(task1);
        task1.setDescription("Description");
        taskerDao.updateTask(task1);

        Task taskTest = taskerDao.getTask(task1.getId());

        assertEquals(taskTest, task1);
    }
}