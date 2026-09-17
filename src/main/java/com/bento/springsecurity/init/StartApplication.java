package com.bento.springsecurity.init;

import com.bento.springsecurity.model.User;
import com.bento.springsecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;

public class StartApplication implements CommandLineRunner {

    private UserRepository repository;

    public void run(String... args) throws Exception {
        User user = repository.findByUsername("admin");
        if(user == null){
            user = new User();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword("password");
            user.getRoles().add("MANAGERS");
            repository.save(user);
        }
        user = repository.findByUsername("user");
        if(user == null){
            user = new User();
            user.setName("USER");
            user.setUsername("user");
            user.setPassword("password");
            user.getRoles().add("USERS");
            repository.save(user);
        }
    }
}
