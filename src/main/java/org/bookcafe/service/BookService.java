package org.bookcafe.service;

import org.bookcafe.exception.ResourceNotFoundException;
import org.bookcafe.exception.ValidationException;
import org.bookcafe.model.Book;
import org.bookcafe.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository =bookRepository;
    }
    //Kitap ekleme
    public Book addBook(Book book){
        bookRepository.save(book);
        return book;
    }

    //Tüm kitapların listelenmesi
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    //Kitap Kiralama
    public Book rentBook(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        if (!book.isAvailable()) {
            throw new ValidationException("Book is not available for rent.");
        }
        book.setAvailable(false);
        bookRepository.save(book);
        return book;
    }

    //Kitap Satma

    public Book sellBook(Long id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        if (!book.isAvailable()) {
            throw new ValidationException("Book is not available for sell.");
        }
        book.setAvailable(false);
        bookRepository.save(book);
        return book;
    }


}
