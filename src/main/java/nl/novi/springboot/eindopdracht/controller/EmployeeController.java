package nl.novi.springboot.eindopdracht.controller;

import nl.novi.springboot.eindopdracht.model.Employee;
import nl.novi.springboot.eindopdracht.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/")
public class EmployeeController {

        @Autowired
        EmployeeService employeeService;

    @GetMapping(value = "/Employees/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable("id") Integer id) {
        return  new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/employees")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Record deleted", HttpStatus.NO_CONTENT);
    }
    @PostMapping(value = "/employees")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
        long newId = employeeService.addEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                                    .path("/{id}")
                                                    .buildAndExpand(newId)
                                                    .toUri();
        return ResponseEntity.created(location).build();
    }
}
