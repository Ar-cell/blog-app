package blogapp.serviceImpl;

import blogapp.config.Response;
import blogapp.config.RestConstants;
import blogapp.dto.CategoryDto;
import blogapp.entity.Category;
import blogapp.repository.CategoryRepository;
import blogapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService, RestConstants {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Response createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        category.setCategoryTitle(category.getCategoryTitle());
        categoryRepository.save(category);
        return new Response(SUCCESS,category, HttpStatus.OK);
    }

    @Override
    public Response getCategoryById(Integer categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent()){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryId(category.get().getCategoryId());
            categoryDto.setCategoryTitle(category.get().getCategoryTitle());
            categoryDto.setCategoryDescription(categoryDto.getCategoryDescription());
            return new Response(SUCCESS,categoryDto,HttpStatus.OK);
        }
        return new Response(NOT_FOUND,HttpStatus.NOT_FOUND);
    }

    @Override
    public Response updateCategory(CategoryDto categoryDto) {
        Optional<Category> category = categoryRepository.findById(categoryDto.getCategoryId());
        if(category.isPresent()){
            Category category1 = category.get();
            category1.setCategoryTitle(categoryDto.getCategoryTitle());
            category1.setCategoryDescription(categoryDto.getCategoryDescription());
            categoryRepository.save(category1);
            return new Response(SUCCESS,category1,HttpStatus.OK);
        }
        return new Response(NOT_FOUND,HttpStatus.NOT_FOUND);
    }

    @Override
    public Response getAllCategory() {
        return null;
    }

    @Override
    public Response deletecategory(Integer categoryid) {
        return null;
    }
}
