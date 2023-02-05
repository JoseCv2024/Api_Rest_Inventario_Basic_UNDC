-- create database inventario_basico_1;
use inventario_basico_1;

create table t_categoria (
	idCategoria int NOT NULL AUTO_INCREMENT,
	nombre varchar(80) NOT NULL,
    descripcion varchar(80) NULL, -- Puede ser null
    PRIMARY KEY (idCategoria)
);

create table t_producto (
	idProducto int NOT NULL AUTO_INCREMENT,
    FkcategoriaId int NOT NULL,
    nombre varchar(80) NOT NULL,
    descripcion varchar(80) NULL, -- Puede ser null
    precio float NOT NULL,
    stock int NOT NULL,
    ruta_image varchar(180) NULL, -- Puede ser null
	PRIMARY KEY (idProducto),
    FOREIGN KEY (FkcategoriaId) REFERENCES t_categoria(idCategoria)
);

create table t_usuario (
	idUsuario int NOT NULL AUTO_INCREMENT,
    nombre varchar(50) NOT NULL,
    apellido varchar(50) NOT NULL,
    usuario varchar(50) NOT NULL,
    perfil int NOT NULL,
    contrasena varbinary(120) NOT NULL,
    PRIMARY KEY (idUsuario)
);

create table t_venta_detalle (
	idVentaDetalle int NOT NULL AUTO_INCREMENT,
    FkidVenta int NOT NULL, -- FK con la tabla t_ventas
    FkidProducto int NOT NULL,
    cantidad int NOT NULL,
    total float NOT NULL,
    PRIMARY KEY (idVentaDetalle),
    FOREIGN KEY (FkidVenta) REFERENCES t_ventas(idVentas)
); 

create table t_ventas (
	idVentas int NOT NULL AUTO_INCREMENT,
    FkidUsuario int NOT NULL,
    fecha_venta varchar(16) NOT NULL,
    descuento float NULL, -- Puede ser null
    total float NOT NULL,
    PRIMARY KEY (idVentas),
    FOREIGN KEY (FkidUsuario) REFERENCES t_usuario(idUsuario)
);


