package com.example.demo.repository;

import com.example.demo.entity.TourInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourInfoRepository  extends JpaRepository<TourInfo, Integer> {
}
