package com.luongproject.productservice.controller;

import com.luongproject.productservice.dto.request.ProductRequest;
import com.luongproject.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(
        @RequestBody ProductRequest request
    ) {
        return new ResponseEntity<>(productService.createProduct(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts(
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) Integer size
    ) {
        Pageable pageable = PageRequest.of(page == null ? 0 : page, size == null ? 10 : size);
        return new ResponseEntity<>(productService.getAllProducts(pageable), HttpStatus.OK);
    }
}
