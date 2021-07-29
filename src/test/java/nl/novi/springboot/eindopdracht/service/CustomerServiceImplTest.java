package nl.novi.springboot.eindopdracht.service;

import nl.novi.springboot.eindopdracht.model.Customer;
import nl.novi.springboot.eindopdracht.model.Employee;
import nl.novi.springboot.eindopdracht.repository.CustomerRepository;
import nl.novi.springboot.eindopdracht.repository.EmployeeRepository;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    @Mock
    Customer customer;

    @BeforeEach
    public void setUp(){}

    @Test
    void getAllCustomers() {
    }

    @Test
    void testGetCustomersByName() {
        customer = new Customer("Albert", "Einstein", "123456789", "Albert.Einstein@email.com", 1L);

        Mockito
                .when(customerRepository.findByLastName(customer.getLastName()))
                .thenReturn(customer);

        String name = "Einstein";
        String expected = "Albert Einstein";

        Customer found = customerService.getCustomerByLastName(name);

        assertEquals(expected, found.getFullName());
    }


}