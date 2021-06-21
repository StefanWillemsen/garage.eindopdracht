package nl.novi.springboot.eindopdracht.model;

import javax.persistence.*;

@Entity
@Table(name = "Parts")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long partID;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private double price;

    public Part() {
    }

    public Part(long partId, String name, String description, double price) {
        this.partID = partId;
        name = name;
        this.description = description;
        this.price = price;
    }


    public long getPartID() {
        return partID;
    }

    public void setPartId(long partId) {
        this.partID = partId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
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
