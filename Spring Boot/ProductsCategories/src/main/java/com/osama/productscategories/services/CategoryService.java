package com.osama.productscategories.services;

import com.osama.productscategories.models.Category;
import com.osama.productscategories.models.Product;
import com.osama.productscategories.repositories.CategoryRepository;
import com.osama.productscategories.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;





    // Find Category
    public List<Category> allCategory() {
        return categoryRepository.findAll();
    }

    // Create Category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findCategory(long id) {
       Optional<Category> category = categoryRepository.findById(id);
       if(category.isPresent()){
           return category.get();
       }else{
           return null;
       }
    }

    public void addProduct(long product_id, long category_id){
        Product product = productRepository.findById(product_id).get();
        Category category = categoryRepository.findById(category_id).get();

        category.getProducts().add(product);
        categoryRepository.save(category);
    }


}
