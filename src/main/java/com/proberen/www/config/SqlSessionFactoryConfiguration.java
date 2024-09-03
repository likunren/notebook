package com.proberen.www.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class SqlSessionFactoryConfiguration {
    @Resource(name="dataSource")
    private DataSource dataSource;
    @Value("${mybatis.mapper-locations}")
    public String mapperlocations;
    @Bean(name="sessionFactoryBean")
    public SqlSessionFactoryBean createSqlSessionFactoryBean(){
          SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
          ssf.setDataSource(dataSource);
        return ssf;
    }
}
