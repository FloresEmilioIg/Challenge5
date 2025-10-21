package com.example.Challenge5.Controller;

import com.example.Challenge5.Model.Product;
import com.example.Challenge5.Repos.ProductRepos;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepos productRepository;

    public ProductController(ProductRepos productRepository) {
        this.productRepository = productRepository;
    }

    // 🔹 Crear un nuevo producto
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // 🔹 Listar todos los productos
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 🔹 Obtener producto por ID
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Product not found with id: " + id));
    }
}