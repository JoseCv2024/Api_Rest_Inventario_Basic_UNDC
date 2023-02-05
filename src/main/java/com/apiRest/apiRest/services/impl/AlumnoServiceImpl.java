package com.apiRest.apiRest.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiRest.apiRest.models.AlumnoDto;
import com.apiRest.apiRest.models.ResultClassEntity;
import com.apiRest.apiRest.repositories.AlumnoRepository;
import com.apiRest.apiRest.services.AlumnoService;

@Service("AlumnoService")
public class AlumnoServiceImpl implements AlumnoService{
    public AlumnoServiceImpl() {
    }

    @Autowired
    AlumnoRepository alumnoRepository;
   
    public ResultClassEntity<List<AlumnoDto>> obtenerAlumno() throws Exception{
       return  alumnoRepository.obtenerAlumno();
    }

}
