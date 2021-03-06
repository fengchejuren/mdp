package myfirst.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

public class BaseDAO  {

	protected Logger logger = Logger.getLogger(getClass());
	
	@PersistenceContext
	protected EntityManager entityManager;
	 
	public <T> T getById(Class<T> clazz,Object id){
		return entityManager.find(clazz, id);
	}
	 
	public void save(Object object){
		entityManager.persist(object);
	}
	
	public void delete(Object o){
		entityManager.remove(o);
	}
}
