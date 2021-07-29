package nl.novi.springboot.eindopdracht.service;

import nl.novi.springboot.eindopdracht.model.Customer;
import nl.novi.springboot.eindopdracht.repository.CustomerRepository;
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