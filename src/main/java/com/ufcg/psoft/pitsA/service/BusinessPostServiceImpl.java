package com.ufcg.psoft.pitsA.service;

import com.ufcg.psoft.pitsA.dto.BusinessDTO;
import com.ufcg.psoft.pitsA.model.Business;
import com.ufcg.psoft.pitsA.repository.BusinessRepository;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessPostServiceImpl implements BusinessPostService {

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BusinessDTO post(BusinessDTO businessDTO) {

        Business business = new Business(
                businessDTO.getName(),
                businessDTO.getPassword()
              );

        return modelMapper.map(
                businessRepository.save(business),
                BusinessDTO.class
                );

    }

}
