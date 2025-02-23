package org.example.domain;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import io.vavr.control.Either;

import org.example.dao.repositories.UserRepository;
import org.example.domain.model.Usuario;
import org.example.domain.model.error.ErrorObject;
import org.example.utils.RandomBytesGenerator;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {
    private final UserRepository repository;
    //private final UserRepository repository;
    private final RandomBytesGenerator generator;

    public JwtService(UserRepository repository, RandomBytesGenerator generator) {
        this.repository = repository;
        this.generator = generator;
    }

    private Key clavePrivadaKeyStore() {
        String passwordString = "admin";
        char[] password = passwordString.toCharArray();
        try (FileInputStream fis = new FileInputStream("keystore.pfx")) {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(fis, password);
            return keyStore.getKey("server", password);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Claims extractAllClaims(String token) throws CertificateException, KeyStoreException, IOException, NoSuchAlgorithmException {
        return Jwts
                .parserBuilder()
                .setSigningKey(clavePrivadaKeyStore())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Either<ErrorObject, String> generateToken(String username, int duration) {
        Either<ErrorObject, String> res;
        try {
            Usuario user = repository.getUsuarioByUsername(username);
            String token = Jwts.builder()
                    .setSubject(user.getUsername())
                    .setExpiration(Date.from(LocalDateTime.now().plusSeconds(duration).atZone(ZoneId.systemDefault()).toInstant()))
                    .claim("user", user.getUsername())
                    .claim("rol", user.getRol())
                    //.signWith(SignatureAlgorithm.valueOf(""), "pepe")
                    .signWith(clavePrivadaKeyStore())
                    .compact();
            res = Either.right(token);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        return res;
    }

}
