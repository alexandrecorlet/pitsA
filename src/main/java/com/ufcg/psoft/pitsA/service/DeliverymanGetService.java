package com.ufcg.psoft.pitsA.service;

import java.util.List;

import com.ufcg.psoft.pitsA.dto.DeliverymanDTO;
import com.ufcg.psoft.pitsA.exception.DeliverymanNotFoundException;

public interface DeliverymanGetService {


    DeliverymanDTO get(Long id) throws DeliverymanNotFoundException;

    List<DeliverymanDTO> getAll();

}
