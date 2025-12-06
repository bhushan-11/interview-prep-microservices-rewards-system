package com.rewards_local.interview_prep.productservice;

import com.rewards_local.interview_prep.exception.ProductNotFoundException;
import com.rewards_local.interview_prep.model.Product;
import com.rewards_local.interview_prep.productrepository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow(() ->new ProductNotFoundException("Product with id: "+ id + "not found"));
    }

    public String deleteProduct (String id) {
         productRepository.deleteById(id);
         return "deleted";
    }
}
