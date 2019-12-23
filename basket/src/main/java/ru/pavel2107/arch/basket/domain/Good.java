package ru.pavel2107.arch.basket.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "goods")
@Data
@NoArgsConstructor
public class Good {

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

    @Column( name = "smallPictureUrl")
    private String smallPictureUrl;

    @Column( name = "largePictureUrl")
    private String largePictureUrl;

    @Column( name = "categroy_id")
    private Long category_id;

    @Column( name = "brand_id")
    private Long brand_id;

    @ManyToMany( cascade ={ CascadeType.ALL})
    @JoinTable(
            name = "goods_on_warehouses",
            joinColumns = { @JoinColumn( name = "good_id")},
            inverseJoinColumns = { @JoinColumn( name = "warehouse_id") }
    )
    private Set<WareHouse> wareHouses = new HashSet<>();

}
