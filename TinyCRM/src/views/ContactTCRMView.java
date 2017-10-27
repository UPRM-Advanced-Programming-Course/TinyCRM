package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import beans.CRMBean;
import beans.ClientBean;

public interface ContactTCRMView extends TCRMView {

	String getTextId();
	String getTextFirstName();
	String getTextLastName();
	String getTextCompany();
	String getTextTelephone();
	String getTextEmail();
	String getTextFacebook();
	
	void setTextId(String textId);
	void setTextFirstName(String textFirstName);
	void setTextLastName(String textLastName);
	void setTextCompany(String textCompany);
	void setTextTelephone(String textTelephoe);
	void setTextEmail(String textEmail);
	void setTextFacebook(String textFacebook);

	// TODO: Verify MVC compliance of these methods
	int getSelectedClientIndex();
	void setSelectedClientIndex(int index);
	void setSelectClientItems(ArrayList<CRMBean> list);
	void setSelectClientListener(ActionListener listener);
	
	String getErrorFirstName();
	String getErrorLasttName();
	String getErrorCompany();
	String getErrorTelephone();
	String getErrorEmail();
	String getErrorFacebook();
	
	void setErrorFirstName(String errorFirstName);
	void setErrorLastName(String errorLastName);
	void setErrorCompany(String errorCompany);
	void setErrorTelephone(String errorTelephone);
	void setErrorEmail(String errorEmail);
	void setErrorFacebook(String errorFacebok);

}