package com.apiRest.apiRest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apiRest.apiRest.models.AlumnoDto;
import com.apiRest.apiRest.models.ResultClassEntity;
import com.apiRest.apiRest.models.UsuarioDto;

@Service
public interface UsuarioService {
    
    ResultClassEntity registrarUsuario(UsuarioDto obj) throws Exception;

    ResultClassEntity<List<UsuarioDto>> listarUsuarios() throws Exception;

    ResultClassEntity eliminarUsuario(UsuarioDto data) throws Exception;

    ResultClassEntity actualizarUsuario(UsuarioDto data) throws Exception;


    


}
