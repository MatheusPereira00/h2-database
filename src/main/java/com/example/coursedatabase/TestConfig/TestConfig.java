package com.example.coursedatabase.TestConfig;

import com.example.coursedatabase.domain.model.User;
import com.example.coursedatabase.infra.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria", "maria@email.com", "11961568913", "12345");
        User u2 = new User(null, "Luiza", "luiza@email.com", "11961568913", "12345");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
