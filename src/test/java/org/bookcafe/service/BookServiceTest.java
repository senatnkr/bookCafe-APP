package org.bookcafe.service;

import org.bookcafe.exception.ResourceNotFoundException;
import org.bookcafe.exception.ValidationException;
import org.bookcafe.model.Book;
import org.bookcafe.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void addBook_SaveBook() {
        // given
        Book book = new Book();
        book.setId(1L);
        book.setName("Son Yıldız");
        book.setAvailable(true);

        when(bookRepository.save(book)).thenReturn(book);

        // when
        Book savedBook = bookService.addBook(book);

        // then
        assertEquals(book.getName(), savedBook.getName());
        verify(bookRepository).save(book);
    }

    @Test
    public void getAllBook_ReturnsBookList() {
        // given
        Book book = new Book();
        book.setId(1L);
        book.setName("Son Yıldız");
        book.setAvailable(true);
        book.setPrice(10.0);

        when(bookRepository.findAll()).thenReturn(List.of(book));

        // when
        List<Book> books = bookService.getAllBook();

        // then
        assertEquals(1, books.size());
        assertEquals(book.getName(), books.get(0).getName());
        assertEquals(book.getPrice(), books.get(0).getPrice());
        verify(bookRepository).findAll();
    }

    @Test
    public void rentBook_BookExists_ChangesAvailability() {
        // given
        Book book = new Book();
        book.setId(1L);
        book.setName("Son Yıldız");
        book.setAvailable(true);

        when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
        when(bookRepository.save(book)).thenReturn(book);

        // when
        Book rentedBook = bookService.rentBook(book.getId());

        // then
        assertFalse(rentedBook.isAvailable());
        verify(bookRepository).findById(book.getId());
        verify(bookRepository).save(book);
    }

    @Test
    public void rentBook_BookDoesNotExist_ThrowsResourceNotFoundException() {
        // given
        Book book = new Book();
        book.setId(1L);
        book.setName("Son Yıldız");
        book.setAvailable(true);

        when(bookRepository.findById(book.getId())).thenReturn(Optional.empty());

        // when & then
        assertThrows(ResourceNotFoundException.class, () -> {
            bookService.rentBook(book.getId());
        });

        verify(bookRepository).findById(book.getId());
        verify(bookRepository, never()).save(any());
    }

    @Test
    public void rentBook_BookNotAvailable_ThrowsValidationException() {
        // given
        Book book = new Book();
        book.setId(1L);
        book.setName("Son Yıldız");
        book.setAvailable(false);

        when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));

        // when & then
        assertThrows(ValidationException.class, () -> {
            bookService.rentBook(book.getId());
        });

        verify(bookRepository).findById(book.getId());
        verify(bookRepository, never()).save(any());
    }
}
