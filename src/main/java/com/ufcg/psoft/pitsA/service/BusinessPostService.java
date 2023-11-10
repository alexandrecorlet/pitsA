package com.ufcg.psoft.pitsA.service;

import com.ufcg.psoft.pitsA.dto.BusinessDTO;

@FunctionalInterface
public interface BusinessPostService {

    BusinessDTO post(BusinessDTO businessDTO);

}
