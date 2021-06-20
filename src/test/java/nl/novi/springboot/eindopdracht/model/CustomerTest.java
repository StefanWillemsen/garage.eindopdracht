package nl.novi.springboot.eindopdracht.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;
    @BeforeEach
    void setUp(){
        this.customer = new Customer();
        this.customer.setFirstName("Tessa");
        this.customer.setLastName("Test");
        this.customer.setRole("customer");
        this.customer.setPhoneNumber("0123456789");
        }
    @Test
    void getFirstName() {
        String expectedFirstName = "Tessa";
        String actualFirstName = this.customer.getFirstName();
        assertEquals(expectedFirstName, actualFirstName);
    }

    @Test
    void getLastName() {
            String expectedLastName = "Test";
            String actualLastName = this.customer.getLastName();
            assertEquals(expectedLastName, actualLastName);
    }



    @Test
    void getPhoneNumber() {
        String expectedPhoneNumber = "0123456789";
        String actualPhoneNumber = this.customer.getPhoneNumber();
        assertEquals(expectedPhoneNumber, actualPhoneNumber);
    }

    @Test
    void setPhoneNumber() {
    }

    @Test
    void getRole() {
    }

    @Test
    void setRole() {
    }

    @Test
    void getEmail() {
    }

    @Test
    void setEmail() {
    }

    @Test
    void setCustomerID() {
    }

    @Test
    void getCustomerID() {
    }
}