package nl.novi.springboot.eindopdracht.controller;

import nl.novi.springboot.eindopdracht.GarageApplication;
import nl.novi.springboot.eindopdracht.model.Customer;
import nl.novi.springboot.eindopdracht.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.hamcrest.Matcher;

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

//werkt niet??
@WebMvcTest
@ContextConfiguration(classes={GarageApplication.class})
class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void testEndpointCustomers() throws Exception {

       Customer customer = new Customer();
       customer.setFirstName("Albert");
       customer.setLastName("Einstein");


        List<Customer> allCustomers = Arrays.asList(customer);

        given(customerService.getAllCustomers()).willReturn(allCustomers);

        mvc.perform(get("/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].lastName", is(customer.getLastName())));
    }

}