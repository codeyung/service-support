package com.cy.service.support;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @Description:
 * @Author: YongJingChuan
 * @Date: 2020/8/20 14:20
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:spring/spring-*.xml"})
//@ComponentScan(value = {"com.xx.xx.xx"})
public class SupportApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupportApplication.class, args);
    }

}
