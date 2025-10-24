package com.example.Challenge5.Model;

import jakarta.persistence.*;

/**
 * Represents a customer in the store system.
 * Each customer has a name, address, and optional age.
 *
 * <p>This entity is mapped to the {@code customers} table in the database.</p>
 */
@Entity
@Table(name = "customers")
public class Customer {

    /** The unique identifier for the customer. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The customer's full name. Cannot be null. */
    @Column(nullable = false)
    private String name;

    /** The customer's residential address. Cannot be null. */
    @Column(nullable = false)
    private String address;

    /** The customer's age (optional). */
    private Integer age;

    /**
     * Default constructor required by JPA.
     */
    public Customer() {}

    /**
     * Constructs a new {@code Customer} with the given details.
     *
     * @param name the customer's name
     * @param address the customer's address
     * @param age the customer's age
     */
    public Customer(String name, String address, Integer age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    /** @return the unique identifier of the customer */
    public Long getId() { return id; }

    /** @param id sets the unique identifier of the customer */
    public void setId(Long id) { this.id = id; }

    /** @return the name of the customer */
    public String getName() { return name; }

    /** @param name sets the customer's name */
    public void setName(String name) { this.name = name; }

    /** @return the address of the customer */
    public String getAddress() { return address; }

    /** @param address sets the customer's address */
    public void setAddress(String address) { this.address = address; }

    /** @return the customer's age */
    public Integer getAge() { return age; }

    /** @param age sets the customer's age */
    public void setAge(Integer age) { this.age = age; }
}
