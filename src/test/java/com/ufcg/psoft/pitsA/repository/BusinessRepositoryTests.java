package com.ufcg.psoft.pitsA.repository;

import com.ufcg.psoft.pitsA.model.Business;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DisplayName("Business Repository Tests")
public class BusinessRepositoryTests {

    @Autowired
    private BusinessRepository driver;

    private Business business;

    @BeforeEach
    public void setup() {

        // setup business
        business = new Business("SandyPizzas", "654321");

    }

    @AfterEach
    public void tearDown() {
        driver.deleteAll();
        business = null;
    }

    @Test
    public void testSaveBusiness() {

        // Arrange

        // Act
        Business result = driver.save(business);

        // Assert
        assertNotNull(result);
        assertEquals(business.getId(), result.getId());
    }

    @Test
    public void testExistsByIdBusiness() {

        // Arrange
        driver.save(business);

        // Act
        boolean result = driver.existsById(business.getId());

        // Assert
        assertTrue(result);
    }

    @Test
    public void testExistsByIdBusinessNotFound() {

        // Arrange
        Long invalidId = 0L;

        // Act
        Business result = driver.findById(invalidId).orElse(null);

        // Assert
        assertNull(result);

    }

    @Test
    public void testDeleteBusiness() {

        // Arrange
        driver.save(business);

        // Act
        driver.delete(business);

        // Assert
        assertFalse(driver.existsById(business.getId() ) );

    }

    @Test
    public void testDeleteByIdBusiness() {

        // Arrange
        driver.save(business);
        Long id = business.getId();

        // Act
        driver.deleteById(id);

        // Assert
        assertFalse(driver.existsById(id) );

    }

    @Test
    public void testFindAllBusiness() {

        // Arrange
        Business b = new Business("BuddyPizzas", "654123");
        driver.save(business);
        driver.save(b);

        // Act
        List<Business> result = driver.findAll();

        // Assert
        assertFalse(result.isEmpty() );
        assertEquals(2, result.size() );
        assertTrue(result.containsAll(List.of(business, b) ) );

    }

    @Test
    public void testDeleteAllBusiness() {

        // Arrange
        driver.save(business);

        // Act
        driver.deleteAll();

        // Assert
        assertTrue(driver.findAll().isEmpty() );

    }

}
