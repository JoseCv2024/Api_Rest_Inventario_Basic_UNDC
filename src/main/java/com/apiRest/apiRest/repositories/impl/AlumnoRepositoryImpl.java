package com.apiRest.apiRest.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.apiRest.apiRest.models.AlumnoDto;
import com.apiRest.apiRest.models.ResultClassEntity;
import com.apiRest.apiRest.repositories.AlumnoRepository;

@Repository
public class AlumnoRepositoryImpl implements AlumnoRepository{
    public AlumnoRepositoryImpl() {
    }

    @PersistenceContext
    private EntityManager manager;
    private static final Logger log = LogManager.getLogger(AlumnoDto.class);
    //@Query(value = "call sp_lista_alumnos_or_id(null);")
    StoredProcedureQuery as;

    @Override
    public ResultClassEntity<List<AlumnoDto>> obtenerAlumno() throws Exception {
        ResultClassEntity<List<AlumnoDto>> result = new ResultClassEntity<List<AlumnoDto>>();
        Integer totalRecord = 0;

        
         try {
            List<AlumnoDto> lista = new ArrayList<>();
            StoredProcedureQuery processStored = manager.createStoredProcedureQuery("`db_ie`.`sp_listar_alumnos`");
            manager.close();
            
            processStored.execute();
            List<Object[]> spResult = processStored.getResultList();
            if (spResult.size() >= 1){
                AlumnoDto obj_ = null;
                for (Object[] row_: spResult){
                    obj_ = new AlumnoDto();
                    obj_.setIdAlumno(row_[0]==null?null:(Integer) row_[0]);
                    obj_.setNombre(row_[1]==null?null:(String) row_[1]);
                    obj_.setApellidoPaterno(row_[2]==null?null:(String) row_[2]);
                    obj_.setApellidoMaterno(row_[3]==null?null:(String) row_[3]);
                    obj_.setDni(row_[4]==null?null:(String) row_[4]);
                    obj_.setGrado(row_[5]==null?null:(String) row_[5].toString());
                    obj_.setSeccion(row_[6]==null?null:(String) row_[6].toString());
                    obj_.setIdPadre(row_[7]==null?null:(Integer) row_[7]);
                    obj_.setIdMadre(row_[8]==null?null:(Integer) row_[8]);
                    obj_.setTelefono(row_[9]==null?null:(String) row_[9]);
                    obj_.setDireccion(row_[10]==null?null:(String) row_[10]);
                    obj_.setIdDistrito(row_[11]==null?null:(Integer) row_[11]);
                    obj_.setIdProvincia(row_[12]==null?null:(Integer) row_[12]);
                    obj_.setIdDepartamento(row_[13]==null?null:(Integer) row_[13]);
                    obj_.setIdApoderado(row_[14]==null?null:(Integer) row_[14]);
                    lista.add(obj_);
                    totalRecord++;
                }
            }

            result.setData(lista);
            result.setSuccess(true);
            result.setTotalRecord(totalRecord);
            result.setMessage("Se listó alumnos correctamente.");
            return result;
        } catch (Exception e) {
            log.error("listar Alumno - " + e.getMessage(), e);
            result.setSuccess(false);
            result.setTotalRecord(totalRecord);
            result.setMessage("Ocurrió un error." + e.getMessage());
            return result;
        }
    }

}
