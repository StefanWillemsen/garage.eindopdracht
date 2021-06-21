package nl.novi.springboot.eindopdracht.repository;

import nl.novi.springboot.eindopdracht.model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenanceRepository extends JpaRepository <Maintenance, Long>{

    List<Maintenance> findMaintenanceByMaintenanceDate(String maintenanceDate);

}

