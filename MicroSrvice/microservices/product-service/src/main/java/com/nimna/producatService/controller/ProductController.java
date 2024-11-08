package com.nimna.producatService.controller;

import com.nimna.producatService.dto.request.ProductRequest;
import com.nimna.producatService.dto.respones.ProductResponse;
import com.nimna.producatService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping(path = "create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
       productService.createProduct(productRequest);
    }

    @GetMapping(path = "get-all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProduct();
    }

}
