package com.nimna.producatService.service.impl;

import com.nimna.producatService.dto.request.ProductRequest;
import com.nimna.producatService.dto.respones.ProductResponse;
import com.nimna.producatService.model.Product;
import com.nimna.producatService.repository.ProductRepository;
import com.nimna.producatService.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceIMPL implements ProductService {
    @Autowired
    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .productImage(productRequest.getProductImage())
                .build();

        productRepository.save(product);

        log.info("Product {} is saved", product.getId());
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> mapToProductResponse(product)).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse .builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .productImage(product.getProductImage())
                .build();
    }
}
