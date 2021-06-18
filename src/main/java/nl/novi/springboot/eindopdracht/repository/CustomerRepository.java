package nl.novi.springboot.eindopdracht.repository;
import nl.novi.springboot.eindopdracht.model.Customer;
import nl.novi.springboot.eindopdracht.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List <Customer> findByLastNameIs(String name);
    List<Customer> findByLastNameStartingWithOrderByLastName(String name);
}
