package com.example.demo.repository;

import com.example.demo.entity.Office;
import com.example.demo.entity.PriceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceListRepository  extends JpaRepository<PriceList, Integer> {
    @Query (nativeQuery = true, value = "select * from price_list pl where pl.office_id = :office AND :date between pl.date_from and pl.date_to order by pl.date_from limit 1")
    Optional<PriceList> findLastByOfficeAndDate(@Param("office") Integer id, @Param("date") Date date);
}
