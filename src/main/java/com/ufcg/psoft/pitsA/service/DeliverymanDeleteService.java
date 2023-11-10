package com.ufcg.psoft.pitsA.service;

import com.ufcg.psoft.pitsA.exception.DeliverymanNotFoundException;
import com.ufcg.psoft.pitsA.exception.InvalidPasswordException;

public interface DeliverymanDeleteService {

    void delete(Long id, String password) throws DeliverymanNotFoundException, InvalidPasswordException;

    void deleteAll();

}
