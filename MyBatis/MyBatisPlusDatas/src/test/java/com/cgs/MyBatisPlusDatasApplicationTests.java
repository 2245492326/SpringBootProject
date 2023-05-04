package com.cgs;

import com.cgs.service.ProductService;
import com.cgs.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyBatisPlusDatasApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Test
    void contextLoads() {
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
    }




}
