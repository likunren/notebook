package com.proberen.www;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.proberen.www.dao")
public class Starter extends SpringBootServletInitializer {
    private static Logger logger= LoggerFactory.getLogger(Starter.class);
    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(Starter.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        logger.info("start noetBoot");
        springApplication.run();
    }
}
