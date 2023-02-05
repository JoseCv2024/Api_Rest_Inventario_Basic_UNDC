package com.apiRest.apiRest.models;

import java.io.Serializable;

public class ResultClassEntity<S> implements Serializable{
    Integer Codigo;
	Boolean IsSuccess;
	String Message;
	String MessageExeption;
	String InnerException;
	String Informacion;
	Integer totalRecord;
	S data;



	public ResultClassEntity() {
	}

	public ResultClassEntity(S data) {
		this.setSuccess(true);
		this.setData(data);
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getCodigo() {
		return Codigo;
	}

	public void setCodigo(Integer codigo) {
		Codigo = codigo;
	}

	public Boolean getSuccess() {
		return IsSuccess;
	}

	public void setSuccess(Boolean success) {
		IsSuccess = success;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getMessageExeption() {
		return MessageExeption;
	}

	public void setMessageExeption(String messageExeption) {
		MessageExeption = messageExeption;
	}

	public String getInnerException() {
		return InnerException;
	}

	public void setInnerException(String innerException) {
		InnerException = innerException;
	}

	public String getInformacion() {
		return Informacion;
	}

	public void setInformacion(String informacion) {
		Informacion = informacion;
	}

	public S getData() {
		return data;
	}

	public void setData(S data) {
		this.data = data;
	}



}
