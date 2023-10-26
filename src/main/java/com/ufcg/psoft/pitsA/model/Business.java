package com.ufcg.psoft.pitsA.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Business")
public class Business {

    @JsonProperty("Id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("Name")
    private String name;

    @JsonIgnore
    @Size(min = 6, max = 6)
    private String password;

    // TODO: deliverymanRegistrations Map

    // TODO: customerRegistrations Map

    public Business() {

    };

    public Business(String name, String password) {
        this.name = name;
        this.password = password;
    };

    public void setName(String name) {
        this.name = name;
    };

    public void setPassword(String name) {
        this.password = password;
    };

    public String getName() {
        return name;
    };

    public String getPassword() {
        return password;
    };

    public Long getId() {
        return id;
    };

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Business business)) {
            return false;
        } else if (this == o) {
            return true;
        };

        return id.equals(business.getId());

    };

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    };

    @Override
    public String toString() {
        return "Name: " + name + '\n'
                + "Id: " + id;
    };

}
