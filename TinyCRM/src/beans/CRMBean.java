package beans;

public abstract class CRMBean {
	
	private int id;
	
	public CRMBean(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	protected void setId(int id) {
		this.id = id;
	}
	
	public abstract String getDescription();

}
