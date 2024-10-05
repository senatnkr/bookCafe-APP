package org.bookcafe.controller;

import org.bookcafe.model.Book;
import org.bookcafe.model.request.BookRequestDTO;
import org.bookcafe.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    void addBook_ReturnsAddedBook() throws Exception {
        // given
        BookRequestDTO bookRequestDTO = new BookRequestDTO();
        bookRequestDTO.setName("Son Yıldız");
        bookRequestDTO.setAuthorName("Rick Yancey");
        bookRequestDTO.setRentPrice(10);
        bookRequestDTO.setPrice(200.0);

        Book book = new Book();
        book.setName(bookRequestDTO.getName());
        book.setAuthorName(bookRequestDTO.getAuthorName());
        book.setrentPrice(bookRequestDTO.getRentPrice());
        book.setPrice(bookRequestDTO.getPrice());

        when(bookService.addBook(any(Book.class))).thenReturn(book);

        // when & then
        mockMvc.perform(post("/api/book/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Son Yıldız\",\"authorName\":\"Rick Yancey\" ,\"rentPrice\":\"10\", \"Price\":200.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Son Yıldız"))
                .andExpect(jsonPath("$.authorName").value("Rick Yancey"))
                .andExpect(jsonPath("$.rentPrice").value(10))
                .andExpect(jsonPath("$.price").value(200.0));
    }

    @Test
    void getAllBook_ReturnsBookList() throws Exception {
        // given
        Book book1 = new Book();
        book1.setName("Son Yıldız");
        book1.setAuthorName("Rick Yancey");
        book1.setrentPrice(10.0);
        book1.setPrice(200.0);

        Book book2 = new Book();
        book2.setName("Silber");
        book2.setAuthorName("Kerstin Gier");
        book2.setrentPrice(10.0);
        book2.setPrice(300.0);

        when(bookService.getAllBook()).thenReturn(List.of(book1, book2));

        // when & then
        mockMvc.perform(get("/api/book/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Son Yıldız"))
                .andExpect(jsonPath("$[1].name").value("Silber"));
    }

    @Test
    void rentBook_ReturnsRentedBook() throws Exception {
        // given
        Book book = new Book();
        book.setId(1L);
        book.setName("Son Yıldız");
        book.setAuthorName("Rick Yancey");
        book.setrentPrice(10.0);
        book.setPrice(200.0);

        when(bookService.rentBook(1L)).thenReturn(book);

        // when & then
        mockMvc.perform(put("/api/book/rent/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Son Yıldız"))
                .andExpect(jsonPath("$.rentPrice").value(10))
                .andExpect(jsonPath("$.price").value(200.0));
    }
}
