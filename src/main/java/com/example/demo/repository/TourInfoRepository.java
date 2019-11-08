package com.example.demo.repository;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.TourInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourInfoRepository  extends JpaRepository<TourInfo, Integer> {
    @Query(nativeQuery = true, value = "select distinct name, stars, locality_id from hotel join tour_info ti on hotel.id = ti.hotel_id where hotel.stars = 5")
    List<Hotel> findHotels();
}
