package com.use.demo.application.service.impl;

import com.use.demo.client.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String hello() {
        return "Hello, world";
    }
}
