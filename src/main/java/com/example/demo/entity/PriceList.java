package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import java.util.Date;

@Data
@Entity
@Table (name = "price_list")
public class PriceList {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "date_from")
    private Date dateFrom;

    @Column (name = "date_to")
    private Date dateTo;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "buro_id")
    private Buro buro;

    @Column
    @Digits(fraction = 1, integer = 1, message = "integer 1")
    @DecimalMin("0.1")
    private Integer coefficient;

}
