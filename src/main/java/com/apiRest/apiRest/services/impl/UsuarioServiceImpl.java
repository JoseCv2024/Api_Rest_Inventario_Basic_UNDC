package com.apiRest.apiRest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiRest.apiRest.models.ResultClassEntity;
import com.apiRest.apiRest.models.UsuarioDto;
import com.apiRest.apiRest.repositories.UsuarioRepository;
import com.apiRest.apiRest.services.UsuarioService;

@Service("UsuarioService")
public class UsuarioServiceImpl implements UsuarioService{
    public UsuarioServiceImpl() {
    }

    @Autowired
    UsuarioRepository usuarioRepository;
   
    public ResultClassEntity registrarUsuario(UsuarioDto obj) throws Exception{
       return  usuarioRepository.registrarUsuario(obj);
    }

    @Override
    public ResultClassEntity<List<UsuarioDto>> listarUsuarios() throws Exception {
        return  usuarioRepository.listarUsuarios(); 
    }

    @Override
    public ResultClassEntity eliminarUsuario(UsuarioDto data) throws Exception {
        return usuarioRepository.eliminarUsuario(data);
    }

    @Override
    public ResultClassEntity actualizarUsuario(UsuarioDto data) throws Exception {
        return usuarioRepository.actualizarUsuario(data);
    }

}
