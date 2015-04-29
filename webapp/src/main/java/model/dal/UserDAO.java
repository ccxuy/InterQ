/**
 * 
 */
package model.dal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

/**
 * @author yxx03
 * @param <T>
 *
 */
public class UserDAO<T> {

    public static SessionFactory getSessionFactory() {
        return HibernateUtil.getSessionFactory();
    }

    private T entity;
    private Session session;

    public void beginTransaction() {
        session = UserDAO.getSessionFactory().getCurrentSession();
        session.beginTransaction();
    }

    public void commit () {
        session.getTransaction().commit();
    }

    public UserDAO(T entity) {
        this.entity = entity;
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
