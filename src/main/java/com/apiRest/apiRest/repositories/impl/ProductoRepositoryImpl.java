package com.apiRest.apiRest.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.apiRest.apiRest.models.AlumnoDto;
import com.apiRest.apiRest.models.CategoriaDto;
import com.apiRest.apiRest.models.ProductoDto;
import com.apiRest.apiRest.models.ResultClassEntity;
import com.apiRest.apiRest.repositories.ProductoRepository;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository{
    public ProductoRepositoryImpl() {
    }

    @PersistenceContext
    private EntityManager manager;
    private static final Logger log = LogManager.getLogger(AlumnoDto.class);
    //@Query(value = "call sp_lista_alumnos_or_id(null);")
    StoredProcedureQuery as;

    @Override
    public ResultClassEntity eliminarProducto(ProductoDto obj) throws Exception {
        ResultClassEntity result = new ResultClassEntity();

        try {
            
            StoredProcedureQuery processStored = manager.createStoredProcedureQuery("`inventario_basico_1`.`sp_producto_eliminar`");
            processStored.registerStoredProcedureParameter("idProducto", Integer.class, ParameterMode.IN);
            manager.close();
            processStored.setParameter("idProducto", obj.getIdProducto());    
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
    public ResultClassEntity actualizarProducto(ProductoDto obj) throws Exception {
        ResultClassEntity result = new ResultClassEntity();

        try {
            
            String sql = "SELECT * FROM t_producto where idProducto = '"+obj.getIdProducto()+"'";
            Query query =  manager.createNativeQuery(sql);

            List<Object[]> exist = query.getResultList();

            if (exist.size()<1){
                result.setSuccess(false);
                result.setMessage("El producto "+obj.getNombre().toString()+" ya no existe.");
            }else{
                StoredProcedureQuery processStored = manager.createStoredProcedureQuery("`inventario_basico_1`.`sp_producto_actualizar`");
                processStored.registerStoredProcedureParameter("idProducto", Integer.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("FkcategoriaId", Integer.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("descripcion", String.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("precio", Float.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("stock", Integer.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("ruta_image", String.class, ParameterMode.IN);
                manager.close();
                processStored.setParameter("idProducto", obj.getIdProducto());
                processStored.setParameter("FkcategoriaId", obj.getFkCategoriaId());
                processStored.setParameter("nombre", obj.getNombre());
                processStored.setParameter("descripcion", obj.getDescripcion());    
                processStored.setParameter("precio", obj.getPrecio());
                processStored.setParameter("stock", obj.getStock());
                processStored.setParameter("ruta_image", obj.getRuta_image()); 
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

    @Override
    public ResultClassEntity<List<ProductoDto>> listarProducto() throws Exception {
        ResultClassEntity<List<ProductoDto>> result = new ResultClassEntity<List<ProductoDto>>();
        Integer totalRecord = 0;

        
         try {
            List<ProductoDto> lista = new ArrayList<>();
            StoredProcedureQuery processStored = manager.createStoredProcedureQuery("`inventario_basico_1`.`sp_producto_listar`");
            manager.close();
            
            processStored.execute();
            List<Object[]> spResult = processStored.getResultList();
            if (spResult.size() >= 1){
                ProductoDto obj_ = null;
                for (Object[] row_: spResult){
                    obj_ = new ProductoDto();
                    obj_.setIdProducto(row_[0]==null?null:(Integer) row_[0]);
                    obj_.setFkCategoriaId(row_[1]==null?null:(Integer) row_[1]);
                    obj_.setNombre(row_[2]==null?null:(String) row_[2]);
                    obj_.setDescripcion(row_[3]==null?null:(String) row_[3]);
                    obj_.setPrecio(row_[4]==null?null:(Float) row_[4]);
                    obj_.setStock(row_[5]==null?null:(Integer) row_[5]);
                    obj_.setRuta_image(row_[6]==null?null:(String) row_[6]);

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
            log.error("listar Producto - " + e.getMessage(), e);
            result.setSuccess(false);
            result.setTotalRecord(totalRecord);
            result.setMessage("Ocurrió un error." + e.getMessage());
            return result;
        }
    }


    @Override
    public ResultClassEntity registrarProducto(ProductoDto obj) throws Exception {
        ResultClassEntity result = new ResultClassEntity();

        try {
            
            String sql = "SELECT * FROM t_producto where nombre = '"+obj.getNombre().toString()+"'";
            Query query =  manager.createNativeQuery(sql);

            List<Object[]> exist = query.getResultList();

            if (exist.size()>=1){
                result.setSuccess(false);
                result.setMessage("El producto "+obj.getNombre().toString()+" ya existe.");
            }else{
                StoredProcedureQuery processStored = manager.createStoredProcedureQuery("`inventario_basico_1`.`sp_producto_crear`");
                processStored.registerStoredProcedureParameter("FkcategoriaId", Integer.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("descripcion", String.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("precio", Float.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("stock", Integer.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("ruta_image", String.class, ParameterMode.IN);
                manager.close();
                processStored.setParameter("FkcategoriaId", obj.getFkCategoriaId());
                processStored.setParameter("nombre", obj.getNombre());
                processStored.setParameter("descripcion", obj.getDescripcion());    
                processStored.setParameter("precio", obj.getPrecio());
                processStored.setParameter("stock", obj.getStock());
                processStored.setParameter("ruta_image", obj.getRuta_image()); 
                processStored.execute();

                result.setSuccess(true);
                result.setMessage("Se registró correctamente.");
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

    @Override
    public ResultClassEntity registrarCategoria(CategoriaDto obj) throws Exception {
        ResultClassEntity result = new ResultClassEntity();

        try {
            
            String sql = "SELECT * FROM t_categoria where nombre = '"+obj.getNombre().toString()+"'";
            Query query =  manager.createNativeQuery(sql);

            List<Object[]> exist = query.getResultList();

            if (exist.size()>=1){
                result.setSuccess(false);
                result.setMessage("La Categoria "+obj.getNombre().toString()+" ya existe.");
            }else{
                StoredProcedureQuery processStored = manager.createStoredProcedureQuery("`inventario_basico_1`.`sp_categoria_crear`");
                processStored.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("descripcion", String.class, ParameterMode.IN);
                manager.close();
                processStored.setParameter("nombre", obj.getNombre());
                processStored.setParameter("descripcion", obj.getDescripcion());     
                processStored.execute();

                result.setSuccess(true);
                result.setMessage("Se registró correctamente.");
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

    @Override
    public ResultClassEntity<List<CategoriaDto>> listarCategoria() throws Exception {
        ResultClassEntity<List<CategoriaDto>> result = new ResultClassEntity<List<CategoriaDto>>();
        Integer totalRecord = 0;

        
         try {
            List<CategoriaDto> lista = new ArrayList<>();
            StoredProcedureQuery processStored = manager.createStoredProcedureQuery("`inventario_basico_1`.`sp_categoria_listar`");
            manager.close();
            
            processStored.execute();
            List<Object[]> spResult = processStored.getResultList();
            if (spResult.size() >= 1){
                CategoriaDto obj_ = null;
                for (Object[] row_: spResult){
                    obj_ = new CategoriaDto();
                    obj_.setIdCategoria(row_[0]==null?null:(Integer) row_[0]);
                    obj_.setNombre(row_[1]==null?null:(String) row_[1]);
                    obj_.setDescripcion(row_[2]==null?null:(String) row_[2]);

                    lista.add(obj_);
                    totalRecord++;
                }
            }

            result.setData(lista);
            result.setSuccess(true);
            result.setTotalRecord(totalRecord);
            result.setMessage("Se listó categoria correctamente.");
            return result;
        } catch (Exception e) {
            log.error("listar Categoria - " + e.getMessage(), e);
            result.setSuccess(false);
            result.setTotalRecord(totalRecord);
            result.setMessage("Ocurrió un error." + e.getMessage());
            return result;
        }
    }

    @Override
    public ResultClassEntity actualizarCategoria(CategoriaDto obj) throws Exception {
        ResultClassEntity result = new ResultClassEntity();

        try {
            
            String sql = "SELECT * FROM t_categoria where idCategoria = '"+obj.getIdCategoria()+"'";
            Query query =  manager.createNativeQuery(sql);

            List<Object[]> exist = query.getResultList();

            if (exist.size()<1){
                result.setSuccess(false);
                result.setMessage("La Categoria "+obj.getNombre().toString()+" ya no existe.");
            }else{
                StoredProcedureQuery processStored = manager.createStoredProcedureQuery("`inventario_basico_1`.`sp_categoria_actualizar`");
                processStored.registerStoredProcedureParameter("idCategoria", Integer.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
                processStored.registerStoredProcedureParameter("descripcion", String.class, ParameterMode.IN);
                manager.close();
                processStored.setParameter("idCategoria", obj.getIdCategoria());
                processStored.setParameter("nombre", obj.getNombre());
                processStored.setParameter("descripcion", obj.getDescripcion());     
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

    @Override
    public ResultClassEntity eliminarCategoria(CategoriaDto obj) throws Exception {
        ResultClassEntity result = new ResultClassEntity();

        try {
            
            StoredProcedureQuery processStored = manager.createStoredProcedureQuery("`inventario_basico_1`.`sp_categoria_eliminar`");
            processStored.registerStoredProcedureParameter("idCategoria", Integer.class, ParameterMode.IN);
            manager.close();
            processStored.setParameter("idCategoria", obj.getIdCategoria());    
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

    
}
