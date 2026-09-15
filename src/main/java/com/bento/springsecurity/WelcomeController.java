package com.bento.springsecurity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String welcome() {
        return "Welcome to the Spring Security Application!";
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String users() {
        return "Authorized User!";
    }

    @GetMapping("/managers")
    @PreAuthorize("hasRole('ADMIN')")
    public String managers() {
        return "Authorized Manager!";
    }
}