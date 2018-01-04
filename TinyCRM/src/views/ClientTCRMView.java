package views;

public interface ClientTCRMView extends TCRMView {

	String getTextId();
	String getTextCompany();
	String getTextTelephone();
	String getTextEmail();
	String getTextWebsite();
	String getTextFacebook();
	
	void setTextId(String textId);
	void setTextCompany(String textCompany);
	void setTextTelephone(String textTelephoe);
	void setTextEmail(String textEmail);
	void setTextWebsite(String textWebsite);
	void setTextFacebook(String textFacebook);
	
	String getErrorCompany();
	String getErrorTelephone();
	String getErrorEmail();
	String getErrorWebsite();
	String getErrorFacebook();

	void setErrorCompany(String errorCompany);
	void setErrorTelephone(String errorFirstName);
	void setErrorEmail(String errorEmail);
	void setErrorWebsite(String errorWebsite);
	void setErrorFacebook(String errorFacebook);

}