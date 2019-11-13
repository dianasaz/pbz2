package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REMOVE}, mappedBy = "localities")
    private List<Tour> tours;

    public Locality(Integer id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "Locality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
