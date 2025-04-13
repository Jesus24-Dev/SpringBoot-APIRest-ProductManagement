
package products.productmanagement.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products.productmanagement.models.Category;
import products.productmanagement.repository.CategoryRepository;

@Service
public class CategoryService {
  
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Transactional
    public Category createCategory(Category category){
        if (category.getName() == null || category.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be empty");
        }
        return categoryRepository.save(category);
    }
    
    public Category getCategoryById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        
        return category;
    }
    
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    
    @Transactional
    public Category updateCategory(Long id, Category category){
        Category existingCategory = getCategoryById(id);
        if (category.getName() != null && !category.getName().trim().isEmpty()) {
            existingCategory.setName(category.getName());
        }
        return categoryRepository.save(existingCategory);
    }
    
    @Transactional
    public void deleteCategory(Long id){
        Category categoryFounded = getCategoryById(id);
        if (!categoryFounded.getProducts().isEmpty()) { 
            throw new IllegalStateException("Cannot delete category with associated products");
        }
        
        categoryRepository.delete(categoryFounded);
    }
}
