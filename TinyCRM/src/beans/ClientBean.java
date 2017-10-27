package beans;

public class ClientBean extends CRMBean {

	private String company;
	private String telephone;
	private String email;
	private String website;
	private String facebook;
	
	public ClientBean(int id) {
		super(id);
		company = "";
		telephone = "";
		email = "";
		facebook = "";
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	
	public String getDescription() {
		return company;
	}
	
	public String toString() {
		return this.getId() + ": " + this.getCompany();
	}
	
}
