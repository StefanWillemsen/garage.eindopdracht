package nl.novi.springboot.eindopdracht.repository;

import nl.novi.springboot.eindopdracht.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface ServiceRepository extends JpaRepository<Service, Long>{

    List<Service> findServiceByAction(String name);

    Service findByServiceID(long serviceID);
}
