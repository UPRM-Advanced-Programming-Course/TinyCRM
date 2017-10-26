package controllers;

import java.util.Map;

import exceptions.InvalidFormFieldData;
import models.CRMModel;
import swingViews.ClientSwingView;
import swingViews.SwingView;
import views.ClientTCRMView;

public class ClientController extends CRMController {

	public ClientController(SwingView view, CRMModel model) {
		super(view, model);
	}

	public void doLeft() {
		System.out.println("ClientController.doLeft()");
		super.doLeft();
	}

	public void doRight() {
		System.out.println("ClientController.doRight()");
		super.doRight();
	}

	public void doEdit() {
		System.out.println("ClientController.doRight()");
		super.doEdit();
	}

	public void doAdd() {
		System.out.println("ClientController.doAdd()");
		super.doAdd();
	}

	public void doDelete() {
		System.out.println("ClientController.doDelete()");
		super.doDelete();
	}

	public void doSave() {
		System.out.println("ClientController.doSave()");
		super.doSave();
	}

	public void validateForm() throws InvalidFormFieldData {
		getValidationErrors().clear();
		validateCompany();
		validateTelephone();
		validateEmail();
		validateWebsite();
		validateFacebook();
		if (getValidationErrors().size() > 0)
			throw new InvalidFormFieldData ("Invalid Form");
	}

	public void validateCompany() {
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextCompany().trim().length() == 0) {
			addValidationError("Company", "Empty Company. Required Field.");
		}
	}
	
	public void validateTelephone() {
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextTelephone().trim().length() == 0) {
			addValidationError("Telephone", "Empty Telephone. Required Field.");
		}
	}
	public void validateEmail() {
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextEmail().trim().length() == 0) {
			addValidationError("Email", "Empty Email. Required Field.");
		}
	}
	public void validateWebsite() {
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextWebsite().trim().length() == 0) {
			addValidationError("Website", "Empty Website. Required Field.");
		}
	}
	public void validateFacebook() {
		ClientTCRMView view = (ClientTCRMView) getView();
		if (view.getTextFacebook().trim().length() == 0) {
			addValidationError("Facebook", "Empty Facebook. Required Field.");
		}
	}
	
	protected void refreshView() {
		super.refreshView();
		String errorString = "";
		ClientSwingView cv = (ClientSwingView) getView();
		cv.clearFieldErrors();
		Map<String, String> validationErrors = getValidationErrors();
		if (validationErrors.size() > 0) {
			errorString = "Fields in red are invalid";
			if (validationErrors.containsKey("Company")) { cv.setErrorCompany(validationErrors.get("Company")); }
			if (validationErrors.containsKey("Telephone")) { cv.setErrorTelephone(validationErrors.get("Telephone")); }
			if (validationErrors.containsKey("Email")) { cv.setErrorEmail(validationErrors.get("Email")); }
			if (validationErrors.containsKey("Website")) { cv.setErrorWebsite(validationErrors.get("Website")); }
			if (validationErrors.containsKey("Facebook")) { cv.setErrorFacebook(validationErrors.get("Facebook")); }
		}
		cv.setMessagesText(errorString);
	}

	public void refreshDropdowns() {}
	
}
