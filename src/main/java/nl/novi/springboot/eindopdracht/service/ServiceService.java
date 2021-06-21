package nl.novi.springboot.eindopdracht.service;

import nl.novi.springboot.eindopdracht.model.Service;

import java.util.List;

public interface ServiceService {

    List<Service> getAllServices();
    List<Service> getServiceByAction(String action);
    Service getServiceByID(Long serviceID);
    long addService(Service service);
    void deleteService(long serviceID);
    void updateService(long id, Service service);
}
