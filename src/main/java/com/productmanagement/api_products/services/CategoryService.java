
package com.productmanagement.api_products.services;

import com.productmanagement.api_products.exceptions.CategoryNotFoundException;
import com.productmanagement.api_products.models.Category;
import com.productmanagement.api_products.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    
    public Category getCategoryById(Long id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category [" + id + "] not found"));
    }
    
    public void createCategory(Category category){
        categoryRepository.save(category);
    } 
    
    public void updateCategory(Long id, Category categoryDetails){
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category [" + id + "] not found"));
        
        existingCategory.setName(categoryDetails.getName());
        
        categoryRepository.save(existingCategory);
    }
    
    public void deleteCategory(Long id){
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category [" + id + "] not found"));
        
        categoryRepository.delete(existingCategory);
    }
}
