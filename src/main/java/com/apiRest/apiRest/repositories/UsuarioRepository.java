package com.apiRest.apiRest.repositories;


import java.util.List;
import java.util.Optional;

import com.apiRest.apiRest.models.ResultClassEntity;
import com.apiRest.apiRest.models.UsuarioDto;

public interface UsuarioRepository {
    ResultClassEntity registrarUsuario(UsuarioDto obj) throws Exception;
    Optional<UsuarioDto> findOneUsuario(String usuario);
    ResultClassEntity<List<UsuarioDto>> listarUsuarios() throws Exception;
    ResultClassEntity eliminarUsuario(UsuarioDto obj) throws Exception;
    ResultClassEntity actualizarUsuario(UsuarioDto data) throws Exception;
}
