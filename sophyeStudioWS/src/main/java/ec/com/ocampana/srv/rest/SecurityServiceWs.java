/*
 * Copyright 2020 Oscar Campana. 
 * Todos los derechos reservados.
 * Autor:		Oscar Campana
 * Objetivo:	[Exponer servicios web]
 * Fecha:		07 may. de 2020
 * Nro. Req:	[1466]
 * Version:		1.0
 */
package main.java.ec.com.ocampana.srv.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import main.java.ec.com.ocampana.srv.model.Tseguser;
import main.java.ec.com.ocampana.srv.pojo.LoginRequest;
import main.java.ec.com.ocampana.srv.pojo.ServiceResponse;
import main.java.ec.com.ocampana.srv.service.SecurityService;
import main.java.ec.com.ocampana.srv.utils.UtilsX;

/**
 * <b> Clase que contiene los EndPoints de los servicios Restful a ser expuestos
 * </b>
 * 
 * @author Oscar Campana
 *
 */
@Path("/securityService")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class SecurityServiceWs {

	private final static Logger logger = Logger.getLogger(SecurityServiceWs.class);

	@EJB
	private SecurityService securityService;

	/**
	 * 
	 * <b> Consulta Usuarios </b>
	 * 
	 * @param userName
	 * @return TsegUser
	 */
	@GET
	@Path("/getUsers")
	@Produces("application/json")
	public Tseguser getUsers(@QueryParam("userName") String userName) {

		List<Tseguser> user = null;
		try {
			user = securityService.getUsers(userName);
		} catch (Exception e) {
			logger.error(e);
		}

		return user.get(0);

	}
	
	/**
	 * <b> Valida credenciales de usuario</b>
	 * 
	 * @param userName
	 * @param password
	 * @return boolean
	 */
	@GET
	@Path("/validateCredential")
	@Produces("application/json")
	public ServiceResponse validateCredential(@QueryParam("userName") String userName, @QueryParam("password") String password) {

		ServiceResponse valid = new ServiceResponse();
		
		try {
			byte[] pass = UtilsX.cifra(password);
			valid = securityService.validateCredentials(userName, pass);
		} catch (Exception e) {
			logger.error(e);
		}

		return valid;

	}
	
	
	/**
	 * <b> Valida credenciales de usuario</b>
	 * 
	 * @param userName
	 * @param password
	 * @return boolean
	 */
	@POST
	@Path("/login")
	@Produces("application/json")
	public ServiceResponse login(String request) {

		LoginRequest loginRequest = LoginRequest.fromString(request);
		ServiceResponse valid = new ServiceResponse();
		
		try {
			byte[] pass = UtilsX.cifra(loginRequest.getPassword());
			valid = securityService.validateCredentials(loginRequest.getUsername(), pass);
		} catch (Exception e) {
			logger.error(e);
		}

		return valid;

	}
	
	

}
