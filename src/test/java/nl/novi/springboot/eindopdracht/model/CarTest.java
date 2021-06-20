package nl.novi.springboot.eindopdracht.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private Car car;
    @BeforeEach
    void setUp(){
        this.car = new Car();
        this.car.setCarID(15);
        this.car.setBrand("toyota");
        this.car.setType("aigo");
        this.car.setLicencePlate("aa-11-aa");
        this.car.setManufacturingYear((short) 1995);
    }
    @Test
    void getCarID() {
        long expectedCarID = 15;
        long actualCarID = this.car.getCarID();
        assertEquals(expectedCarID, actualCarID);
    }

    @Test
    void getBrand() {
        String expectedBrand = "toyota";
        String actualBrand = this.car.getBrand();
        assertEquals(expectedBrand, actualBrand);
    }

    @Test
    void getType() {
        String expectedType = "aigo";
        String actualType = this.car.getType();
        assertEquals(expectedType, actualType);
    }

    @Test
    void getLicencePlate() {
        String expectedLicensePlate = "aa-11-aa";
        String actualLicensePlate = this.car.getLicencePlate();
        assertEquals(expectedLicensePlate, actualLicensePlate);
    }

    @Test
    void getManufacturingYear() {
        short expectedManufacturingYear = 1995;
        short actualManufacturingYear = this.car.getManufacturingYear();
        assertEquals(expectedManufacturingYear, actualManufacturingYear);
    }
}