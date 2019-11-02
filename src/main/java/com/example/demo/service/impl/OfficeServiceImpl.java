package com.example.demo.service.impl;

import com.example.demo.entity.Office;
import com.example.demo.repository.OfficeRepository;
import com.example.demo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OfficeServiceImpl implements OfficeService {
    private final OfficeRepository officeRepository;

    @Autowired
    public OfficeServiceImpl(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public Office save(Office entity) {
        return officeRepository.save(entity);
    }

    @Override
    public Optional<Office> findById(Integer id) {
        return officeRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return officeRepository.existsById(id);
    }

    @Override
    public List<Office> findAll() {
        return officeRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        officeRepository.deleteById(id);
    }
}
