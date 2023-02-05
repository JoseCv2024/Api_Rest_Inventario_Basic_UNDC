package com.apiRest.apiRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);

		try{
		
		System.out.println("Proceso terminado...");  
		}catch(Exception e)
        {
            System.out.println(e);
			System.out.println("Ocurrio un Error.");
        }
	}

}
