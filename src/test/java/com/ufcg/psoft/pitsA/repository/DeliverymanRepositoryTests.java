package com.ufcg.psoft.pitsA.repository;

import java.util.List;

import com.ufcg.psoft.pitsA.enumeration.VehicleType;
import com.ufcg.psoft.pitsA.model.Deliveryman;
import com.ufcg.psoft.pitsA.model.Vehicle;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Deliveryman Repository Tests")
public class DeliverymanRepositoryTests {

    @Autowired
    private DeliverymanRepository driver;

    private Deliveryman deliveryman;

    @BeforeEach
    public void setup() {

        // setup deliveryman
        Vehicle vehicle = new Vehicle("black", "abc123", VehicleType.Motorcycle);
        deliveryman = new Deliveryman(
                "deliveryman 01",
                "123456",
                vehicle
        );

    }

    @AfterEach
    public void tearDown() {
        driver.deleteAll();
        deliveryman = null;
    }

    @Test
    public void testSaveDeliveryman() {
        // Arrange

        // Act
        Deliveryman result = driver.save(deliveryman);

        // Assert
        assertNotNull(result);
        assertEquals(deliveryman.getId(), result.getId());
        assertTrue(driver.existsById(result.getId()));
    }

    @Test
    public void testExistsByIdDeliveryman() {
        // Arrange
        driver.save(deliveryman);

        // Act
        boolean result = driver.existsById(deliveryman.getId());

        // Assert
        assertTrue(result);
    }

    @Test
    public void testExistsByIdDeliverymanIdNotFound() {
        // Arrange
        Long invalid_id = 0L;

        // Act
        boolean result = driver.existsById(invalid_id);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testFindByIdDeliveryman() {
        // Arrange
        driver.save(deliveryman);

        // Act
        Deliveryman result = driver.findById(deliveryman.getId())
                .orElse(null);

        // Assert
        assertNotNull(result);
        assertEquals(deliveryman.getId(), result.getId());
    }

    @Test
    public void testFindByIdDeliverymanIdNotFound() {
        // Arrange
        Long invalid_id = 0L;

        // Act
        Deliveryman result = driver.findById(invalid_id)
                .orElse(null);

        // Assert
        assertNull(result);
    }

    @Test
    public void testDeleteDeliveryman() {
        // Arrange
        driver.save(deliveryman);
        // Act
        driver.delete(deliveryman);
        // Assert
        assertFalse(driver.existsById(deliveryman.getId()));

    }

    @Test
    public void testDeleteByIdDeliveryman() {
        // Arrange
        driver.save(deliveryman);
        Long id = deliveryman.getId();
        // Act
        driver.deleteById(id);
        // Assert
        assertFalse(driver.existsById(id));
    }

    @Test
    public void testFindAllDeliveryman() {
        // Arrange
        Vehicle vehicle = new Vehicle("red", "rj021", VehicleType.Car);
        Deliveryman d = new Deliveryman(
                "Luke Skywalker",
                "123450",
                vehicle
        );
        driver.save(deliveryman);
        driver.save(d);

        // Act
        List<Deliveryman> result = driver.findAll();

        // Assert
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        assertTrue(result.containsAll(List.of(deliveryman, d)));
    }

    @Test
    public void testDeleteAllDeliveryman() {
        // Arrange
        driver.save(deliveryman);

        // Act
        driver.deleteAll();

        // Assert
        assertTrue(driver.findAll().isEmpty());
    }

}
