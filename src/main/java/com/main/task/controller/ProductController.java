package com.main.task.controller;

import com.main.task.payload.request.ProductRequest;
import com.main.task.payload.response.ProductResponse;
import com.main.task.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest,
                                                         @AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productRequest, userDetails));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> fetchAllProductHandler(){
        return ResponseEntity.ok(productService.fetchAllProduct());
    }
}
