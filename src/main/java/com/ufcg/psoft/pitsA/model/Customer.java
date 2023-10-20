package com.ufcg.psoft.pitsA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "Customer")
public class Customer {

    @JsonProperty("Name")
    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @JsonIgnore
    @Size(min = 6, max = 6)
    @Column(
            name = "password",
            nullable = false
    )
    private String password;

    @JsonProperty("Id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @JsonProperty("Address")
    @Column(
            name = "address",
            nullable = false
    )
    private String address;

    // TODO: Attribute: Registrations

    public Customer() {

    }

    public Customer(String name, String password, String address) {
        this.name = name;
        this.password  = password;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Customer customer)) {
            return false;
        } else if (this == o) {
            return true;
        }

        return id.equals(customer.getId());

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n'
                + "Id: " + id;
    }

}
