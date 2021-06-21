package nl.novi.springboot.eindopdracht.model;

import javax.persistence.*;

@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long MaintenanceID;

    @ManyToOne
    @MapsId("serviceID")
    @JoinColumn (name = "servicesApplied")
    private Service service;

    @ManyToOne
    @MapsId("partID")
    @JoinColumn(name = "partsExchanged")
    private Part part;

    @OneToOne
    @MapsId("carID")
    @JoinColumn (name = "Car")
    private Car car;

    @Column
    private boolean maintenanceCompleted;

    @Column boolean customerApproved;

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
        this.maintenanceCompleted = maintenanceCompleted;
    }

    public boolean isCustomerApproved() {
        return customerApproved;
    }

    public void setCustomerApproved(boolean customerApproved) {
        this.customerApproved = customerApproved;
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
        this.firstCheckDone = firstCheckDone;
    }
}
