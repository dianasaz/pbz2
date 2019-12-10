package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@ToString
@Entity
@Table (name = "price_list")
public class PriceList {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column (name = "date_from")
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private Date dateFrom;

    @NotBlank
    @Column (name = "date_to")
    @DateTimeFormat(pattern = "DD-MM-YYYY")
    private Date dateTo;

    @OneToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "office_id")
    private Office office;

    @NotBlank
    @Column
    @Digits(fraction = 3, integer = 3, message = "integer 1")
    @Max(5)
    @DecimalMin("0")
    private Double coefficient;
}
