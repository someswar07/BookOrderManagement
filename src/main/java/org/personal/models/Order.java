package org.personal.models;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

@Data
@DynamoDbBean
public class Order {
    private String id;
    private String userId;
    private String bookId;
    private int quantity;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
}
