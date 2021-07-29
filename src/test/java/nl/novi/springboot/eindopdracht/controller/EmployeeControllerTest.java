package nl.novi.springboot.eindopdracht.controller;

import nl.novi.springboot.eindopdracht.GarageApplication;
import nl.novi.springboot.eindopdracht.model.Employee;
import nl.novi.springboot.eindopdracht.service.EmployeeService;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;
/*
@WebMvcTest
@ContextConfiguration(classes = {GarageApplication.class})
class EmployeeControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService service;

    @Test
    void testGetEmployees() throws Exception{

        Employee employee = new Employee(5, "Timo", "Tester", "0123456789","mechanic", "TimoTester@email.com" );
        List<Employee> allEmployees = Arrays.asList(employee);

        given(service.getAllEmployees()).willReturn(allEmployees);

        mvc.perform(get("/Employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].lastname", is(employee.getLastName())));
    }


    @Test
    void getEmployeeById() {
    }

    @Test
    void deleteEmployee() {
    }

    @Test
    void addEmployee() {
    }
}*/