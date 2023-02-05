package com.apiRest.apiRest.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiRest.apiRest.models.AlumnoDto;
import com.apiRest.apiRest.models.ResultClassEntity;
import com.apiRest.apiRest.models.UsuarioDto;
import com.apiRest.apiRest.repositories.util.Constantes;
import com.apiRest.apiRest.repositories.util.Urls;
import com.apiRest.apiRest.services.UsuarioService;

@RestController
@RequestMapping(Urls.usuario.BASE)
public class UsuarioController extends AbstractRestController{
    private static final Logger log = LogManager.getLogger(AlumnoDto.class);

    @Autowired
    UsuarioService usuarioService;


    @PostMapping(path = "/registrarUsuario")
    //@ApiOperation(value = "Registrar Usuario" , authorizations = {@Authorization(value="JWT")})
    //@ApiResponses({ @ApiResponse(code = 200, message = "Resuelto correctamente"), @ApiResponse(code = 404, message = "No encontrado") })
    public ResponseEntity registrarEvaluacion(@RequestBody UsuarioDto data){
        log.info("Usuario - registrar Usuario",data.toString());

        ResponseEntity result = null;
        ResultClassEntity response = new ResultClassEntity();
        try {
            response =  usuarioService.registrarUsuario(data);
            log.info("Usuario - crear usuario", "Proceso realizado correctamente.");
            if (!response.getSuccess()) {
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Usuario - crear usuario", "Ocurrió un error : " + e.getMessage());
            response = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);

            return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/listarUsuarios")
    public ResponseEntity listaProducto() throws Exception{
        ResponseEntity result = null;
        ResultClassEntity<List<UsuarioDto>> response = new ResultClassEntity<>();

        try {
            response =  usuarioService.listarUsuarios();
            log.info("Usuario - Listar Usuario", "Proceso realizado correctamente");
            if (!response.getSuccess()) {
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Usuario - Listar Usuario", "Ocurrió un error : " + e.getMessage());
            //response = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
            return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/eliminarUsuario")
    public ResponseEntity eliminarUsuario(@RequestBody UsuarioDto data){
        log.info("Usuario - eliminar Usuario",data.toString());

        ResponseEntity result = null;
        ResultClassEntity response = new ResultClassEntity();
        try {
            response =  usuarioService.eliminarUsuario(data);

            log.info("Usuario - eliminar Usuario", "Proceso realizado correctamente");
            if (response.getSuccess()==null || !response.getSuccess()) {
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST); 
            } else {
                return new ResponseEntity(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Usuario - eliminar Usuario", "Ocurrió un error : " + e.getMessage());
            return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/actualizarUsuario")
    public ResponseEntity actualizarUsuario(@RequestBody UsuarioDto data){
        log.info("Usuario - actualizar Usuario",data.toString());

        ResponseEntity result = null;
        ResultClassEntity response = new ResultClassEntity();
        try {
            response =  usuarioService.actualizarUsuario(data);

            log.info("Usuario - actualizar Usuario", "Proceso realizado correctamente");
            if (response.getSuccess()==null || !response.getSuccess()) {
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST); 
            } else {
                return new ResponseEntity(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Usuario - actualizar Usuario", "Ocurrió un error : " + e.getMessage());
            return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
}
