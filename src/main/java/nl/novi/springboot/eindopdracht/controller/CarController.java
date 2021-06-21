package nl.novi.springboot.eindopdracht.controller;
import nl.novi.springboot.eindopdracht.model.Car;
import nl.novi.springboot.eindopdracht.model.Customer;
import nl.novi.springboot.eindopdracht.service.CarService;
import nl.novi.springboot.eindopdracht.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.file.Path;

@RestController
@RequestMapping("/")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping(value = "/car/{id}")
    public ResponseEntity<Object> getCar(@PathVariable("id") Integer id){
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/cars")
    public ResponseEntity<Object> addCar(@RequestBody Car car) {

        long newId = carService.addCar(car);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newId)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/cars/{id}")
    public ResponseEntity<Object> deleteCar(@PathVariable("id") Integer id) {
        carService.deleteCar(id);
        return new ResponseEntity<>("Record deleted", HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/cars/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable("id") Integer id, @RequestBody Car car) {
        carService.updateCar(id, car);
        return new ResponseEntity<>("Record updated", HttpStatus.NO_CONTENT);
    }


}
