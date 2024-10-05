package org.bookcafe.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bookcafe.model.Book;

@Entity
@Getter
@Setter
@Table(name = "cartItem")
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;


    private boolean isRent;  // Kitap kiralanacak mı yoksa satın mı alınacak

}
