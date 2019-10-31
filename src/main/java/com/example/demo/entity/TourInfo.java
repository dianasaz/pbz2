package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;

@Data
@Entity
@Table (name = "tour_info")
public class TourInfo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "locality_id")
    private Locality locality;

    @Column (name = "departure_point")
    private String departurePoint;

    @Column
    @Enumerated (EnumType.STRING)
    private Transport transport;

    @Column
    @Digits(fraction = 0, integer = 5)
    private Integer price;

    @Transient
    private Integer actualPrice;

    public void getActualPrice(Integer coefficient) {
        actualPrice = price * coefficient;
    }

}
