package org.example.ui;


import org.example.domain.AuthService;
import org.example.domain.model.request.AuthenticationRequest;
import org.example.domain.model.response.AuthResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RestAuth {

    private final AuthService service;

    public RestAuth(AuthService service){
        this.service = service;
    }

    @GetMapping("/login")
    public AuthResponse loginAuth(@RequestParam("username") String username, @RequestParam("password") String password){
        AuthenticationRequest requestAuth = new AuthenticationRequest(username, password);
        return service.authenticate(requestAuth);
    }


}
