package ru.pavel2107.arch.catalog.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "goods_spb")
@Data
@NoArgsConstructor
public class GoodSpb {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private Long id;

    @Column( name = "skud")
    private Long skud;

    @Column( name = "name")
    private String name;

    @Column( name = "description")
    private String description;

    @Column( name = "smallpictureurl")
    private String smallPictureUrl;

    @Column( name = "largepictureurl")
    private String largePictureUrl;


    @ManyToOne
    @JoinColumn( name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn( name = "brand_id")
    private Brand brand;

    @ManyToMany( cascade ={ CascadeType.ALL})
    @JoinTable(
            name = "goods_on_warehouses",
            joinColumns = { @JoinColumn( name = "good_id")},
            inverseJoinColumns = { @JoinColumn( name = "warehouse_id") }
    )
    private Set<WareHouse> wareHouses = new HashSet<>();

}
