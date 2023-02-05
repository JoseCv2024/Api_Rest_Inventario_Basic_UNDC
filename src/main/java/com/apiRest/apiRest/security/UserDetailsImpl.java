package com.apiRest.apiRest.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.apiRest.apiRest.models.UsuarioDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{

    private final UsuarioDto usuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return usuario.getContrasena();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return usuario.getUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    public String getNombre(){
        return usuario.getNombreUsuario();
    }
    
    public String getApellido(){
        return usuario.getApellido();
    }

    public Integer getPerfil(){
        return usuario.getPerfil();
    }
    
}
