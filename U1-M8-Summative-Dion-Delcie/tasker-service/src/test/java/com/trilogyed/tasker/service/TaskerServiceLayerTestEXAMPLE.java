package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
public class TaskerServiceLayerTestEXAMPLE {

    @InjectMocks
    TaskerServiceLayer service;
    @Mock
    TaskerDao taskerDao;
    @Mock
    AdClient adClient;

    // Client ~> Controller <~ (VM) ~> Service ~> (DTO ~> DAO <~ ResultSet ~> DB

    // Mocking I will create a fake object I would except to see from the database



    @Before
    public void setUp() throws Exception {
        // Use if you want to comment out the annotation @RunWith(MockitoJUnitRunner.class)
        MockitoAnnotations.initMocks(this);
        setUpTaskerDaoMock();
        setUpAdClientMock();

//        service = new TaskerServiceLayer(adClient, taskerDao);
//        MockitoAnnotations.initMocks(this);
    }

    // =========== HELPER METHODS ===========

    public void setUpTaskerDaoMock() {
//        taskerDao = mock(TaskerDaoJdbcTemplateImpl.class);
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
//        adClient = mock(AdClient.class);
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

        Task task = new Task();
//        task.setId(tvm.getId());
        task.setDescription(tvm.getDescription());
        task.setCreateDate(tvm.getCreateDate());
        task.setDueDate(tvm.getDueDate());
        task.setCategory(tvm.getCategory());


        // add task
        task = taskerDao.createTask(task);


//        TaskViewModel tvm2

        TaskViewModel fromService = service.fetchTask(task.getId());

        assertEquals(tvm, fromService);


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

//        service.newTask(tvm);

        Task task = new Task();
        task.setDescription(tvm.getDescription());
        task.setCreateDate(tvm.getCreateDate());
        task.setDueDate(tvm.getDueDate());
        task.setCategory(tvm.getCategory());

        // add task
        task = taskerDao.createTask(task);

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

//        service.newTask(tvm);

        Task task = new Task();
        task.setDescription(tvm.getDescription());
        task.setCreateDate(tvm.getCreateDate());
        task.setDueDate(tvm.getDueDate());
        task.setCategory(tvm.getCategory());

        // add task
        task = taskerDao.createTask(task);

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

        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
        doNothing().when(taskerDao).updateTask(taskCaptor.capture());
        service.updateTask(tvm);
        verify(taskerDao, times(1)).updateTask(taskCaptor.getValue());
        Task task2 = taskCaptor.getValue();
        assertEquals(tvm.getId(), task2.getId());
//        assertTrue(task.equals(task2));
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