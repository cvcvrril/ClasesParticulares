package org.example.domain;



import org.example.dao.repositories.UserRepository;
import org.example.domain.model.request.AuthenticationRequest;
import org.example.domain.model.response.AuthResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordHash;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordHash, AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordHash = passwordHash;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    public AuthResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        var user = userDetailsService.loadUserByUsername(request.username());

        /**
         * Desde aquí puedes modificar la duración de los tokens
         * **/

        var jwtToken = jwtService.generateToken(user.getUsername(), 2500).get();
        AuthResponse authResponse = new AuthResponse(jwtToken);
        return authResponse;
    }



}
