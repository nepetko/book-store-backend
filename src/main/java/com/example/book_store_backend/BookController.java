/*
 * BookController.java
 *
 * created at 4/7/2025 by p.cholashki <p.cholashki@seeburger.com>
 *
 * Copyright (c) SEEBURGER AG, Germany. All Rights Reserved.
 */
package com.example.book_store_backend;


import static com.example.book_store_backend.BookGenerator.generateRandomBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author p.cholashki
 */
@RestController
@RequestMapping("/api/books")
public class BookController
{
    final List<Book> books = new ArrayList<>();


    BookController()
    {
        final Random random = new Random();

        for (int i = 0; i < 31; i++)
        {
            books.add(generateRandomBook(i, random));
        }
    }


    @GetMapping
    public List<Book> getBooks()
    {
        return books;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id)
    {
        Optional<Book> book = books.stream().filter(b -> b.getId().equals(id)).findFirst();
        return book.map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book)
    {
        books.add(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book updatedBook)
    {
        for (Book book : books)
        {
            if (book.getId().equals(id))
            {
                book.setAuthor(updatedBook.getAuthor());
                book.setTitle(updatedBook.getTitle());
                book.setGenre(updatedBook.getGenre());
                book.setPrice(updatedBook.getPrice());
                book.setCreatedAt(updatedBook.getCreatedAt());

                return ResponseEntity.ok(book);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id)
    {
        boolean removed = books.removeIf(b -> b.getId().equals(id));
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
