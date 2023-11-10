package com.ufcg.psoft.pitsA.service;

import com.ufcg.psoft.pitsA.exception.DeliverymanNotFoundException;
import com.ufcg.psoft.pitsA.exception.InvalidPasswordException;
import com.ufcg.psoft.pitsA.model.Deliveryman;
import com.ufcg.psoft.pitsA.repository.DeliverymanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliverymanDeleteServiceImpl implements DeliverymanDeleteService {

    @Autowired
    private DeliverymanRepository deliverymanRepository;

    @Override
    public void delete(Long id, String password) throws DeliverymanNotFoundException, InvalidPasswordException {
        login(id, password);
        deliverymanRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        deliverymanRepository.deleteAll();
    }

    private void login(Long id, String password) throws DeliverymanNotFoundException, InvalidPasswordException {
        Deliveryman deliveryman = deliverymanRepository.findById(id).orElse(null);

        if (deliveryman == null) {
            throw new DeliverymanNotFoundException("Deliveryman with id" + id + " not found.");
        } else if (!deliveryman.getPassword().equals(password)) {
            throw new InvalidPasswordException("Invalid password.");
        }
    }

}
