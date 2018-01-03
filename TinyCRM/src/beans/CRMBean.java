package beans;

public abstract class CRMBean {
	
	private long id;  // Unique ID among all beans of a given type
	
	public CRMBean(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
	protected void setId(long id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return A descriptive String that could be used for isntance in a drop-down menu
	 */
	public abstract String getDescription();

}
