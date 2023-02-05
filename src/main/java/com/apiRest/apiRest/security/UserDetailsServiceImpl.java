package com.apiRest.apiRest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apiRest.apiRest.models.UsuarioDto;
import com.apiRest.apiRest.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        //Se valida si el usuario existe
        UsuarioDto usuario = usuarioRepository.findOneUsuario(username)
                         .orElseThrow(()-> new UsernameNotFoundException("El Usuario "+username+"No existe"));

        return new UserDetailsImpl(usuario);
    }
    
}
