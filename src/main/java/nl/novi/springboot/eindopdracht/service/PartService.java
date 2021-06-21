package nl.novi.springboot.eindopdracht.service;


import nl.novi.springboot.eindopdracht.model.Part;

import java.util.List;

public interface PartService {
    List<Part> getAllParts();
    List<Part> getPartsByName(String name);
    Part getPartById(long PartID);
    long addPart(Part part);
    void deletePart(long id);
    void updatePart(long id, Part part);

}
