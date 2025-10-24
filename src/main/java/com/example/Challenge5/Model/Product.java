package com.example.Challenge5.Model;

import jakarta.persistence.*;

/**
 * Represents a product available in the store.
 * Each product has a name, description, and price.
 *
 * <p>This entity is mapped to the {@code products} table in the database.</p>
 */
@Entity
@Table(name = "products")
public class Product {

    /** The unique identifier for the product. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The name of the product. Cannot be null. */
    @Column(nullable = false)
    private String name;

    /** A short description of the product (optional). */
    private String description;

    /** The price of the product. Cannot be null. */
    @Column(nullable = false)
    private Double price;

    /**
     * Default constructor required by JPA.
     */
    public Product() {}

    /**
     * Constructs a new {@code Product} with the specified details.
     *
     * @param name the name of the product
     * @param description a description of the product
     * @param price the price of the product
     */
    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /** @return the unique identifier of the product */
    public Long getId() { return id; }

    /** @param id sets the unique identifier of the product */
    public void setId(Long id) { this.id = id; }

    /** @return the name of the product */
    public String getName() { return name; }

    /** @param name sets the name of the product */
    public void setName(String name) { this.name = name; }

    /** @return the description of the product */
    public String getDescription() { return description; }

    /** @param description sets the description of the product */
    public void setDescription(String description) { this.description = description; }

    /** @return the price of the product */
    public Double getPrice() { return price; }

    /** @param price sets the price of the product */
    public void setPrice(Double price) { this.price = price; }
}