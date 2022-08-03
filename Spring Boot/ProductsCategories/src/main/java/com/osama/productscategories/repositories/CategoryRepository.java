package com.osama.productscategories.repositories;

import com.osama.productscategories.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Long> {
    List<Category> findAll();


}
