package com.example.demo.repository;

import com.example.demo.entity.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalityRepository  extends JpaRepository<Locality, Integer> {
    Locality findLocalityByName(String name);
}
