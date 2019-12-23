package ru.pavel2107.arch.catalog.domain;

import javax.persistence.*;

@Entity
@Table( name = "addresses")
public class Address {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn( name = "street_id")
    private Street street;

    @Column( name = "zip")
    private String zip;

    @Column( name = "house")
    private String house;

    @Column( name = "building")
    private String building;

    @Column( name = "flat")
    private String flat;

}
