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
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/product/new", method = RequestMethod.GET)
    public String index(@ModelAttribute("Product")Product product){
        return "index.jsp";
    }

    @RequestMapping(value = "/product/new", method = RequestMethod.POST)
    public String createProduct(@Valid @ModelAttribute("Product")Product product, BindingResult result, Model model){
        productService.createProduct(product);
        return "redirect:/product/new";
    }

    // Retrieve all Products

    @GetMapping("/product/{id}")
    public String allProd(@PathVariable(value = "id") long id, Model model, @ModelAttribute("Product") Product product){
        List<Category> categories = categoryService.allCategory();
        Product product1 = productService.findProduct(id);

        model.addAttribute("category", categories);
        model.addAttribute("product", product1);
        return "allprod.jsp";
    }

    @PostMapping("/product/{product_id}/addcategory")
    public String addProdects(@PathVariable(value = "product_id")long product_id, @RequestParam(value = "category") long category_id){
        productService.addCategory(category_id, product_id);
        return "redirect:/product/"+ product_id;
    }
}
