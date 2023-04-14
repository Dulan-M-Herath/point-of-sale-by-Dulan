package com.example.pointofsalebyDulan.util.mappers;

import com.example.pointofsalebyDulan.dto.ItemDTO;
import com.example.pointofsalebyDulan.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    List<ItemDTO> entityToDto(List<Item> items);
}
