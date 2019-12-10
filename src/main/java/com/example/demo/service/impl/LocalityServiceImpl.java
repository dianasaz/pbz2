package com.example.demo.service.impl;

import com.example.demo.entity.Locality;
import com.example.demo.repository.LocalityRepository;
import com.example.demo.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalityServiceImpl implements LocalityService {
    private final LocalityRepository localityRepository;

    @Autowired
    public LocalityServiceImpl(LocalityRepository localityRepository) {
        this.localityRepository = localityRepository;
    }

    @Override
    public Locality save(Locality entity) {
        return localityRepository.save(entity);
    }

    @Override
    public Optional<Locality> findById(Integer id) {
        return localityRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return localityRepository.existsById(id);
    }

    @Override
    public List<Locality> findAll() {
        return localityRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        localityRepository.deleteById(id);
    }
}
