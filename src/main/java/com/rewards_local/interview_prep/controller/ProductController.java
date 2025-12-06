package com.rewards_local.interview_prep.controller;


import com.rewards_local.interview_prep.model.Product;
import com.rewards_local.interview_prep.productservice.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
       return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        return productService.deleteProduct(id);
    }
}
