package org.personal.bookstore;

import org.personal.models.Order;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.concurrent.CompletableFuture;

@Service
public class BookOrderManagementService {
    private final DynamoDbAsyncTable<Order> orderTable;

    public BookOrderManagementService(DynamoDbEnhancedAsyncClient enhancedAsyncClient) {
        this.orderTable = enhancedAsyncClient.table("order", TableSchema.fromBean(Order.class));
    }

    public CompletableFuture<Void> placeOrder(Order order) {
        return orderTable.putItem(order);
    }
}

