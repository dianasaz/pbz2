package com.example.demo.service.impl;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Locality;
import com.example.demo.repository.HotelRepository;
import com.example.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }


    @Override
    public List<Hotel> findAllByStarsAndLocality(Integer stars, Locality locality) {
        return hotelRepository.findAllByStarsAndLocality(stars, locality.getId());
    }

    @Override
    public List<Hotel> findByLocality(Locality locality){
        return hotelRepository.findByLocality(locality);
    }

    @Override
    public Hotel save(Hotel entity) {
        return hotelRepository.save(entity);
    }

    @Override
    public Optional<Hotel> findById(Integer id) {
        return hotelRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return hotelRepository.existsById(id);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        hotelRepository.deleteById(id);
    }
}
