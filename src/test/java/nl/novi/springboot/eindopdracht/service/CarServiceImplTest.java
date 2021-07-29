package nl.novi.springboot.eindopdracht.service;

import nl.novi.springboot.eindopdracht.GarageApplication;
import nl.novi.springboot.eindopdracht.model.Car;
import nl.novi.springboot.eindopdracht.model.Employee;
import nl.novi.springboot.eindopdracht.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
@ContextConfiguration(classes={GarageApplication.class})
class CarServiceImplTest {

    @Autowired
    private CarService carService;

    @MockBean
    private CarRepository carRepository;

    @Mock
    Car car;


    @Test
    void getCarById() {

    }

}