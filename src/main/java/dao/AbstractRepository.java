package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class AbstractRepository <E> {
	protected EntityManager em;
	private Class<?> entityClass;
	
	@SuppressWarnings("unchecked")
	public AbstractRepository() {
		em = Persistence.createEntityManagerFactory("PU_AULA").createEntityManager();
		entityClass = (Class<E>)
				   ((ParameterizedType)getClass().getGenericSuperclass())
				      .getActualTypeArguments()[0];
	}
	@SuppressWarnings("unchecked")
	public E find(Object id) {
		Object entity = em.find(entityClass, id);
		return (E) entity;
	}
	public void save(E e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	public void update(E e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	public void delete(Object id) {
		Object entity = find(id);
		if(entity!=null) {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		}
	}
	@SuppressWarnings("unchecked")
	public List<E> list(){
		//Ver sobre JPQL + String.format
		String sql = String.format("SELECT e FROM  %s e", entityClass.getName());
		
		Query query =  em.createQuery(sql);
		
		return query.getResultList();
		
	}

}
