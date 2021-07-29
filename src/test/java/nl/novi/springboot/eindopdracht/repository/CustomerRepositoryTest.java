package nl.novi.springboot.eindopdracht.repository;

import nl.novi.springboot.eindopdracht.GarageApplication;
import nl.novi.springboot.eindopdracht.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes={GarageApplication.class})
class CustomerRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void findByLastNameIs() {
        Customer customer = new Customer("Tessa"," Test", "123456789", "TessaTest@email.com", 5L);
        entityManager.persist(customer);
        entityManager.flush();

        Customer found = customerRepository.findByLastName(customer.getLastName());

        String expected = "Test";
        String actual = found.getLastName();
        assertEquals(expected, actual);
    }

}