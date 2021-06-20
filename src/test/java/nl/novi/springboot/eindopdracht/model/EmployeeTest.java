package nl.novi.springboot.eindopdracht.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

        private Employee employee;
    @BeforeEach
    void setUp(){
        this.employee = new Employee();
        this.employee.setFirstName("Timo");
        this.employee.setLastName("Tester");
        this.employee.setRole("mechanic");
        this.employee.setPhoneNumber("1234567890");
        this.employee.setEmail("TimoTester@email.com");
    }


    @Test
    void getLastName() {
        String expectedLastName = "Tester";
        String actualLastName = this.employee.getLastName();
        assertEquals(expectedLastName, actualLastName);
    }

    @Test
    void getRole() {
        String expectedRole = "mechanic";
        String actualRole = this.employee.getRole();
        assertEquals(expectedRole, actualRole);
    }

    @Test
    void getEmail() {
        String expectedEmail = "TimoTester@email.com";
        String actualEmail = this.employee.getEmail();
        assertEquals(expectedEmail, actualEmail);
    }

}