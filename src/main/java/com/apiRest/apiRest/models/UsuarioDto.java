package com.apiRest.apiRest.models;
import java.util.Date;
import lombok.Data;

@Data
public class UsuarioDto {
    public Integer idUsuario;
    public String nombreUsuario;
    public String apellido;
    public Integer perfil;

    public String usuario; //User name
    public String contrasena; // Password
    public Integer hashing = 13;
}
