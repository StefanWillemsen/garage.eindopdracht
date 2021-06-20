package nl.novi.springboot.eindopdracht.controller;

import nl.novi.springboot.eindopdracht.model.Customer;
import nl.novi.springboot.eindopdracht.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/")
public class CustomerController {

         @Autowired
         CustomerService customerService;

    @GetMapping(value = "/Customers/{id}")
    public ResponseEntity<Object> getCustomer(@PathVariable("id") Integer id) {
        return  new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/Customers/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") Integer id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("record deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/Customer/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") Integer id, @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
        return new ResponseEntity<>("Record Updated", HttpStatus.NO_CONTENT);
    }

    @PostMapping( value = "/customer")
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer){
        long newId = customerService.addCustomer(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                  .path("/{id}")
                                                  .buildAndExpand(newId)
                                                  .toUri();
        return ResponseEntity.created(location).build();

    }

}

