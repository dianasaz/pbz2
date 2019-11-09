package com.example.demo.repository;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.TourInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourInfoRepository  extends JpaRepository<TourInfo, Integer> {
    @Query(value = "select new com.example.demo.entity.Hotel(h.id, h.name, h.stars, h.locality) from Hotel h join TourInfo ti on h.id = ti.hotel.id where h.stars = 5")
    List<Hotel> findHotels();
}
