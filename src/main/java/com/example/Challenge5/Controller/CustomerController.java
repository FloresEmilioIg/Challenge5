package com.example.Challenge5.Controller;

import com.example.Challenge5.Model.Customer;
import com.example.Challenge5.Repos.CustomerRepos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller responsible for managing {@link Customer} entities.
 * <p>
 * Exposes endpoints to create, read, update, and delete customer records.
 * </p>
 *
 * <p>Accessible at <b>/api/customers</b>.</p>
 */
@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customers", description = "Endpoints for managing customer information")
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerRepos customerRepository;

    /**
     * Constructs a new {@code CustomerController}.
     *
     * @param customerRepository the repository used for customer persistence
     */
    public CustomerController(CustomerRepos customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Creates a new customer record.
     *
     * @param customer the customer information to create
     * @return the created {@link Customer} entity
     */
    @Operation(summary = "Create a new customer")
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * Retrieves all customers from the database.
     *
     * @return a list of all {@link Customer} entities
     */
    @Operation(summary = "Get all customers")
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Retrieves a specific customer by their ID.
     *
     * @param id the unique identifier of the customer
     * @return the {@link Customer} entity if found
     * @throws RuntimeException if the customer does not exist
     */
    @Operation(summary = "Get a customer by ID")
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    /**
     * Updates the details of an existing customer.
     *
     * @param id the ID of the customer to update
     * @param customerDetails the updated customer information
     * @return the updated {@link Customer} entity
     * @throws RuntimeException if the customer does not exist
     */
    @Operation(summary = "Update customer details")
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
        Customer existing = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        existing.setName(customerDetails.getName());
        existing.setAge(customerDetails.getAge());
        existing.setAddress(customerDetails.getAddress());
        return customerRepository.save(existing);
    }

    /**
     * Deletes a customer by their ID.
     *
     * @param id the ID of the customer to delete
     */
    @Operation(summary = "Delete a customer")
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }
}
