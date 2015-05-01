/**
 * 
 */
package model.dal;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.HibernateUtil;

/**
 * @author yxx03
 * @param <T>
 *
 */
public class ModelDAO<T> {
	public final int QUERY_LIMIT = 100;

    public static SessionFactory getSessionFactory() {
        return HibernateUtil.getSessionFactory();
    }

    private T entity;
    private Session session;

    public void beginTransaction() {
        session = ModelDAO.getSessionFactory().getCurrentSession();
        session.beginTransaction();
    }

    public void commit () {
        session.getTransaction().commit();
    }

    public ModelDAO(T entity) {
        this.entity = entity;
    }

    @SuppressWarnings (value="unchecked")
    public List<T> getAll() {
		Criteria crit = session.createCriteria(entity.getClass());
		crit.setMaxResults(QUERY_LIMIT);
		List<T>  oList = crit.list();
        return oList;  
    }

    public void update(T entity) {
        session.update(entity);
    }

    public int insert(T entity) {
        return (Integer) session.save(entity);
    }

    public void delete(T entity) {
        session.delete(entity);
    }

    // This call will issue a warning about the unchecked cast,
    // but we know the value returned will be of the right type because
    // we specify the entity (T) class in the call.
    //
    // Note that "get" will return a null if no value with this id fails
    @SuppressWarnings (value="unchecked")
    public T getById(int id) {
        return (T) session.get(entity.getClass(), id);        
    }
}
