package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TaskerServiceLayerTest {

    TaskerServiceLayer service;
    TaskerDao taskerDao;
    AdClient adClient;

    @Before
    public void setUp() throws Exception {
        setUpTaskerDaoMock();
        setUpAdClientMock();

        service = new TaskerServiceLayer(adClient, taskerDao);
    }

    // =========== HELPER METHODS ===========

    public void setUpTaskerDaoMock() {
        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);
        Task task = new Task();
        task.setId(1);
        task.setDescription("Description");
        task.setCreateDate(LocalDate.of(2019,06, 19));
        task.setDueDate(LocalDate.of(2019,06, 19));
        task.setCategory("Category");

        Task task2 = new Task();
        task2.setDescription("Description");
        task2.setCreateDate(LocalDate.of(2019,06, 19));
        task2.setDueDate(LocalDate.of(2019,06, 19));
        task2.setCategory("Category");

        List<Task> tList = new ArrayList<>();
        tList.add(task);

        doReturn(task).when(taskerDao).createTask(task2);
        doReturn(task).when(taskerDao).getTask(1);
        doReturn(tList).when(taskerDao).getAllTasks();
        doReturn(tList).when(taskerDao).getTasksByCategory("Category");
    }

    public void setUpAdClientMock(){
        // Come back to this
        adClient = mock(AdClient.class);
        String str1 = "Home Equity Loans @ 3.87% APR";
//        String str2 = "Click HERE to qualify for a new car loan!";

        List<String> sList = new ArrayList<>();
        sList.add(str1);
//        sList.add(str2);

        Random rnd = new Random();

        String rndString = sList.get(rnd.nextInt(1));

        doReturn(rndString).when(adClient).getRandomAd();
    }

    // =========== TESTS ===========

    @Test
    public void newfetchTask() {
        // just needs to come in and leave as a tvm

        TaskViewModel tvm = new TaskViewModel();
//        tvm.setId(1);
        tvm.setDescription("Description");
        tvm.setCreateDate(LocalDate.of(2019,06, 19));
        tvm.setDueDate(LocalDate.of(2019,06, 19));
        tvm.setCategory("Category");
        tvm.setAdvertisement(adClient.getRandomAd());

        //THis is when we push in
        tvm =  service.newTask(tvm);

//        Task task = new Task();
//        task.setId(tvm.getId());
//        task.setDescription(tvm.getDescription());
//        task.setCreateDate(tvm.getCreateDate());
//        task.setDueDate(tvm.getDueDate());
//        task.setCategory(tvm.getCategory());

        assertEquals(1, tvm.getId());

        TaskViewModel created = service.newTask(tvm);
        tvm.setId(created.getId());

        assertEquals(tvm, created);


        // ==================================


        // add task
//        task = taskerDao.createTask(task);



//        TaskViewModel fromService = service.fetchTask(task.getId());
//
//        assertEquals(tvm, fromService);


    }

    @Test
    public void fetchAllTasks() {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(1);
        tvm.setDescription("Description");
        tvm.setCreateDate(LocalDate.of(2019,06, 19));
        tvm.setDueDate(LocalDate.of(2019,06, 19));
        tvm.setCategory("Category");
        tvm.setAdvertisement(adClient.getRandomAd());

         tvm = service.newTask(tvm);

        Task task = new Task();
        task.setDescription(tvm.getDescription());
        task.setCreateDate(tvm.getCreateDate());
        task.setDueDate(tvm.getDueDate());
        task.setCategory(tvm.getCategory());

        // add task
//        task = taskerDao.createTask(task);

        List<TaskViewModel> tList = service.fetchAllTasks();
        assertEquals(1, tList.size());
//        assertEquals(tvm, tList.get(0));
    }

    @Test
    public void fetchTasksByCategory() {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(1);
        tvm.setDescription("Description");
        tvm.setCreateDate(LocalDate.of(2019,06, 19));
        tvm.setDueDate(LocalDate.of(2019,06, 19));
        tvm.setCategory("Category");
        tvm.setAdvertisement(adClient.getRandomAd());

        tvm = service.newTask(tvm);

        Task task = new Task();
        task.setDescription(tvm.getDescription());
        task.setCreateDate(tvm.getCreateDate());
        task.setDueDate(tvm.getDueDate());
        task.setCategory(tvm.getCategory());

        // add task
//        task = taskerDao.createTask(task);

        List<TaskViewModel> tList = service.fetchTasksByCategory("Category");
        assertEquals(1, tList.size());
//        assertEquals(tvm, tList.get(0));
    }

    @Test
    public void updateTask() {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(1);
        tvm.setDescription("Description");
        tvm.setCreateDate(LocalDate.of(2019,06, 19));
        tvm.setDueDate(LocalDate.of(2019,06, 19));
        tvm.setCategory("Category");
//        tvm.setAdvertisement(adClient.getRandomAd());

        Task task = new Task();
        task.setId(tvm.getId());
        task.setDescription(tvm.getDescription());
        task.setCreateDate(tvm.getCreateDate());
        task.setDueDate(tvm.getDueDate());
        task.setCategory(tvm.getCategory());

//        task = taskerDao.createTask(task);

        /*
        You should only be hitting the Dao in the update
        and in the delete other wise you should
        only hit the service layer
         */

        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
        doNothing().when(taskerDao).updateTask(taskCaptor.capture());
        service.updateTask(tvm);
        verify(taskerDao, times(1)).updateTask(taskCaptor.getValue());
        Task task2 = taskCaptor.getValue();
        assertEquals(tvm.getId(), task2.getId());
//        assertTrue(task.equals(task2));
    }

    @Test
    public void updateTestTask() {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(1);
        tvm.setDescription("Description");
        tvm.setCreateDate(LocalDate.of(2019,06, 19));
        tvm.setDueDate(LocalDate.of(2019,06, 19));
        tvm.setCategory("Category");


        Task expectedTask = new Task();
        expectedTask.setId(1);
        expectedTask.setDescription("Description");
        expectedTask.setCreateDate(LocalDate.of(2019,06,19));
        expectedTask.setDueDate(LocalDate.of(2019,06,19));
        expectedTask.setCategory("Category");
        //to capture value service is passing to DAO
        //ArgumentCaptor<Task> captor = ArgumentCaptor.forClass(Task.class);

        //set a do-when if not in set up
        //doNothing().when(taskerDao).updateTask(captor.capture());

        //the method we are testing
        service.updateTask(tvm);
        //check that update task is called at least once
        //verify(taskerDao,times(1)).updateTask(captor.getValue());
        //assertEquals(expectedTask,captor.getValue());

        //alternately to both above tests, this verify will only pass if the method is called once w/expected Task values
        verify(taskerDao,times(1)).updateTask(expectedTask);

    }

    @Test
    public void deleteTask() {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(1);

        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(taskerDao).deleteTask(integerCaptor.capture());
        service.deleteTask(1);
        verify(taskerDao, times(1)).deleteTask(integerCaptor.getValue());
        assertEquals(1, integerCaptor.getValue().intValue());
    }
}