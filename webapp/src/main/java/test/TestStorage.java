/**
 * 
 */
package test;

import model.User;
import model.dal.UserDAO;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yxx03
 *
 */
public class TestStorage {

    @Test
    public void testWrite() {
        // Just a write, verify id set
        User user = new User();
        UserDAO<User> userDao = new UserDAO<User>(user);
        userDao.beginTransaction();
        user.setRole("admin");
        userDao.insert(user);
        assertNotNull(user.getId());
        userDao.commit();
    }
    
}
