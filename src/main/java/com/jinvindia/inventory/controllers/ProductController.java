package com.jinvindia.inventory.controllers;

import com.jinvindia.inventory.entities.Product;
import com.jinvindia.inventory.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/inventory/product")
public class ProductController {

    private final ProductService productService;
    
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }
    
    @PutMapping("/prodcuts/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") Integer productId) {
        return productService.updateProduct(product, productId);
    }

    @GetMapping("/findProducts")
    public ResponseEntity<Collection<Product>> findProducts() {
        Collection<Product> allProducts = productService.getAllProduct();

        return ResponseEntity.ok(allProducts);
    }
    
    @GetMapping("/findProduct")
    public ResponseEntity<Collection<Product>> findProduct(String name) {
        Collection<Product> namedProducts = productService.findByName(name);

        return ResponseEntity.ok(namedProducts);
    }
    

}
