package ru.pavel2107.arch.basket.service;


import ru.pavel2107.arch.basket.domain.Address;
import ru.pavel2107.arch.basket.domain.Good;
import ru.pavel2107.arch.basket.domain.Order;
import ru.pavel2107.arch.basket.domain.User;

import java.util.List;

public interface BasketService {
    Order findBasket( User user);
    Order save(Order order);
    boolean addToBasket( User user, Good good, Integer count);
    boolean removeFromBasket( User user, Good good, Integer count);
    void clearBasket( User user);
}
