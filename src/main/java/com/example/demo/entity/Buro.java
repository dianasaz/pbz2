package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@Table(name = "buro")
public class Buro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(unique = true)
    private String name;

    @NotBlank
    @Column
    private String address;

    @NotBlank
    @Column
    private String fio;

    @NotBlank
    @Column
    @Digits(fraction = 0, integer = 9, message = "9 integer")
    private Integer phone;

    @OneToMany(mappedBy = "buro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Office> offices;
}
