package ru.pavel2107.arch.basket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "warehouses")
@Data
@NoArgsConstructor
public class WareHouse {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;

    @Column( name = "name")
    private String name;

    @Column( name = "contacts")
    private String contacts;

    @Column( name = "schedule")
    private String schedule;

    @Column( name = "address_id")
    private Long address_id;

    @ManyToMany( mappedBy = "wareHouses")
    @JsonIgnore
    private Set<Good> goods = new HashSet<>();
}
