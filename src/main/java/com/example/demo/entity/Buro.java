package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.Set;

@Data
@Entity
@Table (name = "buro")
public class Buro {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @Column
    private String address;

    @Column
    private String fio;

    @Column
    @Digits(fraction = 0, integer = 9, message = "9 integer")
    private Integer phone;

    @OneToMany (fetch = FetchType.EAGER, mappedBy = "buro")
    private Set<Office> offices;
}
