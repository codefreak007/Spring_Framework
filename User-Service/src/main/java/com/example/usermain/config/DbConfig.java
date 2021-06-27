package com.example.usermain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    @ConfigurationProperties(prefix="spring.datasource")
    @Bean @Primary
    public DataSource getDataSource(){
        return DataSourceBuilder.create().url("jdbc:mysql://localhost:3306/user").username("root")
                .password("Admin@123").build();

    }


}
