package com.main.task.service;

import com.main.task.payload.request.ProductRequest;
import com.main.task.payload.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request);
    List<ProductResponse> fetchAllProduct();
}
