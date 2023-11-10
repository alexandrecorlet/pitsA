package com.ufcg.psoft.pitsA.service;

import java.util.ArrayList;
import java.util.List;

import com.ufcg.psoft.pitsA.dto.DeliverymanDTO;
import com.ufcg.psoft.pitsA.exception.DeliverymanNotFoundException;
import com.ufcg.psoft.pitsA.model.Deliveryman;
import com.ufcg.psoft.pitsA.repository.DeliverymanRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliverymanGetServiceImpl implements DeliverymanGetService {

    @Autowired
    private DeliverymanRepository deliverymanRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DeliverymanDTO get(Long id) throws DeliverymanNotFoundException {
        Deliveryman deliveryman = deliverymanRepository.findById(id).orElse(null);

        if (deliveryman == null) {
            throw new DeliverymanNotFoundException("Deliveryman with id " + id + " not found.");
        }

        return modelMapper.map(deliveryman, DeliverymanDTO.class);
    }

    @Override
    public List<DeliverymanDTO> getAll() {
        List<DeliverymanDTO> deliverymenDTO = new ArrayList<>();
        for (Deliveryman deliveryman : deliverymanRepository.findAll()) {
            deliverymenDTO.add(modelMapper.map(deliveryman, DeliverymanDTO.class));
        }

        return deliverymenDTO;
    }

}
