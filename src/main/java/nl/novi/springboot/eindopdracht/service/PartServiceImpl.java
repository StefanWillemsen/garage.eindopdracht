package nl.novi.springboot.eindopdracht.service;


import nl.novi.springboot.eindopdracht.exception.RecordNotFoundException;
import nl.novi.springboot.eindopdracht.model.Part;
import nl.novi.springboot.eindopdracht.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService{

    @Autowired
    PartRepository partRepository;

    @Override
    public List<Part> getAllParts(){
        return partRepository.findAll();
    }

    @Override
    public List<Part> getPartsByName(String name){
        if (name == null || name.isEmpty()){
            return partRepository.findAll();
        }else{
            return partRepository.findPartByName(name);
        }
    }

    @Override
    public Part getPartById(long partID){
        if(partRepository.existsById(partID)) {
        return partRepository.findById(partID).get();
        }else{
            throw new RecordNotFoundException();}
    }
    @Override
    public long addPart(Part part) {
        Part newPart = partRepository.save(part);
        return newPart.getPartID();
    }

    @Override
    public void deletePart(long partID) {
        if (partRepository.existsById(partID)){
            partRepository.deleteById(partID);
        } else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void updatePart(long partID, Part part) {
        if (partRepository.existsById(partID)){
            Part existingPart = partRepository.findById(partID).get();
            existingPart.setName(part.getName());
            existingPart.setDescription(part.getDescription());
            existingPart.setPrice(part.getPrice());
            partRepository.save(existingPart);
        } else {
            throw new RecordNotFoundException();
        }
    }
}

