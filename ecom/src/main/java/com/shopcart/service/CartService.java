package com.shopcart.service;

import com.shopcart.model.Cart;

public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
}
