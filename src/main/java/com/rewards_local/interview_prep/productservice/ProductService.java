package com.rewards_local.interview_prep.productservice;

import com.rewards_local.interview_prep.exception.ProductNotFoundException;
import com.rewards_local.interview_prep.model.Product;
import com.rewards_local.interview_prep.productrepository.ProductRepository;
import com.rewards_local.interview_prep.request.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setBrand(request.getBrand());
        product.setCategory(request.getCategory());
        product.setDescription(request.getDescription());
        product.setImageUrl(request.getImageUrl());
        product.setInventory(request.getInventory());
        product.setRewardPoints(request.getRewardPoints());

        return productRepository.save(product);
    }


    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow(() ->new ProductNotFoundException("Product with id: "+ id + "not found"));
    }

    public String deleteProduct (String id) {
         productRepository.deleteById(id);
         return "deleted";
    }
}
