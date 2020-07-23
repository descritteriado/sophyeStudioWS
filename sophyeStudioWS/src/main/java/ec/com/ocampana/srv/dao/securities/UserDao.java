package main.java.ec.com.ocampana.srv.dao.securities;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import main.java.ec.com.ocampana.srv.dao.GenericDaoImpl;
import main.java.ec.com.ocampana.srv.model.Tseguser;
import main.java.ec.com.ocampana.srv.pojo.ServiceResponse;
import main.java.ec.com.ocampana.srv.utils.ResponseEnum;

@Stateless
public class UserDao<Entity> extends GenericDaoImpl<Entity> {

	final static Logger logger = Logger.getLogger(UserDao.class);

	@PersistenceContext(unitName = "skeletonJPA")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Object> getMenu(String username, String idModule) {

		Query query = entityManager.createQuery("SELECT m.description as modDesc, t.description as traDesc, t.url "
				+ "FROM Tseguser as u, Tseguserprofile as up, Tsegprofiletransaction as pt, "
				+ "Tsegtransaction as t, Tsegmodule as m " + "WHERE u.deleted= false and u.id = up.tseguser.id "
				+ "and up.tsegprofile.id = pt.tsegprofile.id " + "and pt.tsegtransaction.id = t.id "
				+ "and t.tsegmodule.id = m.id " + "and u.username= :userName  and m.id= :idModule");
		query.setParameter("userName", username);
		query.setParameter("idModule", Integer.parseInt(idModule));
		List<Object> transacciones = query.getResultList();

		return transacciones;
	}

	/*
	 * @SuppressWarnings("unchecked") public List<Object> getMenu(String username,
	 * String idModule) {
	 * 
	 * Query query = entityManager.
	 * createQuery("SELECT m.description as modDesc, t.description as traDesc, t.url "
	 * + "FROM Tseguser as u, Tseguserprofile as up, Tsegprofiletransaction as pt, "
	 * + "Tsegtransaction as t, Tsegmodule as m " +
	 * "WHERE u.deleted= false and u.id = up.iduser " +
	 * "and up.idprofile = pt.idprofile " + "and pt.idtransaction = t.id " +
	 * "and t.idmodule = m.id " + "and u.username= :userName  and m.id= :idModule");
	 * query.setParameter("userName", username); query.setParameter("idModule",
	 * Integer.parseInt(idModule)); List<Object> transacciones =
	 * query.getResultList();
	 * 
	 * return transacciones; }
	 */

	public ServiceResponse validateCredentials(String username, byte[] password) {

		String valid = null;
		ServiceResponse serviceResponse = new ServiceResponse(ResponseEnum.OK);
		
		try {

			Query query = entityManager.createQuery("SELECT u.username FROM Tseguser as u WHERE u.deleted= false and u.username= :userName and u.password= :password");
			query.setParameter("userName", username);
			query.setParameter("password", password);
			valid = query.getResultList().size()==0?"":(String)query.getResultList().get(0);
		}
		catch (Exception e) {
			logger.error(e);
		}
		
		return valid.isEmpty()? serviceResponse.setServiceResponse(ResponseEnum.UNAUTHORIZED):serviceResponse.setServiceResponse(ResponseEnum.AUTHORIZED);

	}

	/**
	 * Metodo para consultar los usuarios dados ciertos parametros
	 * 
	 * @param username
	 * @param name
	 * @param lastName
	 * @return Lista de usuarios List<Tseguser>
	 */
	public List<Tseguser> getUsers(String username, String name, String lastName, Boolean status) throws Exception {

		List<Tseguser> users = null;
		String preQuery = "SELECT u FROM Tseguser as u " + "WHERE u.deleted= false and u.status= :status ";

		if (username != null && !username.isEmpty()) {

			preQuery = preQuery.concat("and  u.username like :userName ");
		}
		if (name != null && !name.isEmpty()) {
			preQuery = preQuery.concat("and  u.employment.names like :name ");
		}
		if (lastName != null && !lastName.isEmpty()) {
			preQuery = preQuery.concat("and u.employment.lastnames like :lastName ");
		}

		Query query = entityManager.createQuery(preQuery);
		query.setParameter("status", status);

		if (username != null && !username.isEmpty()) {
			query.setParameter("userName", "%" + username + "%");
		}
		if (name != null && !name.isEmpty()) {
			query.setParameter("name", "%" + name + "%");
		}
		if (lastName != null && !lastName.isEmpty()) {
			query.setParameter("lastName", "%" + lastName + "%");
		}

		users = query.getResultList();

		return users;
	}

	@Override
	public boolean merge(Entity entity) {
		try {
			this.entityManager.merge(entity);
			this.entityManager.flush();
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	@Override
	public void remove(Entity entity) throws Exception {

		this.entityManager.remove(this.entityManager.contains(entity) ? entity : this.entityManager.merge(entity));

	}

}
