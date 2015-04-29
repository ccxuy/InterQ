package model;

/**
 * @author yxx03
 * 
 */

public class User {
	public static final String ROLE_ADMIN = "admin"; // 0
	public static final String ROLE_EXAM_USER = "exam user"; // 1
	public static final String ROLE_QUESTION_USER = "question user"; // 2
	int id;
	String username;
	String password;
	int role;
	boolean disabled = false;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public int getRole() {
		return role;
	}

	public boolean isRoleAdmin() {
		return this.role == 0 ? true : false;
	}

	public boolean isRoleExamUser() {
		return this.role == 1 ? true : false;
	}

	public boolean isRoleQuestionUser() {
		return this.role == 2 ? true : false;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(String role) {
		if (role.equals(ROLE_ADMIN)) {
			this.role = 0;
		} else if (role.equals(ROLE_EXAM_USER)) {
			this.role = 1;
		} else if (role.equals(ROLE_QUESTION_USER)) {
			this.role = 2;
		} else {
			this.role = -1;
		}
	}

	/**
	 * @return the disabled
	 */
	public boolean isDisabled() {
		return disabled;
	}

	/**
	 * @param disabled
	 *            the disabled to set
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

}
