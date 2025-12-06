package com.rewards_local.interview_prep.productrepository;

import com.rewards_local.interview_prep.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
