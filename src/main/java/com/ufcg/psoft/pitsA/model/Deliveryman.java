package com.ufcg.psoft.pitsA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "Deliveryman")
public class Deliveryman {

    @JsonProperty("Id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @JsonProperty("Name")
    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @JsonIgnore
    @Size(min = 6, max = 6 )
    @Column(
            name = "name",
            nullable = false
    )
    private String password;

    @JsonProperty("Vehicle")
    @Column(
            name = "name",
            nullable = false
    )
    private Vehicle vehicle;

    public Deliveryman() {

    }

    public Deliveryman(String name, String password, Vehicle vehicle) {
        this.name = name;
        this.password = password;
        this.vehicle = vehicle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Deliveryman deliveryman)) {
            return false;
        } else if (this == o) {
            return true;
        }

        return id.equals(deliveryman.getId());

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
