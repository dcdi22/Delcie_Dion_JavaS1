package com.trilogyed.stwitter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.stwitter.service.ServiceLayer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(StwitterController.class)
public class StwitterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ServiceLayer service;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void getPostReturnWithJson() {
    }

    @Test
    public void getPostReturn404() {
    }

    @Test
    public void getPostsForPosterReturnWithJson() {
    }

    @Test
    public void createComment() {
    }

    @Test
    public void createPost() {
    }
}