package com.ufcg.psoft.pitsA.service;

import com.ufcg.psoft.pitsA.dto.DeliverymanDTO;

@FunctionalInterface
public interface DeliverymanServicePost {

    public DeliverymanDTO post(DeliverymanDTO deliverymanDTO);

}
