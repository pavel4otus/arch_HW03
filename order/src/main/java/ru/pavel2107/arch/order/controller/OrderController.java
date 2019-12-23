package ru.pavel2107.arch.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.pavel2107.arch.order.domain.*;
import ru.pavel2107.arch.order.repository.OrderRepo;
import ru.pavel2107.arch.order.repository.UserRepo;

import java.security.Principal;
import java.util.List;

@RestController
public class OrderController {

    private OrderRepo orderRepository;
    private UserRepo userRepository;

    @Autowired
    public OrderController( OrderRepo orderRepository, UserRepo userRepository){
        this.orderRepository = orderRepository;
        this.userRepository  = userRepository;
    }

    @PostMapping( value = "/microservices/v1/order/setaddress")
    public Order setAddress(Principal principal, @RequestParam Address address){
        User user    = userRepository.findByEmail( principal.getName());
        Order basket =  orderRepository.findByUserAndHistory_Empty( user);
        basket.setDeliveryAddress( address);
        return basket;
    }

    @PostMapping( value = "/microservices/v1/order/setpaymentmethod")
    public Order setPaymentMethod(Principal principal, @RequestParam PaymentMethod paymentMethod){
        User user    = userRepository.findByEmail( principal.getName());
        Order basket =  orderRepository.findByUserAndHistory_Empty( user);
        // basket.setDeliveryAddress( address);
        return basket;
    }

    @PostMapping( value = "/microservices/v1/order/setdeliverymethod")
    public Order setDeliveryMethod(Principal principal, @RequestParam DeliveryMethod deliveryMethod){
        User user    = userRepository.findByEmail( principal.getName());
        Order basket =  orderRepository.findByUserAndHistory_Empty( user);
        // basket.setDeliveryAddress( address);
        return basket;
    }


}
