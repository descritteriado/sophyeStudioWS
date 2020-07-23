package main.java.ec.com.ocampana.srv.pojo;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;

import main.java.ec.com.ocampana.srv.service.SecurityServiceImpl;

public class LoginRequest {
	
	private static final Logger logger = Logger.getLogger(SecurityServiceImpl.class);
	
	String username;
	String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * <b>Metodo para transformar un dato en formato JSON en un Objeto
	 * generico</b>
	 * 
	 * @param <T>
	 * 
	 * @param jsonRepresentation
	 * @return LoginRequest
	 */
	public static LoginRequest fromString(String jsonRepresentation) {
		
		Gson gson = new Gson();
		
		LoginRequest loginRequest = gson.fromJson(jsonRepresentation, LoginRequest.class);
		return loginRequest;
		
	}
}