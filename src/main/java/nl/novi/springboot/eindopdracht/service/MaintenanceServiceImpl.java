package nl.novi.springboot.eindopdracht.service;

import nl.novi.springboot.eindopdracht.exception.RecordNotFoundException;
import nl.novi.springboot.eindopdracht.model.Maintenance;
import nl.novi.springboot.eindopdracht.repository.MaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService{

    @Autowired
    MaintenanceRepository maintenanceRepository;

    @Override
    public List<Maintenance> getMaintenancebyDate(String MaintenanceDate){
        if(MaintenanceDate== null || MaintenanceDate.isEmpty()) {
            return maintenanceRepository.findAll();
        }else{
            return maintenanceRepository.findMaintenanceByMaintenanceDate(MaintenanceDate);
        }
    }

    @Override
    public Maintenance getMaintenanceById(long MaintenanceID){
        if (maintenanceRepository.existsById(MaintenanceID)){
            return maintenanceRepository.findById(MaintenanceID).get();
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long addMaintenance (Maintenance maintenance){
        Maintenance newMaintenance = maintenanceRepository.save(maintenance);
        return newMaintenance.getMaintenanceID();
    }

    @Override
    public void deleteMaintenance (long maintenanceID) {
        if (maintenanceRepository.existsById(maintenanceID)) {
            maintenanceRepository.deleteById(maintenanceID);
        } else {
            throw new RecordNotFoundException();
        }
    }
    @Override
    public void updateMaintenance(long maintenanceID, Maintenance maintenance){
        if (maintenanceRepository.existsById(maintenanceID)){
            Maintenance existingMaintenance = maintenanceRepository.findById(maintenanceID).get();
            existingMaintenance.setCar(maintenance.getCar());
            existingMaintenance.setMaintenanceDate(maintenance.getMaintenanceDate());
            existingMaintenance.setFirstCheckDone(maintenance.isFirstCheckDone());
            existingMaintenance.setCustomerApproved(maintenance.isCustomerApproved());
            existingMaintenance.setMaintenanceCompleted(maintenance.isMaintenanceCompleted());
            existingMaintenance.setService(maintenance.getService());
            existingMaintenance.setPart(maintenance.getPart());
            maintenanceRepository.save(existingMaintenance);

        }

    }
}
