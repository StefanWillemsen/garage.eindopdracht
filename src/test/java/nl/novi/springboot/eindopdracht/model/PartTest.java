package nl.novi.springboot.eindopdracht.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartTest {
 private Part part;
 @BeforeEach
 void setUp(){
     this.part = new Part();
     this.part.setPartId(5);
     this.part.setName("v-belt");
     this.part.setPrice(15.15);
 }
    @Test
    void getPartID() {
     assertEquals(5,this.part.getPartID());
    }


    @Test
    void getName() {
     assertEquals("v-belt", this.part.getName());
    }

    @Test
    void getPrice() {
     assertEquals(15.15, this.part.getPrice());
    }


}