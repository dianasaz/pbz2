package com.example.demo.service;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.TourInfo;

import java.util.List;

public interface TourInfoService extends Service<TourInfo> {
    List<Hotel> findHotels ();
}
