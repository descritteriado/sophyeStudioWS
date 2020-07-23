package main.java.ec.com.ocampana.srv.dao.securities;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import main.java.ec.com.ocampana.srv.dao.GenericDaoImpl;
import main.java.ec.com.ocampana.srv.model.Tsegmodule;

@Stateless
public class ModuleDao<Entity> extends GenericDaoImpl<Entity> {

	final static Logger logger = Logger.getLogger(ModuleDao.class);

	@PersistenceContext(unitName = "skeletonJPA")
	private EntityManager entityManager;

	/**
	 * Metodo para consultar los modulos dados ciertos parametros
	 * 
	 * @param moduleName
	 * @return Lista de Modulos List<Tsegmodule>
	 */
	@SuppressWarnings("unchecked")
	public List<Tsegmodule> getModules(String moduleName) throws Exception {

		List<Tsegmodule> modules = null;
		String preQuery = "SELECT u FROM Tsegmodule as u " + "WHERE 1=1 ";

		preQuery = preQuery.concat(!moduleName.isEmpty() ? "and  u.description like :description" : "");

		Query query = entityManager.createQuery(preQuery);

		if (!moduleName.isEmpty()) {
			query.setParameter("description", "%" + moduleName + "%");
		}

		modules = query.getResultList();

		return modules;
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
	public void remove(Entity entity) {

		this.entityManager.remove(this.entityManager.contains(entity) ? entity : this.entityManager.merge(entity));

	}

}
