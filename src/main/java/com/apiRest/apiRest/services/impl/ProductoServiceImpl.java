package com.apiRest.apiRest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiRest.apiRest.models.CategoriaDto;
import com.apiRest.apiRest.models.ProductoDto;
import com.apiRest.apiRest.models.ResultClassEntity;
import com.apiRest.apiRest.repositories.ProductoRepository;
import com.apiRest.apiRest.services.ProductoService;

@Service("ProductoService")
public class ProductoServiceImpl implements ProductoService{
    public ProductoServiceImpl() {
    }

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public ResultClassEntity eliminarProducto(ProductoDto obj) throws Exception {
        return productoRepository.eliminarProducto(obj);
    }

    @Override
    public ResultClassEntity actualizarProducto(ProductoDto obj) throws Exception {
        return productoRepository.actualizarProducto(obj);
    }

    @Override
    public ResultClassEntity<List<ProductoDto>> listarProducto() throws Exception {
        return  productoRepository.listarProducto(); 
    }

    @Override
    public ResultClassEntity registrarProducto(ProductoDto obj) throws Exception {
        return  productoRepository.registrarProducto(obj);
    }

    @Override
    public ResultClassEntity registrarCategoria(CategoriaDto obj) throws Exception {
        return  productoRepository.registrarCategoria(obj);
    }

    public ResultClassEntity<List<CategoriaDto>> listarCategoria() throws Exception{
        return  productoRepository.listarCategoria(); 
     }

    @Override
    public ResultClassEntity actualizarCategoria(CategoriaDto obj) throws Exception {
        return  productoRepository.actualizarCategoria(obj); 
    }

    @Override
    public ResultClassEntity eliminarCategoria(CategoriaDto obj) throws Exception {
        return productoRepository.eliminarCategoria(obj);
    }



}
