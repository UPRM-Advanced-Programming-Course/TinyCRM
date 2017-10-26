package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import exceptions.InvalidFormFieldData;
import main.CRMMain;
import models.CRMModel;
import models.ClientModel;
import swingViews.ContactSwingView;
import swingViews.SwingView;
import views.ContactTCRMView;

public class ContactController extends CRMController {

	public ContactController(SwingView contactView, CRMModel contactModel, CRMModel clientModel) {
		super(contactView, contactModel);

		ContactSwingView cv = (ContactSwingView) contactView;
		//ContactModel cm = (ContactModel) contactModel;
		ClientModel clientModel2 = (ClientModel) clientModel;

		cv.setComboBoxClientItems(clientModel2.getAllBeans());
		cv.clearFieldErrors();
		cv.setComboBoxClientListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Client Combo Box Selected");
			}
		});
	}

	public void doLeft() {
		System.out.println("ContactController.doLeft()");
		super.doLeft();
	}

	public void doRight() {
		System.out.println("ContactController.doRight()");
		super.doRight();
	}

	public void doEdit() {
		System.out.println("ContactController.doRight()");
		super.doEdit();
	}

	public void doAdd() {
		System.out.println("ContactController.doAdd()");
		refreshDropdowns();
		super.doAdd();
	}

	public void doDelete() {
		System.out.println("ContactController.doDelete()");
		super.doDelete();
	}

	public void doSave() {
		System.out.println("ContactController.doSave()");
		super.doSave();
	}

	public void doSelectClient() {
		this.refreshView();
	}

	public void validateForm() throws InvalidFormFieldData {
		getValidationErrors().clear();
		validateFirstName();
		validateLastName();
		validateCompany();
		validateTelephone();
		validateEmail();
		validateFacebook();
		if (getValidationErrors().size() > 0)
			throw new InvalidFormFieldData ("Invalid Form");
	}

	public void validateFirstName() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		if (view.getTextFirstName().trim().length() == 0) {
			addValidationError("FirstName", "Empty First Name. Required Field.");
		}
	}
	public void validateLastName() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		if (view.getTextLastName().trim().length() == 0) {
			addValidationError("LastName", "Empty Last Name. Required Field.");
		}
	}	
	public void validateCompany() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		if (view.getTextCompany().trim().length() == 0) {
			addValidationError("Company", "Empty Company. Required Field.");
		}
	}	
	public void validateTelephone() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		if (view.getTextTelephone().trim().length() == 0) {
			addValidationError("Telephone", "Empty Telephone. Required Field.");
		}
	}
	public void validateEmail() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		if (view.getTextEmail().trim().length() == 0) {
			addValidationError("Email", "Empty Email. Required Field.");
		}
	}
	public void validateFacebook() throws InvalidFormFieldData {
		ContactTCRMView view = (ContactTCRMView) getView();
		if (view.getTextFacebook().trim().length() == 0) {
			addValidationError("Facebook", "Empty Facebook. Required Field.");
		}
	}

	public void refreshDropdowns() {
		ContactTCRMView cv = (ContactTCRMView) getView();
		cv.setComboBoxClientItems(CRMMain.clientModel.getAllBeans());
	}

	protected void refreshView() {
		super.refreshView();
		String errorString = "";
		ContactSwingView cv = (ContactSwingView) getView();
		cv.clearFieldErrors();
		Map<String, String> validationErrors = getValidationErrors();
		if (validationErrors.size() > 0) {
			errorString = "Fields in red are invalid";
			if (validationErrors.containsKey("FirstName")) { cv.setErrorFirstName(validationErrors.get("FirstName")); }
			if (validationErrors.containsKey("LastName")) { cv.setErrorLastName(validationErrors.get("LastName")); }
			if (validationErrors.containsKey("Company")) { cv.setErrorCompany(validationErrors.get("Company")); }
			if (validationErrors.containsKey("Telephone")) { cv.setErrorTelephone(validationErrors.get("Telephone")); }
			if (validationErrors.containsKey("Email")) { cv.setErrorEmail(validationErrors.get("Email")); }
			if (validationErrors.containsKey("Facebook")) { cv.setErrorFacebook(validationErrors.get("Facebook")); }
		}
		cv.setMessagesText(errorString);
	}

}

