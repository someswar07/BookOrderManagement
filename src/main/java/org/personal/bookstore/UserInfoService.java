package org.personal.bookstore;


import org.personal.models.User;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.concurrent.CompletableFuture;

@Service
public class UserInfoService {
    private final DynamoDbAsyncTable<User> userTable;

    public UserInfoService(DynamoDbEnhancedAsyncClient enhancedAsyncClient) {
        this.userTable = enhancedAsyncClient.table("user", TableSchema.fromBean(User.class));
    }

    public CompletableFuture<Void> addUser(User user) {
        return userTable.putItem(user);
    }
}

