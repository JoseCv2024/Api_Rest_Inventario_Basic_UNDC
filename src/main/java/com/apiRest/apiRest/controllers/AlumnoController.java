package com.apiRest.apiRest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiRest.apiRest.models.AlumnoDto;
import com.apiRest.apiRest.models.ResultClassEntity;
import com.apiRest.apiRest.services.AlumnoService;
import com.apiRest.apiRest.repositories.util.Constantes;
import com.apiRest.apiRest.repositories.util.Urls;

@RestController
@RequestMapping(Urls.alumno.BASE)
public class AlumnoController extends AbstractRestController{
    private static final Logger log = LogManager.getLogger(AlumnoDto.class);

    @Autowired
    AlumnoService alumnoService;
   
    @GetMapping(path = "/listarAlumnos")
    public ResponseEntity obtenerAlumno() throws Exception{
        ResponseEntity result = null;
        ResultClassEntity<List<AlumnoDto>> response = new ResultClassEntity<List<AlumnoDto>>();

        try {
            response =  alumnoService.obtenerAlumno();
            log.info("Alumno - Listar alumnos", "Proceso realizado correctamente");

            /* Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            log.info("Datos del Usuario: {}", auth.getPrincipal());
            log.info("Datos de los permisos: {}", auth.getAuthorities());
            log.info("Esta autenticado {}", auth.isAuthenticated()); */


            if (!response.getSuccess()) {
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Alumno - Listar alumnos", "Ocurrió un error : " + e.getMessage());
            response = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);

            return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    /* @PostMapping()
    public AlumnoDto guardarAlumno(@RequestBody AlumnoDto param){
        return this.alumnoService.guardarAlumno(param);
    } */
}
