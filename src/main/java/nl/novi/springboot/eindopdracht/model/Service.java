package nl.novi.springboot.eindopdracht.model;

import javax.persistence.*;


@Entity
@Table(name = "Services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serviceID;

    @Column
    private String action;

    @Column
    private String description;

    @Column double price;

    public Service() {
    }

    public Service(long serviceID, String action, String description, double price) {
        this.serviceID = serviceID;
        this.action = action;
        this.description = description;
        this.price = price;
    }

    public long getServiceID() {
        return serviceID;
    }

    public void setServiceID(long serviceID) {
        this.serviceID = serviceID;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
