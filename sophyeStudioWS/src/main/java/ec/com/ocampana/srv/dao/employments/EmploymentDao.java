package main.java.ec.com.ocampana.srv.dao.employments;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import main.java.ec.com.ocampana.srv.dao.GenericDaoImpl;
import main.java.ec.com.ocampana.srv.model.Tempemployment;

@Stateless
public class EmploymentDao<Entity> extends GenericDaoImpl<Entity> {

	final static Logger logger = Logger.getLogger(EmploymentDao.class);

	@PersistenceContext(unitName = "skeletonJPA")
	private EntityManager entityManager;

	/**
	 * Metodo para consultar los clientes dados ciertos parametros
	 * 
	 * @param document
	 * @param name
	 * @param lastName
	 * @return Lista de clientes List<Tsegclient>
	 */
	@SuppressWarnings("unchecked")
	public List<Tempemployment> getEmployments(String document, String name, String lastName, Boolean status,
			Integer id) throws Exception {

		List<Tempemployment> employments = null;
		String preQuery = "SELECT u FROM Tempemployment as u " + "WHERE u.deleted= false ";

		if (status != null) {

			preQuery = preQuery.concat("and u.status= :status ");
		}
		if (!document.isEmpty()) {

			preQuery = preQuery.concat("and  u.document like :document ");
		}
		if (!name.isEmpty()) {
			preQuery = preQuery.concat("and  u.names like :name ");
		}
		if (!lastName.isEmpty()) {
			preQuery = preQuery.concat("and u.lastnames like :lastName ");
		}
		if (id != null) {

			preQuery = preQuery.concat("and u.id= :id ");
		}

		Query query = entityManager.createQuery(preQuery);
		if (status != null) {
			query.setParameter("status", status);
		}

		if (!document.isEmpty()) {
			query.setParameter("document", "%" + document + "%");
		}
		if (!name.isEmpty()) {
			query.setParameter("name", "%" + name + "%");
		}
		if (!lastName.isEmpty()) {
			query.setParameter("lastName", "%" + lastName + "%");
		}
		if (id != null) {

			query.setParameter("id", id);
		}

		employments = query.getResultList();

		return employments;
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
