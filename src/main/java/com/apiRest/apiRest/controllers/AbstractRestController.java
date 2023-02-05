package com.apiRest.apiRest.controllers;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;

import com.apiRest.apiRest.models.ResultClassEntity;
import com.apiRest.apiRest.repositories.util.Constantes;

public abstract class AbstractRestController {

	
	public static ResultClassEntity buildResponse(boolean estado, Object data, String message, Exception e) {

		ResultClassEntity response = new ResultClassEntity();
		response.setData(data);
		response.setMessage(StringUtils.EMPTY);
		
		if(estado) {
			if(StringUtils.isBlank(message)){
				response.setMessage(Constantes.MESSAGE_SUCCESS);
			}else{
				response.setMessage(message);
			}
			
			response.setSuccess(true);
		}else {
			if(e == null) {
				response.setMessage(message);
			}else {
				response.setMessage(Constantes.MESSAGE_ERROR.concat(" ").concat(e.getMessage()));
			}
			
			response.setSuccess(false);
		}
		
		return response;

	}
}

/* response.setData(null);
        response.setSuccess(false);
        if(e == null) response.setMessage(Constantes.MESSAGE_ERROR_500);
        response.setMessage(Constantes.MESSAGE_ERROR.concat(" ").concat(e.getMessage())); */