package org.bookcafe.model;

import org.bookcafe.exception.ResourceNotFoundException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "cart")

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
    private List<CartItem> items = new ArrayList<>();

    private double totalPrice;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

    public void addItem(CartItem item) {
        items.add(item);
        totalPrice += item.getBook().getPrice();
    }

    public void removeItem(CartItem item) {
        items.remove(item);
        totalPrice -= item.getBook().getPrice();
    }

    public CartItem getCartItemByBookId(Long bookId) {
        return items
                .stream()
                .filter(item ->
                        item.getBook().getId().equals(bookId)
                ).findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Item not found."));
    }


}
