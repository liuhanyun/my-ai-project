package com.use.demo.application.service;

import com.use.demo.application.service.impl.DemoServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoServiceImplTest {
    @Test
    void helloReturnsMessage() {
        DemoServiceImpl service = new DemoServiceImpl();

        String result = service.hello();

        assertEquals("Hello, world", result);
    }
}
