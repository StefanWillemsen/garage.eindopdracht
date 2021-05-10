package nl.novi.springboot.eindopdracht.repository;
import nl.novi.springboot.eindopdracht.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
        List <Employee> findByLastNameIs(String name);
        List<Employee> findByLastNameStartingWithOrderByLastName(String name);

        }
