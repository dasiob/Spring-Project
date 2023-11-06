package com.luongproject.productservice.repository;

import com.luongproject.productservice.dto.response.ProductResponse;
import com.luongproject.productservice.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    ProductResponse getProductById(String id);

    @Query("{'skip':pageable.pageNumber,'limit':pageable.pageSize}")
    List<ProductResponse> getAllProducts(Pageable pageable);
}
