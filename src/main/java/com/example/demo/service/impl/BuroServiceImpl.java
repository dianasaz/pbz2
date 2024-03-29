package com.example.demo.service.impl;

import com.example.demo.entity.Buro;
import com.example.demo.repository.BuroRepository;
import com.example.demo.service.BuroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuroServiceImpl implements BuroService {
    private final BuroRepository buroRepository;

    @Autowired
    public BuroServiceImpl(BuroRepository buroRepository) {
        this.buroRepository = buroRepository;
    }

    @Override
    public Buro save(Buro entity) {
        return buroRepository.save(entity);
    }

    @Override
    public Optional<Buro> findById(Integer id) {
        return buroRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return buroRepository.existsById(id);
    }

    @Override
    public List<Buro> findAll() {
        return buroRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        buroRepository.deleteById(id);
    }
}
