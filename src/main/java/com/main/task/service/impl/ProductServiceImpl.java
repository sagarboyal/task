package com.main.task.service.impl;

import com.main.task.entity.Product;
import com.main.task.entity.User;
import com.main.task.payload.request.ProductRequest;
import com.main.task.payload.response.ProductResponse;
import com.main.task.repository.ProductRepository;
import com.main.task.repository.UserRepository;
import com.main.task.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Product product = new Product();
        product.setProductName(request.getProductName());

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User with this id not found"));

        product.setUser(user);

        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        product = productRepository.save(product);
        return toResponse(product);
    }

    @Override
    public List<ProductResponse> fetchAllProduct() {
        return productRepository.findAll().stream().map(this::toResponse).toList();
    }

    private ProductResponse toResponse(Product product){
        return ProductResponse.builder()
                .productId(product.getProductId())
                .name(product.getProductName())
                .create_at(product.getCreatedAt().toString())
                .update_at(product.getUpdatedAt().toString())
                .build();
    }
}
