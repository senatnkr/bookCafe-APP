package org.bookcafe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Otomatik artan ID

    @NotNull(message = "Book name cannot be null")
    @Size(min = 2, max = 100, message = "Book name must be between 2 and 100 characters")
    private String name; // Kitap adı

    @NotNull(message = "Author name cannot be null")
    @Size(min = 2, max = 50, message = "Author name must be between 2 and 50 characters")
    private String authorName; // Yazar adı

    @NotNull(message = "Price cannot be null")
    private double rentprice; // Kiralama ücreti

    @NotNull(message = "Price cannot be null")
    private double price; // satış ücreti



    @Getter
    @Setter
    private boolean available = true; // Kiralama durumu

    // Getter ve Setter metodları

    public @NotNull(message = "Book name cannot be null")
    @Size(min = 2, max = 100, message = "Book name must be between 2 and 100 characters")
    String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Book name cannot be null")
    @Size(min = 2, max = 100, message = "Book name must be between 2 and 100 characters") String name) {
        this.name = name;
    }

    public @NotNull(message = "Author name cannot be null")
    @Size(min = 2, max = 50, message = "Author name must be between 2 and 50 characters")
    String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(@NotNull(message = "Author name cannot be null") String authorName) {
        this.authorName = authorName;
    }

    @NotNull(message = "Rent price cannot be null")
    public double getrentPrice() {
        return rentprice;
    }

    public void setrentPrice(@NotNull(message = "Rent price cannot be null") double rentprice) {
        this.rentprice = rentprice;
    }

    @NotNull(message = "Price cannot be null")
    public double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Price cannot be null") double price) {
        this.price = price;
    }


}
