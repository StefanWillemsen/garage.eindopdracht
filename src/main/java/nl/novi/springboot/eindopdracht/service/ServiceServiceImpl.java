package nl.novi.springboot.eindopdracht.service;


import net.bytebuddy.implementation.bytecode.Throw;
import nl.novi.springboot.eindopdracht.exception.RecordNotFoundException;
import nl.novi.springboot.eindopdracht.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceServiceImpl implements ServiceService{

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<nl.novi.springboot.eindopdracht.model.Service> getAllServices(){
        return serviceRepository.findAll();
    }

    @Override
    public List<nl.novi.springboot.eindopdracht.model.Service> getServiceByAction(String action){
        if(action == null || action.isEmpty()){
            return serviceRepository.findAll();
        }else{
            return serviceRepository.findServiceByAction(action);
        }
    }

    @Override
    public nl.novi.springboot.eindopdracht.model.Service getServiceByID(Long serviceID) {
        if(serviceRepository.existsById(serviceID)){
            return serviceRepository.findById(serviceID).get();
        }else{
            throw new RecordNotFoundException();
        }
    }


    @Override
    public long addService(nl.novi.springboot.eindopdracht.model.Service service) {
        nl.novi.springboot.eindopdracht.model.Service newService = serviceRepository.save(service);
        return newService.getServiceID();
    }

    @Override
    public void deleteService(long serviceID) {
        if(serviceRepository.existsById(serviceID)){
            serviceRepository.deleteById(serviceID);
        }else{
            throw new RecordNotFoundException();
        }

    }

    @Override
    public void updateService(long serviceID, nl.novi.springboot.eindopdracht.model.Service service) {
        if(serviceRepository.existsById(serviceID)){
            nl.novi.springboot.eindopdracht.model.Service existingService = serviceRepository.findById(serviceID).get();
            existingService.setAction(service.getAction());
            existingService.setDescription(service.getDescription());
            existingService.setPrice(service.getPrice());
            serviceRepository.save(existingService);
        }else{
            throw new RecordNotFoundException();
        }
    }



}
