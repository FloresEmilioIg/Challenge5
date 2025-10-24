package com.example.Challenge5.Controller;

import com.example.Challenge5.Model.Order;
import com.example.Challenge5.Visual.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller that handles all operations related to {@link Order} management.
 * <p>
 * This controller exposes endpoints for creating, retrieving, updating,
 * and deleting customer orders. It delegates the business logic to the
 * {@link OrderService}.
 * </p>
 *
 * <p>Accessible at <b>/api/orders</b>.</p>
 */
@RestController
@RequestMapping("/api/orders")
@Tag(name = "Orders", description = "Endpoints for managing customer orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;

    /**
     * Constructs a new {@code OrderController} with the specified {@link OrderService}.
     *
     * @param orderService the service used to handle order operations
     */
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Retrieves all orders from the database.
     *
     * @return a {@link ResponseEntity} containing a list of all orders
     */
    @Operation(summary = "Get all orders", description = "Retrieve all orders from the database")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of orders")
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    /**
     * Retrieves a specific order by its ID.
     *
     * @param id the unique identifier of the order
     * @return a {@link ResponseEntity} containing the order if found,
     *         or a {@code 404 Not Found} response if it does not exist
     */
    @Operation(summary = "Get an order by ID", description = "Retrieve a specific order using its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Order found",
                    content = @Content(schema = @Schema(implementation = Order.class))),
            @ApiResponse(responseCode = "404", description = "Order not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }

    /**
     * Creates a new order and stores it in the database.
     *
     * @param order the order data to be created
     * @return a {@link ResponseEntity} containing the created order with HTTP status {@code 201 Created}
     */
    @Operation(summary = "Create a new order", description = "Register a new order for a customer and product")
    @ApiResponse(responseCode = "201", description = "Order successfully created")
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.status(201).body(orderService.createOrder(order));
    }

    /**
     * Updates the details of an existing order.
     *
     * @param id the ID of the order to update
     * @param orderDetails the updated order data
     * @return a {@link ResponseEntity} containing the updated order,
     *         or a {@code 404 Not Found} response if the order does not exist
     */
    @Operation(summary = "Update an order", description = "Modify an existing order’s details")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Order successfully updated"),
            @ApiResponse(responseCode = "404", description = "Order not found", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        Order updated = orderService.updateOrder(id, orderDetails);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    /**
     * Deletes an order permanently by its ID.
     *
     * @param id the ID of the order to delete
     * @return an empty {@link ResponseEntity} with HTTP status {@code 204 No Content}
     */
    @Operation(summary = "Delete an order", description = "Delete an order permanently")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Order successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Order not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
