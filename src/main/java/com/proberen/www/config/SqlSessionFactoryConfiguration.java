package com.proberen.www.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class SqlSessionFactoryConfiguration {
    @Resource(name="dataSource")
    private DataSource dataSource;
    @ConfigurationProperties(prefix = "mybatis")
    @Bean
    public SqlSessionFactoryBean createSqlSessionFactoryBean(){
          SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
          ssf.setDataSource(dataSource);
        return ssf;
    }
}
