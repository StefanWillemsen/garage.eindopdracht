package nl.novi.springboot.eindopdracht.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "part")
    @JsonIgnoreProperties("part")
    List<Maintenance> maintenances;
    public Part() {
    }

    public Part(long partId, String name, String description, double price) {
        this.partID = partId;
        this.name = name;
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
        this.name = name;
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

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(List<Maintenance> maintenances) {
        this.maintenances = maintenances;
    }
}
