package com.example.demo.service.impl;

import com.example.demo.entity.Office;
import com.example.demo.entity.PriceList;
import com.example.demo.repository.PriceListRepository;
import com.example.demo.service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PriceListServiceImpl implements PriceListService {
    private final PriceListRepository priceListRepository;

    @Autowired
    public PriceListServiceImpl(PriceListRepository priceListRepository) {
        this.priceListRepository = priceListRepository;
    }

    @Override
    public PriceList save(PriceList entity) {
        return priceListRepository.save(entity);
    }

    @Override
    public Optional<PriceList> findById(Integer id) {
        return priceListRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return priceListRepository.existsById(id);
    }

    @Override
    public List<PriceList> findAll() {
        return priceListRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        priceListRepository.deleteById(id);
    }

    @Override
    public Optional<PriceList>  findLastByOfficeAndDate(Integer o, Date date) {
        return priceListRepository.findLastByOfficeAndDate(o, date);
    }
}
