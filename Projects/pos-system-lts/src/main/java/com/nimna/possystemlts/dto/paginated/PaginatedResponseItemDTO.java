package com.nimna.possystemlts.dto.paginated;

import com.nimna.possystemlts.dto.response.GetItemResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedResponseItemDTO {
    List<GetItemResponseDTO> list;
    private long dataCount;
}
