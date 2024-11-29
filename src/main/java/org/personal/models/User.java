package org.personal.models;


import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

@Data
@DynamoDbBean
public class User {
    private String id;
    private String name;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
}

