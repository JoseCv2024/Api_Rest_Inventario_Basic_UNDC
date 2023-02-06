package com.apiRest.apiRest.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiRest.apiRest.models.CategoriaDto;
import com.apiRest.apiRest.models.ProductoDto;
import com.apiRest.apiRest.models.ResultClassEntity;
import com.apiRest.apiRest.repositories.util.Urls;
import com.apiRest.apiRest.services.ProductoService;

@RestController
@RequestMapping(Urls.producto.BASE)
public class ProductoController extends AbstractRestController{
    private static final Logger log = LogManager.getLogger(ProductoDto.class);

    @Autowired
    ProductoService productoService;

    @PostMapping(path = "/eliminarProducto")
    public ResponseEntity eliminarProducto(@RequestBody ProductoDto data){
        log.info("Producto - eliminar Producto.",data.toString());

        ResponseEntity result = null;
        ResultClassEntity response = new ResultClassEntity();
        try {
            response =  productoService.eliminarProducto(data);

            log.info("Producto - eliminar Producto", "Proceso realizado correctamente");
            if (response.getSuccess()==null || !response.getSuccess()) {
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST); 
            } else {
                return new ResponseEntity(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Producto - eliminar Producto", "Ocurrió un error : " + e.getMessage());
            return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/actualizarProducto")
    public ResponseEntity actualizarProducto(@RequestBody ProductoDto data){
        log.info("Producto - actualizar Producto",data.toString());

        ResponseEntity result = null;
        ResultClassEntity response = new ResultClassEntity();
        try {
            response =  productoService.actualizarProducto(data);

            log.info("Producto - actualizar Producto", "Proceso realizado correctamente");
            if (response.getSuccess()==null || !response.getSuccess()) {
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST); 
            } else {
                return new ResponseEntity(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Producto - actualizar Producto", "Ocurrió un error : " + e.getMessage());
            return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/registrarProducto")
    public ResponseEntity registrarProducto(@RequestBody ProductoDto data){
        log.info("Producto - registrar Producto",data.toString());

        ResponseEntity result = null;
        ResultClassEntity response = new ResultClassEntity();
        try {
            response =  productoService.registrarProducto(data);

            log.info("Producto - crear Producto", "Proceso realizado correctamente");
            if (response.getSuccess()==null || !response.getSuccess()) {
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST); 
            } else {
                return new ResponseEntity(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Producto - crear Producto", "Ocurrió un error : " + e.getMessage());
            return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/listarProducto")
    public ResponseEntity listaProducto() throws Exception{
        ResponseEntity result = null;
        ResultClassEntity<List<ProductoDto>> response = new ResultClassEntity<>();

        try {
            response =  productoService.listarProducto();
            log.info("Producto - Listar Producto", "Proceso realizado correctamente");
            if (!response.getSuccess()) {
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Producto - Listar Producto", "Ocurrió un error : " + e.getMessage());
            //response = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
            return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*  ************* C A T E G O R I A  ********************* */

    @PostMapping(path = "/actualizarCategoria")
    public ResponseEntity actualizarCategoria(@RequestBody CategoriaDto data){
        log.info("Categoria - actualizar Categoria",data.toString());

        ResponseEntity result = null;
        ResultClassEntity response = new ResultClassEntity();
        try {
            response =  productoService.actualizarCategoria(data);

            log.info("Categoria - actualizar Categoria", "Proceso realizado correctamente");
            if (response.getSuccess()==null || !response.getSuccess()) {
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST); 
            } else {
                return new ResponseEntity(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Categoria - actualizar Categoria", "Ocurrió un error : " + e.getMessage());
            return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/registrarCategoria")
    public ResponseEntity registrarCategoria(@RequestBody CategoriaDto data){
        log.info("Categoria - registrar Categoria",data.toString());

        ResponseEntity result = null;
        ResultClassEntity response = new ResultClassEntity();
        try {
            response =  productoService.registrarCategoria(data);

            log.info("Categoria - crear Categoria", "Proceso realizado correctamente");
            if (response.getSuccess()==null || !response.getSuccess()) {
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST); 
            } else {
                return new ResponseEntity(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Categoria - crear Categoria", "Ocurrió un error : " + e.getMessage());
            return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    @GetMapping(path = "/listarCategoria")
    public ResponseEntity listaCategoria() throws Exception{
        ResponseEntity result = null;
        ResultClassEntity<List<CategoriaDto>> response = new ResultClassEntity<>();

        try {
            response =  productoService.listarCategoria();
            log.info("Categoria - Listar Categoria", "Proceso realizado correctamente");
            if (!response.getSuccess()) {
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Categoria - Listar Categoria", "Ocurrió un error : " + e.getMessage());
            //response = buildResponse(Constantes.STATUS_ERROR, null, Constantes.MESSAGE_ERROR_500, e);
            return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping(path = "/eliminarCategoria")
    public ResponseEntity eliminarCategoria(@RequestBody CategoriaDto data){
        log.info("Categoria - eliminar Categoria",data.toString());

        ResponseEntity result = null;
        ResultClassEntity response = new ResultClassEntity();
        try {
            response =  productoService.eliminarCategoria(data);

            log.info("Categoria - eliminar Categoria", "Proceso realizado correctamente");
            if (response.getSuccess()==null || !response.getSuccess()) {
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST); 
            } else {
                return new ResponseEntity(response, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.error("Categoria - eliminar Categoria", "Ocurrió un error : " + e.getMessage());
            return new ResponseEntity(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

   
}
