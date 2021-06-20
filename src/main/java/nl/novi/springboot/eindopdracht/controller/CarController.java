package nl.novi.springboot.eindopdracht.controller;
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

}
