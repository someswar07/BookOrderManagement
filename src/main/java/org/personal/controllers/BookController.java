package org.personal.controllers;

import org.personal.bookstore.BookCatalogService;
import org.personal.models.Book;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookCatalogService bookCatalogService;

    public BookController(BookCatalogService bookCatalogService) {
        this.bookCatalogService = bookCatalogService;
    }

    @PostMapping(path = "/addBook")
    public CompletableFuture<String> addBook(@RequestBody Book book) {
        return bookCatalogService.addBook(book)
                .thenApply(v -> "Book added successfully!")
                .exceptionally(e -> "Failed to add book: " + e.getMessage());
    }
}
