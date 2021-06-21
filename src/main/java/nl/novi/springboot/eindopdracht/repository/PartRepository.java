package nl.novi.springboot.eindopdracht.repository;

import nl.novi.springboot.eindopdracht.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartRepository extends JpaRepository<Part, Long> {

    List<Part> findPartByName(String name);
}
