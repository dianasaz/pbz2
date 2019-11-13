package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    @Digits(integer = 1, fraction = 0, message = "1 integer")
    @Max(5)
    @DecimalMin("1")
    private Integer stars;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "locality_id")
    private Locality locality;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REMOVE}, mappedBy = "hotels")
    private List<TourInfo> tourInfoList;

    public Hotel(Integer id, String name, Integer stars, Locality locality) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.locality = locality;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", locality=" + locality +
                '}';
    }
}
