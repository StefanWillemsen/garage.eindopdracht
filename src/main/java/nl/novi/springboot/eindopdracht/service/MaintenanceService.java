package nl.novi.springboot.eindopdracht.service;

import nl.novi.springboot.eindopdracht.model.Maintenance;

import java.util.List;

public interface MaintenanceService {

    List<Maintenance> getMaintenancebyDate(String MaintenanceDate);

    Maintenance getMaintenanceById(long MaintenanceID);
    long addMaintenance(Maintenance maintenance);
    void deleteMaintenance(long id);
    void updateMaintenance(long id, Maintenance maintenance);
}
