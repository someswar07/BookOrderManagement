package org.personal.controllers;

import org.personal.bookstore.BookOrderManagementService;
import org.personal.models.Order;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final BookOrderManagementService orderService;

    public OrderController(BookOrderManagementService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/place")
    public CompletableFuture<String> placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order)
                .thenApply(v -> "Order placed successfully!")
                .exceptionally(e -> "Failed to place order: " + e.getMessage());
    }
}

