package com.company.DelcieDionU1Capstone.controller;

import com.company.DelcieDionU1Capstone.dao.ConsoleDao;
import com.company.DelcieDionU1Capstone.dto.Console;
import com.company.DelcieDionU1Capstone.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
//    private ServiceLayer service;
    private ConsoleDao consoleDao;

    @MockBean
    private ServiceLayer service;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    // ==================================================

    @Test
    public void getConsoleReturnWithJson() throws Exception {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("Memory");
        console.setProcessor("Processor");
        console.setPrice(new BigDecimal("50.00"));
        console.setQuantity(2);
        console.setConsoleId(8);

        // Since findById returns an Optional, we create one with our console object as the value
//        Optional<Console> returnVal = Optional.of(console);

        // Object to JSON in String
        // Basically acts as mapRow converting data into something readable
        String outputJson = mapper.writeValueAsString(console);

        // Mocking DAO response
        // doReturn(returnVal.get()).when(service).getConsole(8);

        // ====================================================
//        when(consoleDao.getConsole(8)).thenReturn(returnVal.get());
         when(service.getConsole(8)).thenReturn(console);
        // ====================================================

        this.mockMvc.perform(get("/console/8"))
                .andDo(print())
                .andExpect(status().isOk())
                // use objectMapper output with the json method
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getConsoleThatDoesNotExistReturns404() throws Exception {

//        Optional<Console> returnVal = Optional.empty();
        Console console = new Console();
//        Object empty = new Object();

        int idForConsoleThatDoesNotExist = 100;

        when(service.getConsole(idForConsoleThatDoesNotExist)).thenReturn(console);

        this.mockMvc.perform(get("/console/" + idForConsoleThatDoesNotExist))
                .andDo(print())
                .andExpect(status().isNotFound());

    }




    // ==================================================

    @Test
    public void addConsole() throws Exception {
        Console inConsole = new Console();
        inConsole.setModel("PS4");
        inConsole.setManufacturer("Sony");
        inConsole.setMemoryAmount("Memory");
        inConsole.setProcessor("Processor");
        inConsole.setPrice(new BigDecimal("50.00"));
        inConsole.setQuantity(2);

        String inputJson = mapper.writeValueAsString(inConsole);

        Console outConsole = new Console();
        outConsole.setModel("PS4");
        outConsole.setManufacturer("Sony");
        outConsole.setMemoryAmount("Memory");
        outConsole.setProcessor("Processor");
        outConsole.setPrice(new BigDecimal("50.00"));
        outConsole.setQuantity(2);
        outConsole.setConsoleId(8);

        String outputJson = mapper.writeValueAsString(outConsole);

        when(service.addConsole(inConsole)).thenReturn(outConsole);

        this.mockMvc.perform(post("/console")
        .content(inputJson)
        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllConsoles() throws Exception {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("Memory");
        console.setProcessor("Processor");
        console.setPrice(new BigDecimal("50.00"));
        console.setQuantity(2);
        console.setConsoleId(8);

        Console console2 = new Console();
        console2.setModel("PS4");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("Memory");
        console2.setProcessor("Processor");
        console2.setPrice(new BigDecimal("50.00"));
        console2.setQuantity(2);
        console2.setConsoleId(9);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);
        consoleList.add(console2);

        //Object to json in String
        when(service.getAllConsoles()).thenReturn(consoleList);

        List<Console> listChecker = new ArrayList<>();
        listChecker.addAll(consoleList);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/console"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getConsoleByManufacturer() throws Exception {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("Memory");
        console.setProcessor("Processor");
        console.setPrice(new BigDecimal("50.00"));
        console.setQuantity(2);
        console.setConsoleId(8);

        Console console2 = new Console();
        console2.setModel("PS4");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("Memory");
        console2.setProcessor("Processor");
        console2.setPrice(new BigDecimal("50.00"));
        console2.setQuantity(2);
        console2.setConsoleId(9);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(console);
        consoleList.add(console2);

        //Object to json in String
        when(service.getConsoleByManufacturer("Sony")).thenReturn(consoleList);

        List<Console> listChecker = new ArrayList<>();
        listChecker.addAll(consoleList);

        String outputJson = mapper.writeValueAsString(listChecker);

        this.mockMvc.perform(get("/console/GetManufacturer/Sony"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void updateConsole() throws Exception {
        Console console = new Console();
        console.setModel("PS4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("Memory");
        console.setProcessor("Processor");
        console.setPrice(new BigDecimal("50.00"));
        console.setQuantity(2);
        console.setConsoleId(8);

        // keep the same
        String inputJson = mapper.writeValueAsString(console);
        String outputJson = mapper.writeValueAsString(console);

        this.mockMvc.perform(put("/console/8")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void deleteConsole() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/console/8"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }
}