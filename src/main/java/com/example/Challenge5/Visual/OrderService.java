package com.example.Challenge5.Visual;

import com.example.Challenge5.Model.Order;
import com.example.Challenge5.Model.Customer;
import com.example.Challenge5.Model.Product;
import com.example.Challenge5.Repos.OrderRepos;
import com.example.Challenge5.Repos.CustomerRepos;
import com.example.Challenge5.Repos.ProductRepos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepos orderRepository;
    private final CustomerRepos customerRepository;
    private final ProductRepos productRepository;

    public OrderService(OrderRepos orderRepository,
                        CustomerRepos customerRepository,
                        ProductRepos productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    // Create an order
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Obtain all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Obtain an order by ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    // Update order
    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));

        // Validate that client & product exists
        Customer customer = customerRepository.findById(orderDetails.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Product product = productRepository.findById(orderDetails.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Update fields
        existingOrder.setCustomer(customer);
        existingOrder.setProduct(product);
        existingOrder.setOrderDate(orderDetails.getOrderDate());
        existingOrder.setDeliveryDate(orderDetails.getDeliveryDate());

        return orderRepository.save(existingOrder);
    }

    // Eliminate order
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(id);
    }
}
