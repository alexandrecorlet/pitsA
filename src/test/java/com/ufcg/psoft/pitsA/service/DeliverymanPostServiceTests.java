package com.ufcg.psoft.pitsA.service;

import com.ufcg.psoft.pitsA.dto.DeliverymanDTO;
import com.ufcg.psoft.pitsA.enumeration.VehicleType;
import com.ufcg.psoft.pitsA.model.Vehicle;
import com.ufcg.psoft.pitsA.repository.DeliverymanRepository;

import org.junit.jupiter.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DeliverymanPostServiceTests {

    @Autowired
    private DeliverymanPostService driver;

    @Autowired
    private DeliverymanRepository deliverymanRepository;

    @Autowired
    private ModelMapper modelMapper;

    private Vehicle vehicle;

    private DeliverymanDTO deliverymanDTO;

    @BeforeEach
    public void setup() {
        vehicle = new Vehicle("abc", "abc123", VehicleType.Car);
        deliverymanDTO = new DeliverymanDTO("Skywalker", "123456", vehicle);
    }

    @AfterEach
    public void tearDown() {
        deliverymanRepository.deleteAll();
        deliverymanDTO = null;
    }


    @Test
    @DisplayName("Add deliveryman into empty DB")
    public void testAddDeliverymanIntoEmptyDB() {
        // Arrange

        // Act
        DeliverymanDTO result = driver.post(deliverymanDTO);

        // Assert
        assertNotNull(result);
        assertEquals(1, deliverymanRepository.findAll().size());
        assertEquals(deliverymanDTO.getName(), result.getName());
        assertEquals(deliverymanDTO.getPassword(), result.getPassword());
        assertEquals(deliverymanDTO.getVehicle(), result.getVehicle());
    }

    @Test
    @DisplayName("Add deliveryman into DB")
    public void testAddDeliverymanIntoDB() {
        // Arrange
        DeliverymanDTO deliverymanDTO2 = new DeliverymanDTO("Laplace", "654321", vehicle);
        driver.post(deliverymanDTO2);

        // Act
        DeliverymanDTO result = driver.post(deliverymanDTO);

        // Assert
        assertNotNull(result);
        assertEquals(2, deliverymanRepository.findAll().size());
    }

    // TODO: Test exceptions
}
