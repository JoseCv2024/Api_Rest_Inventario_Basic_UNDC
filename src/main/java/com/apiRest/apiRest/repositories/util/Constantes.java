package com.apiRest.apiRest.repositories.util;

import java.io.Serializable;

public class Constantes implements Serializable {
    public final static String MESSAGE_ERROR_500 = "Estamos teniendo problemas. Por favor comuníquese con el administrador del sistema.";
    public final static String EMPTY = "";
	/**
	 * FORMATO DE FECHAS
	 **/
	/* public final static String HORA_FORMATO = "HH:mm:ss";
	public final static String FECHA_FORMATO = "dd/MM/yyyy";
	public final static String FECHA_FORMATO_HORAS = "dd/MM/yyyy HH:mm:ss";
	public final static String HORA_VALUE_INICIO_DEFAULT = "00:00:00";
	public final static String HORA_VALUE_FINAL_DEFAULT = "23:59:59"; */

/* 	public static final Character ESTADO_ACTIVO = '1';
	public static final Character ESTADO_INACTIVO = '0';
	public static final String CODIGO_EMPRESA_DEFAULT = "99"; */

	/* public static final String MENSAJE_SIN_CODIGO = "Debe generar un código.";
	public static final String MENSAJE_CODIGO_DISTINTO = "El código ingresado es incorrecto.";
	public static final String MENSAJE_CODIGO_GENERADO_CORRECTAMENTE = "El código generado se envió a su correo institucional.";
	public static final String MENSAJE_DNI_NO_ENCONTRADO = "No se encontró coincidencias con el número de DNI ingresado.";
	public static final String MENSAJE_CODIGO_EXISTE = "Ya cuenta con un código generado el día de hoy, verifique su correo.";
	public static final String MENSAJE_REGISTRO_MARCACION_CORRECTAMENTE = "Se registró su marcación, correctamente.";
 */
	public final static String MESSAGE_SUCCESS = "Operation Success! ";
	public final static String MESSAGE_ERROR = "Operation Failed! ";

	public final static boolean STATUS_SUCCESS = Boolean.TRUE;
	public final static boolean STATUS_ERROR = Boolean.FALSE;

	public final static String MENSAJE_CONSULTA_SIN_RESULTADO = "No se encontraron coincidencias con los parámetros ingresados.";

	public static final String ACTIVO = "A";
}
