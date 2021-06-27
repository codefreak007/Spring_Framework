package com.example.usermain;

import com.example.usermain.repository.User;
import com.example.usermain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class UserServiceApplication {

    @Autowired
    private UserRepository repo;

    @PostConstruct
    public void initializeUsers(){
        List<User> users= Stream.of(new User(001L,"user1","pwd1","user1@gmail.com","india"),
                new User(002L,"user2","pwd2","user2@gmail.com","japan"),
                new User(003L,"user3","pwd3","user3@gmail.com","sudan"),
                new User(004L,"user4","pwd4","user4@gmail.com","italy")).collect(Collectors.toList());
        repo.saveAll(users);
    }
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }


}
