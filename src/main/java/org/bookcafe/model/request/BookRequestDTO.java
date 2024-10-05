package org.bookcafe.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
public class BookRequestDTO {


    @NotNull(message = "Book name cannot be null")
    @Size(min = 2, max = 100, message = "Book name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Author name cannot be null")
    @Size(min = 2, max = 50, message = "Author name must be between 2 and 50 characters")
    private String authorName;

    @NotNull(message = "Price cannot be null")
    private double price;
    @NotNull(message = "Rent price connot be null")
    private double rentPrice;

}
