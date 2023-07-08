package com.nimna.eLibrarysystem.dto.paginated;


import com.nimna.eLibrarysystem.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedBookResponseDTO {
    private List<BookDTO> list;
    private long dataCount;
    private long pageCount;
}
