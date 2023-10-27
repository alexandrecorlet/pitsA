package com.ufcg.psoft.pitsA.repository;

import com.ufcg.psoft.pitsA.model.Customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DisplayName("Customer Repository Tests")
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository driver;

    private Customer customer;

    @BeforeEach
    public void setup() {

        // setup customer
        customer = new Customer(
                "PizzaEater",
                "654321",
                "Champs Elysées 56"
        );

    }

    @AfterEach
    public void tearDown() {

        driver.deleteAll();
        customer = null;

    }

    @Test
    public void testSaveCustomer() {

        // Arrange
        // Arranged @ setup method.

        // Act
        Customer result = driver.save(customer);

        // Assert
        assertNotNull(result);
        assertEquals(customer.getId(), result.getId() );
    }

    @Test
    public void testExistsByIdCustomer() {

        // Arrange
        driver.save(customer);

        // Act
        boolean result = driver.existsById(customer.getId() );

        // Assert
        assertTrue(result);

    }

    @Test
    public void testExistsByIdCustomerNotFound() {

        // Arrange
        Long invalidId = 0L;

        // Act
        Customer result = driver.findById(invalidId).orElse(null);

        // Assert
        assertNull(result);

    }

    @Test
    public void testDeleteCustomer() {

        // Arrange
        driver.save(customer);

        // Act
        driver.delete(customer);

        // Assert
        assertFalse(driver.existsById(customer.getId() ) );

    }

    @Test
    public void testDeleteByIdCustomer() {

        // Arrange
        driver.save(customer);

        // Act
        driver.delete(customer);

        // Assert
        assertFalse(driver.existsById(customer.getId() ) );

    }

    @Test
    public void testFindAllCustomer() {

        // Arrange
        Customer c = new Customer("PizzaGobbler", "654123", "Fifth Av 48");
        driver.save(customer);
        driver.save(c);

        // Act
        List<Customer> result = driver.findAll();

        // Assert
        assertFalse(result.isEmpty() );
        assertEquals(2, result.size() );
        assertTrue(result.containsAll(List.of(customer, c) ) );

    }

    @Test
    public void testDeleteAllCustomer() {

        // Arrange
        driver.save(customer);

        // Act
        driver.deleteAll();

        // Assert
        assertTrue(driver.findAll().isEmpty() );


    }

}
