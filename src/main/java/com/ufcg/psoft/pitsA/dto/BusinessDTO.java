package com.ufcg.psoft.pitsA.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class BusinessDTO {

    @JsonProperty("Name")
    @NotBlank(message = "Name cannot be blank.")
    private String name;

    @JsonIgnore
    @Size(min = 6, max = 6, message = "Password must have exactly 6 characters.")
    private String password;

    public BusinessDTO() {

    }

    public BusinessDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return "DeliverymanDTO{" + '\n' +
                "name=" + name + ',' + '\n' +
        "}";
    }

}
