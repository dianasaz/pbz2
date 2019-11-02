package com.example.demo.service;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Locality;

import java.util.List;

public interface HotelService extends Service<Hotel> {
    List<Hotel> findAllByStarsAndLocality(Integer stars, Locality locality);
}
