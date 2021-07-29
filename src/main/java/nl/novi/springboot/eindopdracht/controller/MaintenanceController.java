package nl.novi.springboot.eindopdracht.controller;


import nl.novi.springboot.eindopdracht.model.Maintenance;
import nl.novi.springboot.eindopdracht.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/")



public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    @GetMapping(value = "/maintenance")
    public ResponseEntity<Object> getMaintenance(@RequestParam(required = false) String MaintenanceDate){
        return new ResponseEntity<>(maintenanceService.getMaintenancebyDate(MaintenanceDate), HttpStatus.OK);
    }
    @GetMapping(value = "/maintenance/{id}")
    public ResponseEntity<Object> getMaintenance(@PathVariable("id") Integer id) {
        return  new ResponseEntity<>(maintenanceService.getMaintenanceById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/maintenance/{id}")
    public ResponseEntity<Object> deleteMaintenance(@PathVariable("id") Integer id){
        maintenanceService.deleteMaintenance(id);
        return new ResponseEntity<>("Record deleted", HttpStatus.NO_CONTENT);
    }
    @PostMapping(value = "/maintenance")
    public ResponseEntity<Object> addMaintenance(@RequestBody Maintenance maintenance){
        long newId = maintenanceService.addMaintenance(maintenance);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newId)
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @PutMapping(value = "/maintenance/{id}")
    public ResponseEntity<Object> updateMaintenance(@PathVariable("id") Integer id, @RequestBody Maintenance maintenance){
        maintenanceService.updateMaintenance(id, maintenance);
        return new ResponseEntity<>("Record Updated", HttpStatus.NO_CONTENT);
    }
}
