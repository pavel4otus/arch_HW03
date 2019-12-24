package ru.pavel2107.arch.createschema.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "orders")
@Data
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;


    @ManyToOne
    @JoinColumn( name = "user_id")
    @JsonBackReference
    private User user;

    @OneToOne
    private Address deliveryAddress;

    @OneToOne
    private PaymentMethod paymentMethod;

    @OneToOne
    private DeliveryMethod deliveryMethod;

    @OneToMany( mappedBy = "order", fetch = FetchType.LAZY)
    private Set<StatusHistory> history = new HashSet<>();

    @OneToMany( mappedBy = "order", fetch = FetchType.LAZY)
    private Set<OrderItem> items = new HashSet<>();


}
