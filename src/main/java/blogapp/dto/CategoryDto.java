package blogapp.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryDto {
    private Integer categoryId;
    private String categoryTitle;
    private String categoryDescription;
}
