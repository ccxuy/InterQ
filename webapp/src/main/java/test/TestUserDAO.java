/**
 * 
 */
package test;

import model.User;
import model.dal.ModelDAO;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yxx03
 * 
 */
public class TestUserDAO {

	@Test
	public void testWrite() {
		// Just a write, verify id set
		User user = new User();
		ModelDAO<User> userDao = new ModelDAO<User>(user);
		userDao.beginTransaction();
		user.setRole("admin");
		assertEquals(user.getId(), 0);
		userDao.insert(user);
		assertTrue(user.getId() > 0);
		userDao.commit();
	}

	@Test
	public void testWriteAndRead() {

		// Write
		User user = new User();
		ModelDAO<User> userDao = new ModelDAO<User>(user);
		userDao.beginTransaction();
		user.setRole("exam user");
		assertEquals(user.getId(), 0);
		userDao.insert(user);
		assertTrue(user.getId() > 0);
		int id = user.getId();
		userDao.commit();

		// Read and verify
		User user2 = new User();
		assertTrue(user.isRoleExamUser());
		userDao = new ModelDAO<User>(user2);
		userDao.beginTransaction();
		user2 = userDao.getById(id);
		assertTrue(user2.isRoleExamUser());
		userDao.commit();
	}

	@Test
	public void testUpdate() {

		String overRideRole = User.ROLE_EXAM_USER;
		String newOverrideRole = User.ROLE_QUESTION_USER;

		// Insert an user
		User user = new User();
		ModelDAO<User> userDao = new ModelDAO<User>(user);
		userDao.beginTransaction();
		user.setRole(overRideRole);
		assertEquals(user.getId(), 0);
		userDao.insert(user);
		assertNotNull(user.getId());
		int id = user.getId();
		userDao.commit();

		// Read it back
		User user2 = new User();
		userDao.beginTransaction();
		user2 = userDao.getById(id);
		assertTrue(user2.isRoleExamUser());

		// Update it
		user2.setRole(newOverrideRole);
		userDao.update(user2);
		userDao.commit();

		// Read it again and verify update
		userDao.beginTransaction();
		User user3 = userDao.getById(id);
		assertTrue(user2.isRoleQuestionUser());
		userDao.commit();
	}

	@Test
	public void testDelete() {

		User user = new User();
		ModelDAO<User> userDao = new ModelDAO<User>(user);

		// Write
		userDao.beginTransaction();
		userDao.insert(user);
		int id = user.getId();
		userDao.commit();

		// Delete it now
		assert (user.getId() > 0);
		userDao.beginTransaction();
		userDao.delete(user);
		userDao.commit();

		// Now we can't read it back, as expected
		userDao.beginTransaction();
		User user2 = userDao.getById(id);
		assertNull(user2);
		userDao.commit();
	}

}
