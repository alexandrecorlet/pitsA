package com.ufcg.psoft.pitsA.service;

import com.ufcg.psoft.pitsA.dto.DeliverymanDTO;

@FunctionalInterface
public interface DeliverymanPostService {

    DeliverymanDTO post(DeliverymanDTO deliverymanDTO);

}
