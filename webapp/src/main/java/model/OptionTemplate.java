/**
 * 
 */
package model;

import java.sql.Clob;

/**
 * @author yxx03
 * 
 */
public class OptionTemplate {
	int id;
	Clob optionJSON;

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
	 * @return the optionJSON
	 */
	public Clob getOptionJSON() {
		return optionJSON;
	}

	/**
	 * @param optionJSON
	 *            the optionJSON to set
	 */
	public void setOptionJSON(Clob optionJSON) {
		this.optionJSON = optionJSON;
	}

}
