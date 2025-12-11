package com.rewards_local.interview_prep.controller;


import com.rewards_local.interview_prep.dto.PagedResponse;
import com.rewards_local.interview_prep.model.Product;
import com.rewards_local.interview_prep.productservice.ProductService;
import com.rewards_local.interview_prep.request.ProductRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Product addProduct(@Valid @RequestBody ProductRequest productRequest) {
        return productService.saveProduct(productRequest);
    }

    @GetMapping
    public PagedResponse<Product> getAllProducts(@PageableDefault (page=0,size = 10, sort="name") Pageable pageable) {

        Page<Product> pageResult = productService.getAllProducts(pageable);
        return new PagedResponse<>(
                pageResult.getContent(),
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages(),
                pageResult.isLast()
        );
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
