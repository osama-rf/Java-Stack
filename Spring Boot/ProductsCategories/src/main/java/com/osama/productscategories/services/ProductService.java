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
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;


    // Find Category
    public List<Product> allProduct(){
        return productRepository.findAll();
    }

    // Create Category
    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product findProduct(long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            return product.get();
        }else {
            return null;
        }
    }

    public void addCategory(long category_id, long product_id){
        Category category = categoryRepository.findById(category_id).get();
        Product product = productRepository.findById(product_id).get();

        product.getCategories().add(category);
        productRepository.save(product);
    }
}
