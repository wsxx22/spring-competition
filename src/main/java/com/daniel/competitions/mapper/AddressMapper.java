package com.daniel.competitions.mapper;

import com.daniel.competitions.dto.AddressDTO;
import com.daniel.competitions.entity.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO toDTO (Address address);

    List<AddressDTO> toDTOList (List<Address> addresses);
}
