package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoRestService {
    private final DemoService demoService;

    public DemoRestService(DemoService demoService) {
        this.demoService = demoService;
        demoService.createDemoEntity(new DemoEntity(1L,"name1"));
        demoService.createDemoEntity(new DemoEntity(2L,"name2"));
        demoService.createDemoEntity(new DemoEntity(3L,"name3"));
    }

    @RequestMapping("/")
    public List<DemoEntity> getHelloWorld() {
        return demoService.getHelloWorld();
    }
}
