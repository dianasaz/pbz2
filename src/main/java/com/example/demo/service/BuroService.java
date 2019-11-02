package com.example.demo.service;

import com.example.demo.entity.Buro;

public interface BuroService extends Service<Buro> {
    Buro findBuroByName (String name);
}
