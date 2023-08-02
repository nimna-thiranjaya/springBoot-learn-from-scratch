package com.nimna.producatService.service;

import com.nimna.producatService.dto.request.ProductRequest;
import com.nimna.producatService.dto.respones.ProductResponse;

import java.util.List;

public interface ProductService {
    public void createProduct(ProductRequest productRequest);

    public List<ProductResponse> getAllProduct();
}
