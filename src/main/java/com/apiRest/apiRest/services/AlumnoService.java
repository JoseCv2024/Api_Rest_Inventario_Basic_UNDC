package com.apiRest.apiRest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apiRest.apiRest.models.AlumnoDto;
import com.apiRest.apiRest.models.ResultClassEntity;

@Service
public interface AlumnoService {
    
    ResultClassEntity<List<AlumnoDto>> obtenerAlumno() throws Exception;
    

   /*  public AlumnoDto guardarAlumno(AlumnoDto param){
        return alumnoRepository.save(param);
    } */


}
