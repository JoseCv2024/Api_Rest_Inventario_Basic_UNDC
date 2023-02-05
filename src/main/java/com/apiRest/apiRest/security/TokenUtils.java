package com.apiRest.apiRest.security;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenUtils {
    //LLAVE_SESCRET_JCV(base64) => TExBVkVfU0VTQ1JFVF9KQ1Y=
    private final static String ACCES_TOKEN_SECRET="TExBVkVfU0VTQ1JFVF9KQ1Y=";

    private final static long ACCES_TOKEN_VALIDITY_SECONDS = 1000 * 60 * 60 * (long) 2; // 8 horas

    public static String createToken(String nombre, String usuario, String apellido, Integer perfil){
        long expirationTime = ACCES_TOKEN_VALIDITY_SECONDS;
        //Date expirationDate = new Date(System.currentTimeMillis()+expirationTime);
        Map<String, Object> map = new HashMap<>();
        map.put("nombre", nombre);
        map.put("apellido", apellido);
        map.put("perfil", perfil);
        map.put("usuario", usuario);

        return Jwts.builder()
                   .setSubject(usuario)
                   .setIssuedAt(new Date(System.currentTimeMillis()))
                   .setExpiration(new Date(System.currentTimeMillis()+expirationTime))
                   .addClaims(map)
                   .signWith(SignatureAlgorithm.HS256, ACCES_TOKEN_SECRET.getBytes(Charset.forName("UTF-8")))// ?
                   .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
     try {

        Claims claims = Jwts.parser()
                            .setSigningKey(ACCES_TOKEN_SECRET.getBytes(Charset.forName("UTF-8")))
                            .parseClaimsJws(token)
                            .getBody();


        String usuario = claims.getSubject();

        return new UsernamePasswordAuthenticationToken(usuario, null, Collections.emptyList());

     } catch (JwtException e) {
        System.out.println("Error al obtener token "+ e);
        return null;
     }
    }

}
