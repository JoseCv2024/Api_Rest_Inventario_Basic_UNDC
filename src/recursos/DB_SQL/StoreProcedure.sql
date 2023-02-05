/* CREATE OBJECT */

DELIMITER $$
CREATE PROCEDURE `sp_usuario_crear`(
-- inout idUsuario int,
in nombre varchar(50),
in apellido varchar(50),
in usuario varchar(50),
in perfil int,
in contrasena varchar(120) 
)
begin

	insert into t_usuario(nombre, apellido, usuario, perfil, contrasena)
	values(nombre, apellido, usuario, perfil, contrasena); 
    
	 select * from t_usuario where idUsuario = (select LAST_INSERT_ID());

end$$
DELIMITER ;

/* CATEGORIA */
DELIMITER $$
CREATE PROCEDURE `sp_categoria_eliminar`(
in idCategoria int
)
begin
	SET SQL_SAFE_UPDATES = 0;
	delete from t_categoria where idCategoria = idCategoria;
	SET SQL_SAFE_UPDATES = 1;
end$$
DELIMITER ;

CALL `inventario_basico_1`.`sp_categoria_eliminar`(2);