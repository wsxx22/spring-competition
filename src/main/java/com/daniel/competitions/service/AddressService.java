package com.daniel.competitions.service;

import com.daniel.competitions.dto.AddressDTO;
import com.daniel.competitions.entity.Address;
import com.daniel.competitions.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<AddressDTO> findAll () {
        return addressDTOList(addressRepository.findAll());
    }

    private AddressDTO toDTO (Address address) {
        return new AddressDTO(
                address.getId(),
                address.getName()
        );
    }

    private List<AddressDTO> addressDTOList (List<Address> addresses) {
        return addresses.stream().map(a -> toDTO(a)).collect(Collectors.toList());
    }


}
