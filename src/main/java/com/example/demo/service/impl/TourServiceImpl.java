package com.example.demo.service.impl;

import com.example.demo.entity.Tour;
import com.example.demo.repository.TourRepository;
import com.example.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TourServiceImpl implements TourService {
    private final TourRepository tourRepository;

    @Autowired
    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public Tour save(Tour entity) {
        return tourRepository.save(entity);
    }

    @Override
    public Optional<Tour> findById(Integer id) {
        return tourRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return tourRepository.existsById(id);
    }

    @Override
    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        tourRepository.deleteById(id);
    }
}
