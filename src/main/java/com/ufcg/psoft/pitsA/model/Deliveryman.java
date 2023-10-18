package com.ufcg.psoft.pitsA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Deliverymen")
public class Deliveryman {

    @JsonProperty("Id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("Name")
    private String name;

    @JsonIgnore
    @Size(min = 6, max = 6 )
    private String password;

    @JsonProperty("Vehicle")
    @NotNull
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

}
