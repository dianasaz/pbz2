package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table (name = "locality")
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (unique = true)
    private String name;
/*
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "locality")
    private Set<Hotel> hotels;*/
}
