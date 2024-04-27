package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository; // Changed repository reference to ProductRepository

    public Product create(Product product) {
        return productRepository.save(product); // Changed 'jr.save' to 'productRepository.save'
    }

    public Product getById(Long productId) { // Changed method name to 'getById' and parameter type to Long
        return productRepository.findById(productId).orElse(null); // Changed 'jr.findById' to 'productRepository.findById'
    }

    public List<Product> getAllProducts() { // Changed method name to 'getAllProducts'
        return productRepository.findAll(); // Changed 'jr.findAll' to 'productRepository.findAll'
    }

    public boolean updateDetails(Long productId, Product product) { // Changed method name to 'updateDetails' and parameter type to Long
        if (!productRepository.existsById(productId)) { // Changed 'jr.findById' to 'productRepository.existsById'
            return false;
        }
        try {
            productRepository.save(product); // Changed 'jr.save' to 'productRepository.save'
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean deleteProduct(Long productId) { // Changed method name to 'deleteProduct' and parameter type to Long
        if (!productRepository.existsById(productId)) { // Changed 'this.getById' to 'productRepository.existsById'
            return false;
        }
        productRepository.deleteById(productId); // Changed 'jr.deleteById' to 'productRepository.deleteById'
        return true;
    }
}
