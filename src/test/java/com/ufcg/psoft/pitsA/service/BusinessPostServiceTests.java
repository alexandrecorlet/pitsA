package com.ufcg.psoft.pitsA.service;

import com.ufcg.psoft.pitsA.repository.BusinessRepository;
import com.ufcg.psoft.pitsA.dto.BusinessDTO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BusinessPostServiceTests {

    @Autowired
    private BusinessPostService driver;

    @Autowired
    private BusinessRepository businessRepository;

    private BusinessDTO businessDTO;

    @BeforeEach
    public void setup() {
        businessDTO = new BusinessDTO("ChurchOfFrenchFries", "123321");
    }

    @AfterEach
    public void tearDown() {
        businessRepository.deleteAll();
        businessDTO = null;
    }

    @Test
    @DisplayName("Add business into empty DB")
    public void testAddBusinessIntoEmptyDB() {

        // Arrange

        // Act
        BusinessDTO result = driver.post(businessDTO);

        // Assert
        assertNotNull(result);
        assertEquals(1, businessRepository.findAll().size());
        assertEquals(businessDTO.getName(), result.getName());
        assertEquals(businessDTO.getPassword(), result.getPassword());
    }

    @Test
    @DisplayName("Add business into DB")
    public void testAddBusinessIntoDB() {

        // Arrange
        BusinessDTO businessDTO2 = new BusinessDTO(
                "EasyBreezyMac&Cheese",
                "guest1");

        driver.post(businessDTO2);

        // Act
        BusinessDTO result = driver.post(businessDTO);

        // Assert
        assertNotNull(result);
        assertEquals(2, businessRepository.findAll().size());

    }

    // TODO: Test exceptions.

}
