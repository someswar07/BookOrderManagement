package org.personal.bookstore;

import org.personal.models.Book;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.concurrent.CompletableFuture;

@Service
public class BookCatalogService {
    private final DynamoDbAsyncTable<Book> bookTable;

    public BookCatalogService(DynamoDbEnhancedAsyncClient enhancedAsyncClient) {
        this.bookTable = enhancedAsyncClient.table("book", TableSchema.fromBean(Book.class));
    }

    public CompletableFuture<Void> addBook(Book book) {
        return bookTable.putItem(book);
    }
}

