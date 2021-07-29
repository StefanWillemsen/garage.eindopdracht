package nl.novi.springboot.eindopdracht.service;

import nl.novi.springboot.eindopdracht.exception.RecordNotFoundException;
import nl.novi.springboot.eindopdracht.model.Employee;
import nl.novi.springboot.eindopdracht.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() { return employeeRepository.findAll();}

    @Override
    public List<Employee> getEmployeeByName(String name) {
        if (name == null || name.isEmpty())
            return employeeRepository.findAll();
        else
            return employeeRepository.findByLastNameStartingWithOrderByLastName(name);
    }

    @Override
    public Employee getEmployeeById(long id) {
        if (employeeRepository.existsById(id)) {
            return employeeRepository.findById(id).get();
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long addEmployee(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee.getEmployeeID();
    }

    @Override
    public void deleteEmployee(long id) {
        if( employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }

    }

    @Override
    public void updateEmployee(long id, Employee employee) {
        if (employeeRepository.existsById(id)){
            Employee existingEmployee = employeeRepository.findById(id).get();
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setRole(employee.getRole());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPhoneNumber(employee.getEmail());
        }
        else{
            throw new RecordNotFoundException();
        }
    }
    @Override
    public Employee getEmployeeByLastName(String name) {
        return employeeRepository.findByLastName(name);
    }



}
