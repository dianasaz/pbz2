package com.example.demo.repository;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.TourInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourInfoRepository  extends JpaRepository<TourInfo, Integer> {
    @Query( nativeQuery = true, value = "select * from hotel h join tour_info_hotels t on h.id = t.hotels_id where h.stars = 5")
    List<Integer> findIdOfHotelsWithFiveStars();
}
