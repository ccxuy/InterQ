package model;

/**
 * @author yxx03
 * 
 */

public class Category {
	int id;
	String name;
	int count;

	public Category() {
		super();
	}

	/**
	 * For retrieve data object use.
	 * @param id
	 */
	public Category(int id) {
		super();
		this.id = id;
	}

	/**
	 * For retrieve data object use.
	 * @param id
	 */
	public Category(String id) {
		super();
		this.id = Integer.parseInt(id);
	}

	public Category(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", count=" + count
				+ "]";
	}
}
