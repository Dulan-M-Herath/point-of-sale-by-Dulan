package com.example.pointofsalebyDulan.dto.paginated;
import com.example.pointofsalebyDulan.dto.response.ResponseOrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedResponseOrderDetails {

    private List<ResponseOrderDetails> list;
    private long dataCount;

}
