package nl.novi.springboot.eindopdracht.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    private Service service;

    @BeforeEach
    void setUp(){
        this.service = new Service();
        this.service.setAction("changing v-belt");
        this.service.setDescription("price to change the v-belt");

    }

    @Test
    void getAction() {
        assertEquals("changing v-belt", this.service.getAction());
    }


    @Test
    void getDescription() {
        assertEquals("price to change the v-belt", this.service.getDescription());
    }

}