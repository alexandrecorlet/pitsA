package com.ufcg.psoft.pitsA.repository;

import com.ufcg.psoft.pitsA.model.Business;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {

}
