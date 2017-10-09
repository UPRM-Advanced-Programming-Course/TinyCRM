package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import exceptions.InvalidFormFieldData;
import main.CRMMain;
import models.CRMModel;
import models.ContactModel;
import views.CRMView;
import views.ContactView;

public class ContactController extends CRMController {

	private static final ArrayList<String> emptyErrors = new ArrayList<String>();

	public ContactController(CRMView view, CRMModel model) {
		super(view, model);


		ContactView cv = (ContactView) view;
		ContactModel cm = (ContactModel) model;

		cv.setComboBoxClientItems(cm.getAllBeans());
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
		this.refreshView(emptyErrors);
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
		ContactView view = (ContactView) getView();
		if (view.getTextFirstName().trim().length() == 0) {
			addValidationError("FirstName", "Empty First Name. Required Field.");
		}
	}
	public void validateLastName() throws InvalidFormFieldData {
		ContactView view = (ContactView) getView();
		if (view.getTextLastName().trim().length() == 0) {
			addValidationError("LastName", "Empty Last Name. Required Field.");
		}
	}	
	public void validateCompany() throws InvalidFormFieldData {
		ContactView view = (ContactView) getView();
		if (view.getTextCompany().trim().length() == 0) {
			addValidationError("Company", "Empty Company. Required Field.");
		}
	}	
	public void validateTelephone() throws InvalidFormFieldData {
		ContactView view = (ContactView) getView();
		if (view.getTextTelephone().trim().length() == 0) {
			addValidationError("Telephone", "Empty Telephone. Required Field.");
		}
	}
	public void validateEmail() throws InvalidFormFieldData {
		ContactView view = (ContactView) getView();
		if (view.getTextEmail().trim().length() == 0) {
			addValidationError("Email", "Empty Email. Required Field.");
		}
	}
	public void validateFacebook() throws InvalidFormFieldData {
		ContactView view = (ContactView) getView();
		if (view.getTextFacebook().trim().length() == 0) {
			addValidationError("Facebook", "Empty Facebook. Required Field.");
		}
	}

	public void refreshDropdowns() {
		ContactView cv = (ContactView) getView();
		cv.setComboBoxClientItems(CRMMain.clientModel.getAllBeans());
	}

	public void refreshView(ArrayList<String> errors) {
		super.refreshView(errors);
		String errorString = "";
		ContactView cv = (ContactView) getView();
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
		cv.setMessagesLabel(errorString);
	}

}

