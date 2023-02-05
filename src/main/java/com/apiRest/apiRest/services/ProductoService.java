package com.apiRest.apiRest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apiRest.apiRest.models.CategoriaDto;
import com.apiRest.apiRest.models.ProductoDto;
import com.apiRest.apiRest.models.ResultClassEntity;

@Service
public interface ProductoService {
    
    ResultClassEntity eliminarProducto(ProductoDto obj) throws Exception;
    ResultClassEntity actualizarProducto(ProductoDto obj) throws Exception;
    ResultClassEntity registrarProducto(ProductoDto obj) throws Exception;
    ResultClassEntity<List<ProductoDto>> listarProducto() throws Exception;

    ResultClassEntity registrarCategoria(CategoriaDto obj) throws Exception;
    ResultClassEntity<List<CategoriaDto>> listarCategoria() throws Exception;
    ResultClassEntity actualizarCategoria(CategoriaDto obj) throws Exception;
    ResultClassEntity eliminarCategoria(CategoriaDto obj) throws Exception;


    


}
