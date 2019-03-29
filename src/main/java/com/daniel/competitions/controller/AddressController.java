package com.daniel.competitions.controller;

import com.daniel.competitions.dto.AddressDTO;
import com.daniel.competitions.entity.Address;
import com.daniel.competitions.mapper.AddressMapper;
import com.daniel.competitions.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {


    private AddressService addressService;
    private AddressMapper addressMapper;

    @Autowired
    public AddressController(AddressService addressService, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @PostMapping("/add")
    public AddressDTO addAddress (@RequestBody Address address) {
        return addressMapper.toDTO(addressService.addAddress(address));
    }

    @GetMapping("/all")
    public List<AddressDTO> findAll () {
        return addressService.findAll();
    }


}
