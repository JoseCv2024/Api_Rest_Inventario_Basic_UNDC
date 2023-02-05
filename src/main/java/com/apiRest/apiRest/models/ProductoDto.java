package com.apiRest.apiRest.models;
import lombok.Data;

@Data
public class ProductoDto {
    public Integer idProducto;
    public Integer FkCategoriaId;
    public String nombre;
    public String descripcion;
    public Float precio;
    public Integer stock;
    public String ruta_image;

}
