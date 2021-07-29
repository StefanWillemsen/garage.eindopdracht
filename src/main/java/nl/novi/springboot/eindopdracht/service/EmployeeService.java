package nl.novi.springboot.eindopdracht.service;

import nl.novi.springboot.eindopdracht.model.Employee;

import java.util.List;

public interface EmployeeService {

        List<Employee> getAllEmployees();
        List<Employee> getEmployeeByName(String name);
        Employee getEmployeeById(long id);
        long addEmployee(Employee employee);
        void deleteEmployee(long id);
        void updateEmployee(long id, Employee employee);
        Employee getEmployeeByLastName(String name);
}
