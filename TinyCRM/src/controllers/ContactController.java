package controllers;

import java.util.ArrayList;

import models.CRMModel;
import views.CRMView;
import views.ContactView;

public class ContactController extends CRMController {

	public ContactController(CRMView view, CRMModel model) {
		super(view, model);
	}

	public ArrayList<String> doLeft() {
		System.out.println("ContactController.doLeft()");
		return super.doLeft();
	}

	public ArrayList<String> doRight() {
		System.out.println("ContactController.doRight()");
		return super.doRight();
	}

	public ArrayList<String> doEdit() {
		System.out.println("ContactController.doRight()");
		return super.doEdit();
	}

	public ArrayList<String> doAdd() {
		System.out.println("ContactController.doAdd()");
		return super.doAdd();
	}

	public ArrayList<String> doDelete() {
		System.out.println("ContactController.doDelete()");
		return super.doDelete();
	}

	public ArrayList<String> doSave() {
		System.out.println("ContactController.doSave()");
		return super.doSave();
	}

	public ArrayList<String> validateForm() {
		ArrayList<String> errors = new ArrayList<String>();
		String error;
		error = validateFirstName();
		if (error != null) errors.add(error);
		error = validateLastName();
		if (error != null) errors.add(error);
		error = validateCompany();
		if (error != null) errors.add(error);
		error = validateTelephone();
		if (error != null) errors.add(error);
		error = validateEmail();
		if (error != null) errors.add(error);
		error = validateFacebook();
		if (error != null) errors.add(error);
		return errors;
	}

	public String validateFirstName() {
		ContactView view = (ContactView) getView();
		if (view.getTextFirstName().length() == 0) {
			return "Empty FirstName";
		}
		return null;
	}
	public String validateLastName() {
		ContactView view = (ContactView) getView();
		if (view.getTextLastName().length() == 0) {
			return "Empty LastName";
		}
		return null;
	}	
	public String validateCompany() {
		ContactView view = (ContactView) getView();
		if (view.getTextCompany().length() == 0) {
			return "Empty Company";
		}
		return null;
	}	
	public String validateTelephone() {
		ContactView view = (ContactView) getView();
		if (view.getTextTelephone().length() == 0) {
			return "Empty Telephone";
		}
		return null;
	}
	public String validateEmail() {
		ContactView view = (ContactView) getView();
		if (view.getTextEmail().length() == 0) {
			return "Empty Email";
		}
		return null;
	}
	public String validateFacebook() {
		ContactView view = (ContactView) getView();
		if (view.getTextFacebook().length() == 0) {
			return "Empty Facebook";
		}
		return null;
	}
}
