package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;

@Data
@Entity
@Table
public class Tour {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "office_id")
    private Office office;

    @Column
    @Digits(fraction = 0, integer = 2, message = "max is 21")
    @Max(21)
    @DecimalMin("7")
    private Integer night;

    @Column
    @Enumerated(EnumType.STRING)
    private TourType tourType;



}
