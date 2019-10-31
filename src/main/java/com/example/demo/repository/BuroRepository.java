package com.example.demo.repository;

import com.example.demo.entity.Buro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuroRepository extends JpaRepository<Buro, Integer> {
    Buro findBuroByName (String name);
}
