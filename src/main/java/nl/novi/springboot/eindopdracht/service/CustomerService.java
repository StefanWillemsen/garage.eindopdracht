package nl.novi.springboot.eindopdracht.service;


import nl.novi.springboot.eindopdracht.model.Customer;
import nl.novi.springboot.eindopdracht.model.Employee;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    List<Customer> getCustomersByName(String name);
    Customer getCustomerById(long id);
    long addCustomer(Customer customer);
    void deleteCustomer(long id);
    void updateCustomer(long id, Customer customer);
}
