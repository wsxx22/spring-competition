package com.daniel.competitions.mapper;

import com.daniel.competitions.dto.CategoryDTO;
import com.daniel.competitions.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO (Category category);

    List<CategoryDTO> toDTOList (List<Category> categories);

}
