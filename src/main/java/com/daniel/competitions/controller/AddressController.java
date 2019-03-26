package com.daniel.competitions.controller;

import com.daniel.competitions.dto.AddressDTO;
import com.daniel.competitions.entity.Address;
import com.daniel.competitions.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {


    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/add")
    public Address addAddress (@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @GetMapping("/all")
    public List<AddressDTO> findAll () {
        return addressService.findAll();
    }


}
