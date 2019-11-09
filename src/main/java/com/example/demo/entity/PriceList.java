package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
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

    @OneToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "office_id")
    private Office office;

    @Column
    @Digits(fraction = 1, integer = 3, message = "integer 1")
    @Max(2)
    @DecimalMin("0.1")
    private Double coefficient;

}
