package nl.novi.springboot.eindopdracht.repository;

import nl.novi.springboot.eindopdracht.GarageApplication;
import nl.novi.springboot.eindopdracht.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ContextConfiguration(classes={GarageApplication.class})
class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Test
    void findByLastNameIs() {
       Employee employee = new Employee(1, "Timo", "Tester","0123456789", "mechanic", "TimoTester@email.com");


       Employee found = employeeRepository.findByLastName(employee.getLastName());

       String expected = "Tester";
       String actual = found.getLastName();
       assertEquals(expected, actual);
    }
}


