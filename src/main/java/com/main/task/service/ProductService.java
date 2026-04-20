package com.main.task.service;

import com.main.task.payload.request.ProductRequest;
import com.main.task.payload.response.ProductResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request, UserDetails userDetails);
    List<ProductResponse> fetchAllProduct();
}
