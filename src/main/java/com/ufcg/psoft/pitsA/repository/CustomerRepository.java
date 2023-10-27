package com.ufcg.psoft.pitsA.repository;

import com.ufcg.psoft.pitsA.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
