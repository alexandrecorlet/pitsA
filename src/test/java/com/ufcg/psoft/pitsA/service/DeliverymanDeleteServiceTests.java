package com.ufcg.psoft.pitsA.service;

import com.ufcg.psoft.pitsA.dto.DeliverymanDTO;
import com.ufcg.psoft.pitsA.enumeration.VehicleType;
import com.ufcg.psoft.pitsA.exception.DeliverymanNotFoundException;
import com.ufcg.psoft.pitsA.exception.InvalidPasswordException;
import com.ufcg.psoft.pitsA.model.Deliveryman;
import com.ufcg.psoft.pitsA.model.Vehicle;
import com.ufcg.psoft.pitsA.repository.DeliverymanRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DeliverymanDeleteServiceTests {

    @Autowired
    private DeliverymanDeleteService driver;

    @Autowired
    private DeliverymanRepository deliverymanRepository;

    private Vehicle vehicle;

    private DeliverymanDTO deliverymanDTO;

    private Deliveryman deliveryman;

    @BeforeEach
    public void setup() {
        Vehicle vehicle = new Vehicle("black", "abc123", VehicleType.Motorcycle);
        deliveryman = new Deliveryman(
                "deliveryman 01",
                "123456",
                vehicle
        );
        deliverymanRepository.save(deliveryman);
    }

    @AfterEach
    public void tearDown() {
        deliverymanRepository.deleteAll();
        deliveryman = null;
        vehicle = null;
    }

    @Test
    @DisplayName("Delete deliveryman from DB")
    public void testDeleteDeliverymanFromDB() throws DeliverymanNotFoundException, InvalidPasswordException {
        // Arrange
        // deliveryman is added into db on setup method.

        // Act
        driver.delete(deliveryman.getId(), deliveryman.getPassword());

        // Assert
        assertFalse(deliverymanRepository.existsById(deliveryman.getId()));
    }

    @Test
    @DisplayName("Invalid delete deliveryman operation (deliveryman not found in DB)")
    public void testDeleteDeliverymanWithInvalidIdFromDB() {
        // Arrange
        final Long INVALID_ID = 0L;
        // Act

        // Assert
        assertThrows(
                DeliverymanNotFoundException.class,
                () -> driver.delete(INVALID_ID, deliveryman.getPassword())
        );

    }

    @Test
    @DisplayName("Invalid delete deliveryman operation (wrong password)")
    public void testDeleteDeliverymanInvalidPasswordFromDB() {
        // Arrange
        final String INVALID_PASSWORD = "a";
        // Act

        // Assert
        assertThrows(
                InvalidPasswordException.class,
                () -> driver.delete(deliveryman.getId(), INVALID_PASSWORD)
        );

    }

    @Test
    @DisplayName("Delete all deliveryman from DB")
    public void testDeleteAllDeliverymanFromDB() {
        // Arrange
        Vehicle vehicle = new Vehicle("black", "abc123", VehicleType.Motorcycle);
        Deliveryman deliveryman2 = new Deliveryman(
                "deliveryman 02",
                "654321",
                vehicle
        );
        deliverymanRepository.save(deliveryman2);
        // Act
        driver.deleteAll();
        // Assert
        assertTrue(deliverymanRepository.findAll().isEmpty());
    }

}
