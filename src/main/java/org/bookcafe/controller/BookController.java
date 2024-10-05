package org.bookcafe.controller;

import org.bookcafe.model.Book;
import org.bookcafe.model.request.BookRequestDTO;
import org.bookcafe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// kitap işlemleri için kontrolcü sınıfı
@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Yeni kitap ekleme işlemi
    @PostMapping("/add")
    public Book addBook(@Valid @RequestBody BookRequestDTO bookRequestDTO) {
        // DTO'dan Book modeline dönüştürme
        Book book = new Book();
        book.setName(bookRequestDTO.getName());
        book.setAuthorName(bookRequestDTO.getAuthorName());
        book.setPrice(bookRequestDTO.getPrice());
        book.setrentPrice(bookRequestDTO.getRentPrice());
        return bookService.addBook(book);
    }

    // Mevcut kitapları listeleme işlemi
    @GetMapping("/all")
    public List<Book> getAllBook() {
        return bookService.getAllBook();
    }

    // Kitap kiralama işlemi
    @PutMapping("/rent/{id}")
    public Book rentBook(@PathVariable Long id) {
        return bookService.rentBook(id);
    }

    // Kitap satma işlemi
    @PutMapping("/sell/{id}")
    public Book sellBook(@PathVariable Long id) {
        return bookService.sellBook(id);
    }


}
