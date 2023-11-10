package com.ufcg.psoft.pitsA.service;

import com.ufcg.psoft.pitsA.dto.DeliverymanDTO;
import com.ufcg.psoft.pitsA.model.Deliveryman;
import com.ufcg.psoft.pitsA.repository.DeliverymanRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliverymanPostServiceImpl implements DeliverymanPostService {

    @Autowired
    private DeliverymanRepository deliverymanRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DeliverymanDTO post(DeliverymanDTO deliverymanDTO) {
        Deliveryman deliveryman = new Deliveryman(
                deliverymanDTO.getName(),
                deliverymanDTO.getPassword(),
                deliverymanDTO.getVehicle()
        );

        return modelMapper.map(deliverymanRepository.save(deliveryman), DeliverymanDTO.class);
    }

}
