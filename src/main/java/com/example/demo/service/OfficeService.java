package com.example.demo.service;

import com.example.demo.entity.Buro;
import com.example.demo.entity.Office;

import java.util.List;

public interface OfficeService extends Service<Office> {
    List<Office> findByBuro(Buro buro);
}
