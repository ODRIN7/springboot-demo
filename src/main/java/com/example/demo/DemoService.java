package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {
    private final DemoRepository demoRepository;

    public DemoService(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    public List<DemoEntity> getHelloWorld() {
        List<DemoEntity> demoEntities = new ArrayList<>();
        demoRepository.findAll().forEach(demoEntities::add);
        return demoEntities;
    }

    public void createDemoEntity(DemoEntity demoEntity) {
        demoRepository.save(demoEntity);
    }
}
