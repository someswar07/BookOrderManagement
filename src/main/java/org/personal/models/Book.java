package org.personal.models;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

@Data
@DynamoDbBean
public class Book {
    private String id;
    private String title;
    private String author;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
}

