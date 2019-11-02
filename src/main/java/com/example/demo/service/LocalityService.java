package com.example.demo.service;

import com.example.demo.entity.Locality;

public interface LocalityService extends Service<Locality> {
    Locality findLocalityByName(String name);
}
