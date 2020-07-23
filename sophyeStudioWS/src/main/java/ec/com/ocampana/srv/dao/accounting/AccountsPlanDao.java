package main.java.ec.com.ocampana.srv.dao.accounting;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import main.java.ec.com.ocampana.srv.dao.GenericDaoImpl;
import main.java.ec.com.ocampana.srv.model.Taccaccountsplan;

@Stateless
public class AccountsPlanDao<Entity> extends GenericDaoImpl<Entity> {

	final static Logger logger = Logger.getLogger(AccountsPlanDao.class);

	@PersistenceContext(unitName = "skeletonJPA")
	private EntityManager entityManager;

	/**
	 * Metodo para consultar el plan de cuentas
	 * 
	 * @param code
	 * @param name
	 * @return Plan de cuentas List<Taccaccountsplan>
	 */
	@SuppressWarnings("unchecked")
	public List<Taccaccountsplan> getAccountsPlan(String code, String name) throws Exception {

		List<Taccaccountsplan> planCuentas = null;
		String preQuery = "SELECT u FROM Taccaccountsplan as u " + "WHERE 1=1 ";

		if (!code.isEmpty()) {
				preQuery = preQuery.concat("and  u.code = :code ");
		}
		if (!name.isEmpty()) {
			preQuery = preQuery.concat("and  u.name like :name ");
		}
		preQuery = preQuery.concat(" ORDER BY u.code ASC ");
		Query query = entityManager.createQuery(preQuery);
		
		if (!code.isEmpty()) {
				query.setParameter("code", code);
		}

		if (!name.isEmpty()) {
			query.setParameter("name", "%" + name + "%");
		}

		planCuentas = query.getResultList();

		return planCuentas;
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
