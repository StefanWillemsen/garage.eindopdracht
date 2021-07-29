package nl.novi.springboot.eindopdracht.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long MaintenanceID;

    @ManyToOne
    @MapsId("serviceID")
    @JoinColumn(name = "servicesApplied")
    @JsonIgnoreProperties("maintenances")
    private Service service;

    @ManyToOne
    @MapsId("partID")
    @JoinColumn(name = "partsExchanged")
    @JsonIgnoreProperties("maintenances")
    private Part part;

    @ManyToOne
    @MapsId("carID")
    @JoinColumn(name = "Car")
    @JsonIgnoreProperties("maintenances")
    private Car car;

    @Column
    private boolean maintenanceCompleted;

    @Column
    boolean customerApproved;

    @Column
    private String maintenanceDate;

    @Column
    private boolean firstCheckDone;

    public Maintenance() {
    }

    public Maintenance(long maintenanceID, Service service, Part part, Car car, boolean maintenanceCompleted, boolean customerApproved, String maintenanceDate, boolean firstCheckDone) {
        MaintenanceID = maintenanceID;
        this.service = service;
        this.part = part;
        this.car = car;
        this.maintenanceCompleted = false;
        this.customerApproved = false;
        this.maintenanceDate = maintenanceDate;
        this.firstCheckDone = false;
    }

    public long getMaintenanceID() {
        return MaintenanceID;
    }

    public void setMaintenanceID(long maintenanceID) {
        MaintenanceID = maintenanceID;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isMaintenanceCompleted() {
        return maintenanceCompleted;
    }

    public void setMaintenanceCompleted(boolean maintenanceCompleted) {
        this.maintenanceCompleted = false;
    }

    public boolean isCustomerApproved() {
        return customerApproved;
    }

    public void setCustomerApproved(boolean customerApproved) {
        this.customerApproved = false;
    }

    public String getMaintenanceDate() {
        return maintenanceDate;
    }

    public void setMaintenanceDate(String maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }

    public boolean isFirstCheckDone() {
        return firstCheckDone;
    }

    public void setFirstCheckDone(boolean firstCheckDone) {
        this.firstCheckDone = false;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
}
