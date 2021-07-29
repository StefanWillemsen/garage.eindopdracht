package nl.novi.springboot.eindopdracht.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carID;

    @ManyToOne
    @MapsId("CustomerID")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @MapsId("EmployeeID")
    @JoinColumn (name= "employee_id")
    private Employee employee;

    @Column
    private String brand;

    @Column
    private String type;

    @Column
    private String licencePlate;

    @Column
    private short manufacturingYear;

    @OneToOne(mappedBy = "car")
    @JsonIgnoreProperties("car")
    List<Maintenance> maintenances;
    /* ADD SOMEHOW
    @Column
    private document carPapers;
     */

    public Car() {
    }

    public Car(long carID, Customer customer, Employee employee, String brand, String type, String licencePlate, short manufacturingYear) {
        this.carID = carID;
        this.customer = customer;
        this.employee = employee;
        this.brand = brand;
        this.type = type;
        this.licencePlate = licencePlate;
        this.manufacturingYear = manufacturingYear;
    }

    public long getCarID() {
        return carID;
    }

    public void setCarID(long carID) {
        this.carID = carID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public short getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(short manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }
}
