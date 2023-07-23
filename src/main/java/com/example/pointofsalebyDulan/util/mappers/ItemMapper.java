package com.example.pointofsalebyDulan.util.mappers;

import com.example.pointofsalebyDulan.dto.ItemDTO;
import com.example.pointofsalebyDulan.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ItemMapper {

    List<ItemDTO> entityToDto(List<Item> items);

    List<ItemDTO> pageToList(Page<Item> items);
}
