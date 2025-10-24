package com.example.Challenge5.Controller;

import com.example.Challenge5.Model.Product;
import com.example.Challenge5.Repos.ProductRepos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller that manages operations related to {@link Product}.
 * <p>
 * Provides endpoints for creating, retrieving, updating, and deleting
 * products in the store catalog.
 * </p>
 *
 * <p>Accessible at <b>/api/products</b>.</p>
 */
@RestController
@RequestMapping("/api/products")
@Tag(name = "Products", description = "Endpoints for managing product catalog")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductRepos productRepository;

    /**
     * Constructs a new {@code ProductController}.
     *
     * @param productRepository the repository used for product persistence
     */
    public ProductController(ProductRepos productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Creates and saves a new product in the database.
     *
     * @param product the product data to create
     * @return the created {@link Product} entity
     */
    @Operation(summary = "Create a new product")
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    /**
     * Retrieves all products from the catalog.
     *
     * @return a list of all {@link Product} entities
     */
    @Operation(summary = "Get all products")
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieves a specific product by its ID.
     *
     * @param id the unique identifier of the product
     * @return the {@link Product} entity if found
     * @throws RuntimeException if no product with the given ID exists
     */
    @Operation(summary = "Get a product by ID")
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    /**
     * Updates an existing product with new details.
     *
     * @param id the ID of the product to update
     * @param productDetails the updated product information
     * @return the updated {@link Product} entity
     * @throws RuntimeException if the product does not exist
     */
    @Operation(summary = "Update product details")
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        existing.setName(productDetails.getName());
        existing.setDescription(productDetails.getDescription());
        existing.setPrice(productDetails.getPrice());
        return productRepository.save(existing);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     */
    @Operation(summary = "Delete a product")
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
