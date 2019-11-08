package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import java.util.List;

@Data
@ToString
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

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TourInfo> tourInfoList;
}
