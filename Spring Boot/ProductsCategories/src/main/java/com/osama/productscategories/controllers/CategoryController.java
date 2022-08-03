package com.osama.productscategories.controllers;


import com.osama.productscategories.models.Category;
import com.osama.productscategories.models.Product;
import com.osama.productscategories.services.CategoryService;
import com.osama.productscategories.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    @GetMapping("/category/new")
    public String createCat(@ModelAttribute("Category") Category category){
        return ("cat.jsp");
    }

    @RequestMapping(value = "/category/new", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("Category") Category category, BindingResult result, Model model){
        categoryService.createCategory(category);
        return "redirect:/category/new";
    }

    // Retrieve all Category

    @GetMapping("/category/{id}")
    public String allCate(@PathVariable(value = "id") long id, Model model, @ModelAttribute("Category") Category category){
        List<Product> products = productService.allProduct();
        Category category1 = categoryService.findCategory(id);

        model.addAttribute("products", products);
        model.addAttribute("category", category1);
        return "allcat.jsp";

    }

    @PostMapping("/category/{category_id}/addproduct")
    public String addProductCategory(@PathVariable(value = "category_id") long category_id , @RequestParam(value = "product") long product_id){
        categoryService.addProduct(product_id, category_id);
        return "redirect:/category/"+category_id;
    }
}

