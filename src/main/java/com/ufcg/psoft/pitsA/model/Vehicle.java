package com.ufcg.psoft.pitsA.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ufcg.psoft.pitsA.enumeration.VehicleType;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Embeddable
public class Vehicle {

    @JsonProperty("Color")
    @NotBlank
    private String color;

    @JsonProperty("License Plate")
    @NotBlank
    private String licensePlate;

    @JsonProperty("Vehicle Type")
    @NotNull
    private VehicleType vehicleType;

    public Vehicle() {

    }

    public Vehicle(String color, String licensePlate, VehicleType vehicleType) {
        this.color = color;
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return Objects.equals(licensePlate, vehicle.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate);
    }
}
