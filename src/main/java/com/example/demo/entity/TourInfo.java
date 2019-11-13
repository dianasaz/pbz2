package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.List;

@Data
@Entity
@ToString
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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Hotel> hotels;

    @Column (name = "departure_point")
    private String departurePoint;

    @Column
    @Enumerated (EnumType.STRING)
    private Transport transport;

    @Column
    @Digits(fraction = 0, integer = 5)
    private Double price;

    @Column
    private Double actualPrice;

    public String getHotelNames(){
        String s = "";
        for (Hotel h : hotels) s+= " " + h.getName();
        return s;
    }
    public void updateActualPrice(Double coefficient) {
        actualPrice = price * coefficient;
    }
}
