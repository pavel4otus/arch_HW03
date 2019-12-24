package ru.pavel2107.arch.basket.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table( name = "streets")
@Data
@NoArgsConstructor
public class Street {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;

    @Column( name = "name")
    private String name;

    @ManyToOne
    @JoinColumn( name = "city_id")
    @JsonBackReference
    private City city;
}
