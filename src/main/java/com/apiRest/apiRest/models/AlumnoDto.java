package com.apiRest.apiRest.models;

import java.util.Date;
import lombok.Data;

@Data
public class AlumnoDto {
    private Integer idAlumno;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String dni;
    private String grado;
    private String seccion;
    private Integer idPadre;
    private Integer idMadre;
    private String telefono;
    private Date fechaNacimiento;
    private String direccion;
    private Integer idDistrito;
    private Integer idProvincia;
    private Integer idDepartamento;
    private Integer idApoderado;
}
