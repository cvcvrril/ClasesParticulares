package org.example.seguridad;



import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.micrometer.common.lang.NonNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.example.domain.JwtService;
import org.example.ui.exceptions.TokenException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (header != null) {
            String[] values = header.split(" ");
            if (values[0].equalsIgnoreCase("Bearer") && values.length > 1) {
                try {
                    Claims claims = jwtService.extractAllClaims(values[1]);

                    String rol = (String) claims.get("rol");
                    String name = (String) claims.get("user");
                    UserDetails userDetails = User.builder()
                            .username(name)
                            .password("")
                            .roles(rol)
                            .build();

                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(
                                    userDetails,
                                    null,
                                    userDetails.getAuthorities()
                            );

                    SecurityContextHolder.getContext().setAuthentication(auth);
                    filterChain.doFilter(request, response);

                } catch (ExpiredJwtException e){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                } catch (Exception e) {
                    throw new TokenException(e.getMessage());
                }
            }

        }
        filterChain.doFilter(request, response);

    }
}
