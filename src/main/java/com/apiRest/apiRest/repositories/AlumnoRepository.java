package com.apiRest.apiRest.repositories;


import java.util.List;

import com.apiRest.apiRest.models.AlumnoDto;
import com.apiRest.apiRest.models.ResultClassEntity;

public interface AlumnoRepository {
    ResultClassEntity<List<AlumnoDto>> obtenerAlumno() throws Exception;
}
