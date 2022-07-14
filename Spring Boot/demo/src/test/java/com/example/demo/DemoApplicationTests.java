package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        String name1 = "Ahmed";
        String name2 = "Ahmed";
        Assert.isTrue(name1 == name2,"equal ");
    }

}
