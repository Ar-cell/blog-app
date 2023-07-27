package blogapp.service;

import blogapp.config.Response;
import blogapp.dto.CategoryDto;

public interface CategoryService {
    Response createCategory(CategoryDto categoryDto);
    Response getCategoryById(Integer categoryId);
    Response updateCategory(CategoryDto categoryDto);
    Response getAllCategory();
    Response deletecategory(Integer categoryid);
}
