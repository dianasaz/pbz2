package com.example.demo.repository;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Locality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM hotel WHERE hotel.stars = :stars AND hotel.locality_id = :locality")
    List<Hotel> findAllByStarsAndLocality(@Param("stars") Integer stars, @Param("locality") Integer locality);

    List<Hotel> findByLocality(Locality locality);
}
