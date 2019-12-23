package ru.pavel2107.arch.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table( name = "cities")
@Data
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "name")
    private String name;

    @Column( name = "code")
    private String code;

    @ManyToOne
    @JoinColumn( name = "country_id")
    @JsonIgnore
    private Country country;

    @OneToMany( mappedBy = "city", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Street> streets = new HashSet<>();

}
