package nl.novi.springboot.eindopdracht.service;

import nl.novi.springboot.eindopdracht.model.Car;
import nl.novi.springboot.eindopdracht.model.Customer;

public interface CarService {
    Car getCarById(long id);
    long addCar(Car car);
    void deleteCar(long id);
    void updateCar(long id, Car car);
}
