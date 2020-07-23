package main.java.ec.com.ocampana.srv.service;

import java.util.List;

import javax.ejb.Local;

import main.java.ec.com.ocampana.srv.model.Tseguser;
import main.java.ec.com.ocampana.srv.pojo.ServiceResponse;

/**
 * 
 * <b> Interface para metodos de comunicacion a la base de datos </b>
 * 
 * @author Oscar Campana
 * @version $Revision: 1.1 $
 *          <p>
 *          [$Author: Oscar Campana $, $Date: 29 de Enero. de 2020 $]
 *          </p>
 */
@Local
public interface SecurityService {
	
	
	/**
	 * <b> Consulta Usuarios </b>
	 * <p>
	 * [Author: "Oscar Campana", Date: 29/01/2020]
	 * </p>
	 * 
	 * @param codUser
	 * @param 
	 * @return Tseguser
	 */
	List<Tseguser> getUsers(String codUser) throws Exception;
	
	/**
	 * <b> Valida credenciales de usuario </b>
	 * <p>
	 * [Author: "Oscar Campana", Date: 10/05/2020]
	 * </p>
	 * 
	 * @param userName
	 * @param password
	 * @return boolean
	 */
	ServiceResponse validateCredentials(String userName, byte[] password) throws Exception;


	

}
