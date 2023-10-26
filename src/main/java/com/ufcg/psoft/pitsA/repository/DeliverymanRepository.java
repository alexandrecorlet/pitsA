package com.ufcg.psoft.pitsA.repository;

import com.ufcg.psoft.pitsA.model.Deliveryman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliverymanRepository extends JpaRepository<Deliveryman, Long> {

}
