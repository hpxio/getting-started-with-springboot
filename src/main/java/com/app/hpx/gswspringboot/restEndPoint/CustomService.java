package com.app.hpx.gswspringboot.restEndPoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomService {
    @Autowired
    CustomRepository repository;
}