package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import java.util.List;

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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Locality> localities;

    @Column
    @Digits(fraction = 0, integer = 2, message = "max is 21")
    @Max(21)
    @DecimalMin("7")
    private Integer night;

    @Column
    @Enumerated(EnumType.STRING)
    private TourType tourType;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TourInfo> tourInfoList;

    public String getLocalitiesName(){
        String s = "";
        for (Locality l : localities) s += " " + l.getName();
        return s;
    }
}
