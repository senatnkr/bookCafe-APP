package org.bookcafe.service;

import org.bookcafe.exception.ResourceNotFoundException;
import org.bookcafe.model.Cart;
import org.bookcafe.model.CartItem;
import org.bookcafe.model.Book;
import org.bookcafe.model.User;
import org.bookcafe.repository.CartRepository;
import org.bookcafe.repository.BookRepository;
import org.bookcafe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private BookRepository bookRepository;
    private CartRepository cartRepository;
    private UserRepository userRepository;




    @Autowired
    public CartService(BookRepository bookRepository, CartRepository cartRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public void saveEmptyCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        cartRepository.save(cart);
    }

    public Cart getCart(Long userId) {
        return cartRepository.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("Book not found."));
    }

    public void addToCart(Long userId, Long bookId, boolean isRent) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found."));
        Cart cart = getCart(userId); // Kullanıcının mevcut sepetini bul veya yeni sepet oluştur
        CartItem item = new CartItem();
        item.setBook(book);
        item.setRent(isRent);  // Kitap kiralanacak mı satın mı alınacak

        if (isRent) {
            cart.setTotalPrice(cart.getTotalPrice() + book.getrentPrice());
        } else {
            cart.setTotalPrice(cart.getTotalPrice() + book.getPrice());
        }

        cart.addItem(item);
        cartRepository.save(cart);
    }
  /*  public void addToCart(Long userId, Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found."));
        Cart cart = getCart(userId);
        CartItem item = new CartItem();
        item.setBook(book);
        cart.addItem(item);
        cartRepository.save(cart);
    }*/

    public void removeFromCart(Long userId, Long bookId) {
        Cart cart = getCart(userId);
        CartItem item = cart.getCartItemByBookId(bookId);
        cart.removeItem(item);
        cartRepository.save(cart);
    }

    public double getTotalPrice(Long userId) {
        Cart cart = getCart(userId);
        return cart.getTotalPrice();
    }

    public void clearCart(Long userId) {
        Cart cart = getCart(userId);
        cart.getItems().clear();
        cart.setTotalPrice(0);
        cartRepository.save(cart);
    }
}
