package com.example.Challenge5.Controller;

import com.example.Challenge5.Model.Customer;
import com.example.Challenge5.Repos.CustomerRepos;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerRepos customerRepository;

    public CustomerController(CustomerRepos customerRepository) {
        this.customerRepository = customerRepository;
    }

    // 🔹 Crear un nuevo cliente
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    // 🔹 Listar todos los clientes
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // 🔹 Obtener cliente por ID
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Customer not found with id: " + id));
    }
}