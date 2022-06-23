package com.demo;


//import com.demo.security.entity.AuthUser;
//import com.demo.security.repository.AuthUserRepository;
import com.demo.security.entity.AuthUser;
import com.demo.security.repository.AuthUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootApplication
public class DemoApplication {

    private final AuthUserRepository repository;

    public DemoApplication(AuthUserRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void initUsers() {
        List<AuthUser> users = Stream.of(
                new AuthUser(101, "admin", "admin", "kkarelinn@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }



}
