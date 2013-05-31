package au.com.optus.service.tcs.wurfl.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDao<E>{

	@PersistenceContext(name="tcs.persistence.unit")
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void createEntity(E e) {
		try{
			entityManager.persist(e);
			entityManager.flush();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		//		em.flush();
	}

}
