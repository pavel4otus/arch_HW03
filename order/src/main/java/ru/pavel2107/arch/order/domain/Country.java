package ru.pavel2107.arch.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;

    @Column( name = "code")
    private String code;

    @Column( name = "name")
    private String name;

    @OneToMany( mappedBy = "country", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Brand> brands = new HashSet<>();

    @OneToMany( mappedBy = "country", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<City> cities = new HashSet<>();
}
