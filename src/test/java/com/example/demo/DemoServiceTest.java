package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class DemoServiceTest {
    @Mock
    private DemoRepository demoRepository;

    private DemoService demoService;

    @Before
    public void setUp() {
        demoService = new DemoService(demoRepository);
    }

    @Test
    public void getHelloWorld() {
        when(demoRepository.findAll()).thenReturn(
                Arrays.asList(
                        new DemoEntity(1L, "name1"),
                        new DemoEntity(2L, "name2")));

        List<DemoEntity> helloWorld = demoService.getHelloWorld();

        assertThat(helloWorld)
                .extracting(DemoEntity::getId, DemoEntity::getName)
                .contains(
                        tuple(1L, "name1"),
                        tuple(2L, "name2"));
    }
}