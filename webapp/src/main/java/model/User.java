package model;

/**
 * @author yxx03
 *
 */

public class User {
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
	 * @param id the id to set
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
	 * @param username the username to set
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
	 * @param password the password to set
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
	/**
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		if(role.equals("admin")){
			this.role = 0;
		}else if(role.equals("exam user")){
			this.role = 1;
		}else if(role.equals("question user")){
			this.role = 2;
		}else{
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
	 * @param disabled the disabled to set
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	

	public int getDisabledDbRepresent() {
		if(true == this.disabled){
			return 1;
		}else{
			return 0;
		}
	}
	public void setDbRepresent(int in) {
		if(in == 1){
			this.disabled = false;
		}else{
			this.disabled = false;
		}
	}
	
	

}
