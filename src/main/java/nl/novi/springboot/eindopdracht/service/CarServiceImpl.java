package nl.novi.springboot.eindopdracht.service;

import nl.novi.springboot.eindopdracht.exception.RecordNotFoundException;
import nl.novi.springboot.eindopdracht.model.Car;
import nl.novi.springboot.eindopdracht.model.Customer;
import nl.novi.springboot.eindopdracht.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    CarRepository carRepository;
    @Override
    public Car getCarById(long id) {
        if (carRepository.existsById(id)) {
            return carRepository.findById(id).get();
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long addCar(Car car) {
        Car newCar = carRepository.save(car);
        return newCar.getCarID();
    }

    @Override
    public void deleteCar(long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
        }else{
            throw new RecordNotFoundException();
            }
    }

    @Override
    public void updateCar(long id, Car car) {
        if (carRepository.existsById(id)){
            Car existingCar = carRepository.findById(id).get();
            existingCar.setBrand(car.getBrand());
            existingCar.setType(car.getType());
            existingCar.setManufacturingYear(car.getManufacturingYear());
            existingCar.setLicencePlate(car.getLicencePlate());
            existingCar.setEmployee(car.getEmployee());
            existingCar.setCustomer(car.getCustomer());
        }
        else{
            throw new RecordNotFoundException();
        }
    }
}
