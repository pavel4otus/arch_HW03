package ru.pavel2107.arch.basket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pavel2107.arch.basket.domain.Address;
import ru.pavel2107.arch.basket.domain.Good;
import ru.pavel2107.arch.basket.domain.Order;
import ru.pavel2107.arch.basket.domain.User;
import ru.pavel2107.arch.basket.service.BasketService;
import ru.pavel2107.arch.basket.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
public class BasketController {
    private BasketService basketService;
    private UserService   userService;


    @Autowired
    public BasketController( BasketService basketService, UserService userService){
        this.basketService = basketService;
        this.userService   = userService;
    }

    @GetMapping( value = "/microservices/v1/basket", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order get(Principal principal){
        User user = findUser( principal);
        Order basket = basketService.findBasket( user);
        return basket;
    }

    @PutMapping( value = "/microservices/v1/basket", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order save( Principal principal, Order basket){
        User user = findUser( principal);
        Order saved = basketService.save( basket);
        return saved;
    }

    @PostMapping( value = "/microservices/v1/user/basket/additem", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addItem( Principal principal, Good good, Integer count){
        User user = findUser( principal);
        return basketService.addToBasket( user, good, count);
    }

    @PostMapping( value = "/microservices/v1/user/basket/removeitem", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean removeItem( Principal principal, Good good, Integer count){
        User user = findUser( principal);
        return basketService.removeFromBasket( user, good, count);
    }

    private User findUser(Principal principal){
        User user = userService.findByEmail( principal.getName());
        return user;
    }
}
