package com.apiRest.apiRest.security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String usuario;
    private String contrasena;
}
