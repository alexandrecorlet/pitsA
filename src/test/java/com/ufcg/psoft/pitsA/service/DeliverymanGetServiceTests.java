package com.ufcg.psoft.pitsA.service;

import java.util.List;

import com.ufcg.psoft.pitsA.dto.DeliverymanDTO;
import com.ufcg.psoft.pitsA.enumeration.VehicleType;
import com.ufcg.psoft.pitsA.exception.DeliverymanNotFoundException;
import com.ufcg.psoft.pitsA.model.Deliveryman;
import com.ufcg.psoft.pitsA.model.Vehicle;
import com.ufcg.psoft.pitsA.repository.DeliverymanRepository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DeliverymanGetServiceTests {

    @Autowired
    private DeliverymanGetService driver;

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
    @DisplayName("Read deliveryman from DB")
    public void testReadDeliverymanFromDB() throws DeliverymanNotFoundException {
        // Arrange
        // Act
        DeliverymanDTO result = driver.get(deliveryman.getId());
        // Assert
        assertNotNull(result);
        assertEquals(deliveryman.getName(), result.getName());
        assertEquals(deliveryman.getVehicle(), result.getVehicle());
        assertEquals(deliveryman.getPassword(), result.getPassword());
    }

    @Test
    @DisplayName("Read deliveryman with invalid id from DB")
    public void testReadDeliverymanWithInvalidIdFromDB() {
        // Arrange
        final Long INVALID_ID = 0L;
        // Act

        // Assert
        assertThrows(DeliverymanNotFoundException.class, () -> driver.get(INVALID_ID));
    }

    @Test
    @DisplayName("List all deliveryman in DB")
    public void testListAllDeliverymanInDB() {
        // Arrange
        Vehicle vehicle = new Vehicle("black", "abc123", VehicleType.Motorcycle);
        Deliveryman deliveryman2 = new Deliveryman(
                "deliveryman 02",
                "654321",
                vehicle
        );
        deliverymanRepository.save(deliveryman2);

        // Act
        List<DeliverymanDTO> result = driver.getAll();

        // Assert
        assertNotNull(result);
    }

}
