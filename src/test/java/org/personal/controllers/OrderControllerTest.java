package org.personal.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.personal.bookstore.BookOrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookOrderManagementService orderService;

    @Test
    void placeOrderTest() throws Exception {
        Mockito.when(orderService.placeOrder(any())).thenReturn(CompletableFuture.completedFuture(null));

        mockMvc.perform(post("/orders")
                        .contentType("application/json")
                        .content("{\"id\":\"1\",\"userId\":\"1\",\"bookId\":\"1\",\"quantity\":1}"))
                 .andExpect(status().isOk());
    }
}
