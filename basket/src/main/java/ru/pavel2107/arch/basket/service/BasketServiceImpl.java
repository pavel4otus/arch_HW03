package ru.pavel2107.arch.basket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pavel2107.arch.basket.domain.*;
import ru.pavel2107.arch.basket.repository.OrderRepo;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService {

    private OrderRepo repository;

    @Autowired
    public BasketServiceImpl(OrderRepo repository){
        this.repository = repository;;
    }

    //
    // корзина это просто заказ без истории состояний
    //
    @Override
    public Order findBasket( User user){
        return repository.findByUserAndHistory_Empty( user);
    }

    @Override
    public Order save(Order order) {
        return repository.save( order);
    }

    //
    // добавляем итем в корзину
    //
    @Override
    public boolean addToBasket( User user, Good good, Integer count){
        return changeBasket( user, good, count);
    }

    //
    // удаляем итем из корзины
    //
    @Override
    public boolean removeFromBasket( User user, Good good, Integer count){
        return changeBasket( user, good, count);
    }

    private boolean changeBasket( User user, Good good, Integer count){
        Order basket = findBasket( user);
        if( basket == null){
            basket = new Order();
        };
        OrderItem item = basket.getItems()
                .stream()
                .filter( orderItem -> orderItem.getGood().equals( good))
                .findFirst().orElse( new OrderItem( basket, good));
        item.setQuantity( item.getQuantity() + count);
        if(item.getQuantity() == 0){
            basket.getItems().add( item);
        }
        if( item.getQuantity() <= 0) {
            basket.getItems().remove( item);
        }
        return true;
    }


    //
    // удаляем содержимое корзины
    //
    @Override
    public void clearBasket( User user){
        Order basket = findBasket( user);
        for( OrderItem item: basket.getItems()) {
            basket.getItems().remove( item);
        }
    }

}
