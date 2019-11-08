package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@ToString
@Table (name = "locality")
public class Locality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (unique = true)
    private String name;

    @OneToMany(mappedBy = "locality", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Hotel> hotels;
/*
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "locality")
    private Set<Hotel> hotels;*/
}
