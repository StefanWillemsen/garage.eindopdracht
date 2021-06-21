package nl.novi.springboot.eindopdracht.service;


import nl.novi.springboot.eindopdracht.exception.RecordNotFoundException;
import nl.novi.springboot.eindopdracht.model.Customer;

import nl.novi.springboot.eindopdracht.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
    public class CustomerServiceImpl implements CustomerService {
        @Autowired
        CustomerRepository customerRepository ;

        @Override
        public List<Customer> getAllCustomers() { return customerRepository.findAll();}

        @Override
        public List<Customer> getCustomersByName(String name) {
            if (name == null || name.isEmpty())
                return customerRepository.findAll();
            else
                return customerRepository.findByLastNameStartingWithOrderByLastName(name);
        }

        @Override
        public Customer getCustomerById(long id) {
            if (customerRepository.existsById(id)) {
                return customerRepository.findById(id).get();
            }
            else {
                throw new RecordNotFoundException();
            }
        }

        @Override
        public long addCustomer(Customer customer) {
            Customer newCustomer = customerRepository.save(customer);
            return newCustomer.getCustomerID();
        }

        @Override
        public void deleteCustomer(long id) {
            if( customerRepository.existsById(id)){
                customerRepository.deleteById(id);
            }
            else {
                throw new RecordNotFoundException();
            }

        }

        @Override
        public void updateCustomer(long id, Customer customer) {
            if (customerRepository.existsById(id)){
                Customer existingCustomer = customerRepository.findById(id).get();
                existingCustomer.setFirstName(customer.getFirstName());
                existingCustomer.setLastName(customer.getLastName());
                                existingCustomer.setEmail(customer.getEmail());
                existingCustomer.setPhoneNumber(customer.getEmail());
            }
            else{
                throw new RecordNotFoundException();
            }
        }


    }


