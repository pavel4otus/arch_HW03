package ru.pavel2107.arch.order.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pavel2107.arch.order.domain.Good;
import ru.pavel2107.arch.order.domain.Order;

import javax.persistence.*;

@Entity
@Table( name = "order_items")
@Data
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn( name = "order_id")
    private Order order;

    @Column( name = "quantity")
    private Integer quantity;

    @Column( name = "price")
    private Double price;

    @OneToOne
    @Column( name = "good_id")
    private Good good;

    public OrderItem( Order order, Good good ){
        this.id = 0L;
        this.order = order;
        this.quantity = 0;
        this.price = 0d;
        this.good = good;
    }
}
