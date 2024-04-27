package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products") // Changed base mapping to '/api/products'

public class ProductController {
    @Autowired
    ProductService productService; // Changed the service reference to ProductService

    @PostMapping("/add") // Changed endpoint to '/api/products/add'
    public ResponseEntity<Product> addProduct(@RequestBody Product product) { // Changed method name to 'addProduct'
        Product createdProduct = productService.create(product); // Changed 'js.create' to 'productService.create'
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/all") // Changed endpoint to '/api/products/all'
    public List<Product> getAllProducts() { // Changed method name to 'getAllProducts'
        return productService.getAllProducts(); // Changed 'js.getAllJob' to 'productService.getAllProducts'
    }

    @PutMapping("/{productId}") // Changed endpoint to '/api/products/{productId}'
    public ResponseEntity<Product> updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product) { // Changed method name to 'updateProduct'
        if (productService.updateDetails(productId, product)) { // Changed 'js.updateDetails' to 'productService.updateDetails'
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{productId}") // Changed endpoint to '/api/products/{productId}'
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("productId") Long productId) { // Changed method name to 'deleteProduct'
        if (productService.deleteProduct(productId)) { // Changed 'js.deleteJob' to 'productService.deleteProduct'
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
