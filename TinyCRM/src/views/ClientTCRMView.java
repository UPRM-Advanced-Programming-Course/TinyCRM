package views;

public interface ClientTCRMView extends TCRMView {

	String getTextId();

	void setTextId(String textId);

	String getTextCompany();

	void setTextCompany(String textCompany);

	String getTextTelephone();

	void setTextTelephone(String textTelephoe);

	String getTextEmail();

	void setTextEmail(String textEmail);

	String getTextWebsite();

	void setTextWebsite(String textWebsite);

	String getTextFacebook();

	void setTextFacebook(String textFacebook);

	String getErrorCompany();

	void setErrorCompany(String errorCompany);

	String getErrorTelephone();

	void setErrorTelephone(String errorFirstName);

	String getErrorEmail();

	void setErrorEmail(String errorEmail);

	String getErrorWebsite();

	void setErrorWebsite(String errorWebsite);

	String getErrorFacebook();

	void setErrorFacebook(String errorFacebook);

}