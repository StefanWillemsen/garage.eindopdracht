package nl.novi.springboot.eindopdracht.model;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceTest {

    private Maintenance maintenance;

    @BeforeEach
    void setUp(){
        this.maintenance = new Maintenance();
        this.maintenance.setMaintenanceID(15L);
        this.maintenance.setMaintenanceDate("02/08/2021");
        this.maintenance.setMaintenanceCompleted(false);
    }
    @Test
    void getMaintenanceID() {
        Long expectedId = 15L;
        Long actualId = this.maintenance.getMaintenanceID();
        assertEquals(expectedId, actualId);
    }

    @Test
    void isMaintenanceCompleted() {
        assertEquals(false, this.maintenance.isMaintenanceCompleted());
    }

        @Test
    void getMaintenanceDate() {
        assertEquals("02/08/2021", this.maintenance.getMaintenanceDate());
    }


}