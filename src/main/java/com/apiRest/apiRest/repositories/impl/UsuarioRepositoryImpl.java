package com.apiRest.apiRest.repositories.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.net.openssl.ciphers.Encryption;
import org.hibernate.query.NativeQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.apiRest.apiRest.models.AlumnoDto;
import com.apiRest.apiRest.models.ResultClassEntity;
import com.apiRest.apiRest.models.UsuarioDto;
import com.apiRest.apiRest.repositories.UsuarioRepository;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository{
    public UsuarioRepositoryImpl() {
    }

    @PersistenceContext
    private EntityManager manager;
    private static final Logger log = LogManager.getLogger(AlumnoDto.class);
    StoredProcedureQuery as;

    @Override
    public ResultClassEntity registrarUsuario(UsuarioDto obj) throws Exception{
        ResultClassEntity result = new ResultClassEntity();

        try {

            // Crear Query que controle 'usuario ya creado'
            String sql = "SELECT * FROM t_usuario where usuario = '"+obj.getUsuario().toString()+"'";
            String sql2 = "SELECT * FROM t_usuario";
            Query query =  manager.createNativeQuery(sql);
            Query query2 =  manager.createNativeQuery(sql2);

            List<Object[]> exist = query.getResultList();
            List<Object[]> exist2 = query2.getResultList();

            if (exist.size()>=1){
                result.setSuccess(false);
                result.setMessage("El usuario "+obj.getUsuario().toString()+" ya existe.");
            }else if(exist2.size()>=10){
                result.setSuccess(false);
                result.setMessage("Ya se alcanzó el límite de usuarios registrados.");
            }else{
                StoredProcedureQuery processStored = manager.createStoredProcedureQuery("`inventario_basico_1`.`sp_usuario_crear`");
                processStored.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("apellido", String.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("usuario", String.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("perfil", Integer.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("contrasena", String.class, ParameterMode.IN);
                manager.close();
                processStored.setParameter("nombre", obj.getNombreUsuario());
                processStored.setParameter("apellido", obj.getApellido());
                processStored.setParameter("usuario", obj.getUsuario());
                processStored.setParameter("perfil", obj.getPerfil());
                processStored.setParameter("contrasena", new BCryptPasswordEncoder().encode(obj.getContrasena()));      
                processStored.execute();

                List<Object[]> spResult = processStored.getResultList();
                if (spResult.size() >= 1){
                    for (Object[] row_: spResult){
                        obj.setIdUsuario(row_[0]==null?null:(Integer) row_[0]);
                        obj.setNombreUsuario(row_[1]==null?null:(String) row_[1]);
                        obj.setApellido(row_[2]==null?null:(String) row_[2]);
                        obj.setUsuario(row_[3]==null?null:(String) row_[3]);
                        obj.setPerfil(row_[4]==null?null:(Integer) row_[4]);
                        //obj.setContrasena(row_[5]==null?null:(String) row_[5]);
                        result.setTotalRecord(1);
                        break;
                    }
                }
                result.setSuccess(true);
                result.setMessage("Se registró el usuario correctamente.");
            }

            obj.setHashing(null);
            obj.setContrasena(null);
            result.setData(obj);
            return  result;
            
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setSuccess(false);
            result.setMessage("Ocurrió un error.");
            return  result;
        }
    }

    public Optional<UsuarioDto> findOneUsuario(String usuario){

        UsuarioDto user = usuarioReturn(usuario);
        Optional<UsuarioDto> opt = Optional.ofNullable(user);

        if (user.getUsuario().equals(usuario)) return opt;
        else  return null;
    };

    private UsuarioDto usuarioReturn(String usuario){
        UsuarioDto obj = new UsuarioDto();
        String sql = "SELECT * FROM t_usuario where usuario = '"+usuario+"'";
            Query query =  manager.createNativeQuery(sql);

            List<Object[]> exist = query.getResultList();
            if (exist.size() >= 1){
                for (Object[] row_: exist){
                    obj.setIdUsuario(row_[0]==null?null:(Integer) row_[0]);
                    obj.setNombreUsuario(row_[1]==null?null:(String) row_[1]);
                    obj.setApellido(row_[2]==null?null:(String) row_[2]);
                    obj.setUsuario(row_[3]==null?null:(String) row_[3]);
                    obj.setPerfil(row_[4]==null?null:(Integer) row_[4]);
                    obj.setContrasena(row_[5]==null?null:(String) row_[5]);
                    break;
                }
            }

            return obj;

    }

    /* CRUDE */

    @Override
    public ResultClassEntity<List<UsuarioDto>> listarUsuarios() throws Exception {
        ResultClassEntity<List<UsuarioDto>> result = new ResultClassEntity<List<UsuarioDto>>();
        Integer totalRecord = 0;

        
         try {
            List<UsuarioDto> lista = new ArrayList<>();
            StoredProcedureQuery processStored = manager.createStoredProcedureQuery("`inventario_basico_1`.`sp_usuario_listar`");
            manager.close();
            
            processStored.execute();
            List<Object[]> spResult = processStored.getResultList();
            if (spResult.size() >= 1){
                UsuarioDto obj_ = null;
                for (Object[] row_: spResult){
                    obj_ = new UsuarioDto();
                    obj_.setIdUsuario(row_[0]==null?null:(Integer) row_[0]);
                    obj_.setNombreUsuario(row_[1]==null?null:(String) row_[1]);
                    obj_.setApellido(row_[2]==null?null:(String) row_[2]);
                    obj_.setUsuario(row_[3]==null?null:(String) row_[3]);
                    obj_.setPerfil(row_[4]==null?null:(Integer) row_[4]);
                    obj_.setContrasena(row_[5]==null?null:(String) row_[5]);
                    obj_.setHashing(null);
                    lista.add(obj_);
                    totalRecord++;
                }
            }

            result.setData(lista);
            result.setSuccess(true);
            result.setTotalRecord(totalRecord);
            result.setMessage("Se listó correctamente.");
            return result;
        } catch (Exception e) {
            log.error("listar Usuarios - " + e.getMessage(), e);
            result.setSuccess(false);
            result.setTotalRecord(totalRecord);
            result.setMessage("Ocurrió un error." + e.getMessage());
            return result;
        }
    }

    @Override
    public ResultClassEntity eliminarUsuario(UsuarioDto obj) throws Exception {
        ResultClassEntity result = new ResultClassEntity();

        try {
            
            StoredProcedureQuery processStored = manager.createStoredProcedureQuery("`inventario_basico_1`.`sp_usuario_eliminar`");
            processStored.registerStoredProcedureParameter("idUsuario", Integer.class, ParameterMode.IN);
            manager.close();
            processStored.setParameter("idUsuario", obj.getIdUsuario());    
            processStored.execute();

            result.setSuccess(true);
            result.setMessage("Se eliminó correctamente.");

            result.setData(obj);
            return  result;

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setSuccess(false);
            result.setMessage("Ocurrió un error.");
            return  result;
        }
    }

    @Override
    public ResultClassEntity actualizarUsuario(UsuarioDto obj) throws Exception {
        ResultClassEntity result = new ResultClassEntity();

        try {
            
            String sql = "SELECT * FROM t_usuario where idUsuario = '"+obj.getIdUsuario()+"'";
            Query query =  manager.createNativeQuery(sql);

            List<Object[]> exist = query.getResultList();

            if (exist.size()<1){
                result.setSuccess(false);
                result.setMessage("El Usuario "+obj.getNombreUsuario().toString()+" ya no existe.");
            }else{
                StoredProcedureQuery processStored; 
                if(obj.getContrasena().equals("NO_VALIDATE")) processStored = manager.createStoredProcedureQuery("`inventario_basico_1`.`sp_usuario_actualizar_sin_password`");
                else processStored = manager.createStoredProcedureQuery("`inventario_basico_1`.`sp_usuario_actualizar`");

                processStored.registerStoredProcedureParameter("idUsuario", Integer.class, ParameterMode.IN); 
                processStored.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("apellido", String.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("usuario", String.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("perfil", Integer.class, ParameterMode.IN);
                if(!obj.getContrasena().equals("NO_VALIDATE")) processStored.registerStoredProcedureParameter("contrasena", String.class, ParameterMode.IN);
                manager.close();
                processStored.setParameter("idUsuario", obj.getIdUsuario());
                processStored.setParameter("nombre", obj.getNombreUsuario());
                processStored.setParameter("apellido", obj.getApellido());
                processStored.setParameter("usuario", obj.getUsuario());
                processStored.setParameter("perfil", obj.getPerfil());
                if(!obj.getContrasena().equals("NO_VALIDATE")) processStored.setParameter("contrasena", new BCryptPasswordEncoder().encode(obj.getContrasena()));     
                processStored.execute();

                result.setSuccess(true);
                result.setMessage("Se actualizó correctamente.");
            }

            result.setData(obj);
            return  result;

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setSuccess(false);
            result.setMessage("Ocurrió un error.");
            return  result;
        }
    }

}
