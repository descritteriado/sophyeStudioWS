package main.java.ec.com.ocampana.srv.dao.securities;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import main.java.ec.com.ocampana.srv.dao.GenericDaoImpl;
import main.java.ec.com.ocampana.srv.model.Tsegprofile;

@Stateless
public class ProfileDao<Entity> extends GenericDaoImpl<Entity> {

	final static Logger logger = Logger.getLogger(ProfileDao.class);

	@PersistenceContext(unitName = "skeletonJPA")
	private EntityManager entityManager;

	/**
	 * Metodo para consultar los perfiles dados ciertos parametros
	 * 
	 * @param profileName
	 * @return Lista de perfiles List<Tseguser>
	 */
	@SuppressWarnings("unchecked")
	public List<Tsegprofile> getProfiles(String profileName) throws Exception {

		List<Tsegprofile> profiles = null;
		String preQuery = "SELECT u FROM Tsegprofile as u " + "WHERE 1=1 ";

		preQuery = preQuery.concat(!profileName.isEmpty() ? "and  u.description like :description" : "");

		Query query = entityManager.createQuery(preQuery);

		if (!profileName.isEmpty()) {
			query.setParameter("description", "%" + profileName + "%");
		}

		profiles = query.getResultList();

		return profiles;
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
