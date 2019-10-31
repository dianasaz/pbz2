package com.example.demo.repository;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    List<Hotel> findAllByStarsAndLocality(Integer stars, Locality locality);
}
