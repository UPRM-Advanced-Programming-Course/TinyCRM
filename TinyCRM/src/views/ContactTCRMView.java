package views;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import beans.CRMBean;
import beans.ClientBean;

public interface ContactTCRMView extends TCRMView {

	String getTextId();

	void setTextId(String textId);

	String getTextFirstName();

	void setTextFirstName(String textFirstName);

	String getTextLastName();

	void setTextLastName(String textLastName);

	String getTextCompany();

	void setTextCompany(String textCompany);

	ClientBean getSelectedComboBoxClient();

	void setSelectedComboBoxClient(ClientBean b);

	void setComboBoxClientItems(ArrayList<CRMBean> list);

	void setComboBoxClientListener(ActionListener listener);

	String getTextTelephone();

	void setTextTelephone(String textTelephoe);

	String getTextEmail();

	void setTextEmail(String textEmail);

	String getTextFacebook();

	void setTextFacebook(String textFacebook);

	String getErrorFirstName();

	void setErrorFirstName(String errorFirstName);

	String getErrorLasttName();

	void setErrorLastName(String errorLastName);

	String getErrorCompany();

	void setErrorCompany(String errorCompany);

	String getErrorTelephone();

	void setErrorTelephone(String errorTelephone);

	String getErrorEmail();

	void setErrorEmail(String errorEmail);

	String getErrorFacebook();

	void setErrorFacebook(String errorFacebok);

}