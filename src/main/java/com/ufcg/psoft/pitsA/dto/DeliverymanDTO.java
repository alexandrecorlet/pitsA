package com.ufcg.psoft.pitsA.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ufcg.psoft.pitsA.model.Vehicle;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DeliverymanDTO {

    @JsonProperty("Name")
    @NotBlank(message = "Name should not be blank.")
    private String name;

    @JsonIgnore
    @Size(min = 6, max = 6, message = "Password should have exactly 6 characters.")
    private String password;

    @JsonProperty("Vehicle")
    @NotNull(message = "Vehicle must not be null.")
    private Vehicle vehicle;

    @JsonIgnore
    @Nullable
    private Long id;

    public DeliverymanDTO() {

    }

    public DeliverymanDTO(String name, String password, Vehicle vehicle) {
        this.name = name;
        this.password = password;
        this.vehicle = vehicle;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "DeliverymanDTO{" +
                "name='" + name + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }

}
