package com.use.demo.adapter.web;

import com.use.demo.adapter.dto.HelloDTO;
import com.use.demo.client.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final DemoService demoService;

    public HelloController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/hello")
    public HelloDTO hello() {
        HelloDTO dto = new HelloDTO();
        dto.setMessage(demoService.hello());
        return dto;
    }
}
