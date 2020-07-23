package main.java.ec.com.ocampana.srv.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import main.java.ec.com.ocampana.srv.dao.securities.UserDao;
import main.java.ec.com.ocampana.srv.model.Tseguser;
import main.java.ec.com.ocampana.srv.pojo.ServiceResponse;

@Stateless
public class SecurityServiceImpl implements SecurityService {

	private static final Logger logger = Logger.getLogger(SecurityServiceImpl.class);

	@PersistenceContext(unitName = "skeletonJPA")
	EntityManager em;

	@EJB
	private UserDao<Tseguser> userDao;

	@Override
	public List<Tseguser> getUsers(String codUser) throws Exception {

		List<Tseguser> user = null;
		try {

			user = userDao.getUsers(codUser, "", "", false);

		} catch (Exception e) {
			logger.error(e);
		}
		return user;
	}
	
	@Override
	public ServiceResponse validateCredentials(String userName, byte[] password) throws Exception {

		ServiceResponse user = null;
		try {

			user = userDao.validateCredentials(userName, password);

		} catch (Exception e) {
			logger.error(e);
		}
		return user;
	}

}
