package com.example.demo.repository;

import com.example.demo.entity.Buro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BuroRepository extends JpaRepository<Buro, Integer> {
    @Query(nativeQuery = true, value = "select * from buro where buro.name = :name")
    Buro findBuroByName (@Param("name") String name);
}
