package com.ufcg.psoft.pitsA.model;

import java.util.Objects;

public class Customer {

    private String name;

    private String password;

    private Long id;

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
