package com.proberen.www.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class C3p0DBConfig {
    @ConfigurationProperties(prefix="spring.datasource")
    @Bean
    public DataSource dataSource(){
        //return  new ComboPooledDataSource();
        return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();

    }
}
