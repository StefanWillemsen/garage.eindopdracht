package nl.novi.springboot.eindopdracht.repository;

import nl.novi.springboot.eindopdracht.model.Car;
import nl.novi.springboot.eindopdracht.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
