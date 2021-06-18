package nl.novi.springboot.eindopdracht.service;


import nl.novi.springboot.eindopdracht.exception.RecordNotFoundException;
import nl.novi.springboot.eindopdracht.model.Customer;

import nl.novi.springboot.eindopdracht.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

    public class CustomerServiceImpl implements CustomerService {
        @Autowired
        nl.novi.springboot.eindopdracht.repository.CustomerRepository CustomerRepository ;

        @Override
        public List<Customer> getAllCustomers() { return CustomerRepository.findAll();}

        @Override
        public List<Customer> getCustomerByName(String name) {
            if (name == null || name.isEmpty())
                return CustomerRepository.findAll();
            else
                return CustomerRepository.findByLastNameStartingWithOrderByLastName(name);
        }

        @Override
        public Customer getCustomerById(long id) {
            if (CustomerRepository.existsById(id)) {
                return CustomerRepository.findById(id).get();
            }
            else {
                throw new RecordNotFoundException();
            }
        }

        @Override
        public long addCustomer(Customer customer) {
            Customer newCustomer = CustomerRepository.save(customer);
            return newCustomer.getCustomerID();
        }

        @Override
        public void deleteCustomer(long id) {
            if( CustomerRepository.existsById(id)){
                CustomerRepository.deleteById(id);
            }
            else {
                throw new RecordNotFoundException();
            }

        }

        @Override
        public void updateCustomer(long id, Customer customer) {
            if (CustomerRepository.existsById(id)){
                Customer existingCustomer = CustomerRepository.findById(id).get();
                existingCustomer.setFirstName(customer.getFirstName());
                existingCustomer.setLastName(customer.getLastName());
                existingCustomer.setRole(customer.getRole());
                existingCustomer.setEmail(customer.getEmail());
                existingCustomer.setPhoneNumber(customer.getEmail());
            }
            else{
                throw new RecordNotFoundException();
            }
        }


    }


