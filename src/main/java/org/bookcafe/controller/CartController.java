package org.bookcafe.controller;

import org.bookcafe.model.Cart;
import org.bookcafe.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public Cart viewCart(@PathVariable("userId") Long id) {
        return cartService.getCart(id);
    }

   /* @PostMapping("/{userId}/add/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public void addToCart(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId) {
        cartService.addToCart(userId, bookId, true); //true kiralama durumu için
    }*/

    @DeleteMapping("/{userId}/remove/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeFromCart(@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId) {
        cartService.removeFromCart(userId, bookId);
    }

    @PostMapping("/{userId}/add/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    public void addToCart(@PathVariable("userId") Long userId,
                          @PathVariable("bookId") Long bookId,
                          @RequestParam("isRent") boolean isRent) {
        cartService.addToCart(userId, bookId, isRent);
    }

}
