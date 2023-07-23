package com.example.pointofsalebyDulan.dto.paginated;

import com.example.pointofsalebyDulan.dto.ItemDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedResponseItemDto {

    private List<ItemDTO> list;
    private long dataCount;
}
