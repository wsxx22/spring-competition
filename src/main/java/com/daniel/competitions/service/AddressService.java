package com.daniel.competitions.service;

import com.daniel.competitions.entity.Address;
import com.daniel.competitions.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addAddress (Address address) {
        return addressRepository.save(address);
    }

    public List<Address> findAll () {
        return addressRepository.findAll();
    }


}
