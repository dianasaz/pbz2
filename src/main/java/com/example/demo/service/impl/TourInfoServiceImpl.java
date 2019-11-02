package com.example.demo.service.impl;

import com.example.demo.entity.TourInfo;
import com.example.demo.repository.TourInfoRepository;
import com.example.demo.service.TourInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TourInfoServiceImpl implements TourInfoService {
    private final TourInfoRepository tourInfoRepository;

    @Autowired
    public TourInfoServiceImpl(TourInfoRepository tourInfoRepository) {
        this.tourInfoRepository = tourInfoRepository;
    }

    @Override
    public TourInfo save(TourInfo entity) {
        return tourInfoRepository.save(entity);
    }

    @Override
    public Optional<TourInfo> findById(Integer id) {
        return tourInfoRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return tourInfoRepository.existsById(id);
    }

    @Override
    public List<TourInfo> findAll() {
        return tourInfoRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        tourInfoRepository.deleteById(id);
    }
}
