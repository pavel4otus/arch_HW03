package ru.pavel2107.arch.basket.domain;

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

    @Column( name = "user_id")
    private Long user_id;

    @OneToMany( mappedBy = "order", fetch = FetchType.LAZY)
    private Set<StatusHistory> history = new HashSet<>();

    @OneToMany( mappedBy = "order", fetch = FetchType.LAZY)
    private Set<OrderItem> items = new HashSet<>();


}
