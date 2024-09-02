package com.proberen.www;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.proberen.www.dao")
public class C3p0DBConfig {
    @Bean(name="dataSource")
    @ConfigurationProperties(prefix="spring.datasorucde.c3p0")
    public DataSource dataSource(){
       // ComboPooledDataSource dataSource=new ComboPooledDataSource();
        return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
    }
}
