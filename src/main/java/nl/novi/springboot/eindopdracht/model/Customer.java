package nl.novi.springboot.eindopdracht.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {




    @Column(length = 80)
    private String firstName;

    @Column(length = 80)
    private String lastName;

    @Column
    private String phoneNumber;

    @Column
    private String role;

    @Column
    private String email;
    @Id
    private Long customerID;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String phoneNumber, String role, String email, Long customerID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.email = email;
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getCustomerID() {
        return customerID;
    }
}