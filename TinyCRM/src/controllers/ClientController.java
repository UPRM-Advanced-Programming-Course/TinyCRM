package controllers;

import java.util.ArrayList;

import models.CRMModel;
import views.CRMView;
import views.ClientView;

public class ClientController extends CRMController {

	public ClientController(CRMView view, CRMModel model) {
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

	public ArrayList<String> validateForm() {
		ArrayList<String> errors = new ArrayList<String>();
		String error;
		error = validateCompany();
		if (error != null) errors.add(error);
		error = validateTelephone();
		if (error != null) errors.add(error);
		error = validateEmail();
		if (error != null) errors.add(error);
		error = validateWebsite();
		if (error != null) errors.add(error);
		error = validateFacebook();
		if (error != null) errors.add(error);
		return errors;
	}

	public String validateCompany() {
		ClientView view = (ClientView) getView();
		if (view.getTextCompany().length() == 0) {
			return "Empty Company";
		}
		return null;
	}	
	public String validateTelephone() {
		ClientView view = (ClientView) getView();
		if (view.getTextTelephone().length() == 0) {
			return "Empty Telephone";
		}
		return null;
	}
	public String validateEmail() {
		ClientView view = (ClientView) getView();
		if (view.getTextEmail().length() == 0) {
			return "Empty Email";
		}
		return null;
	}
	public String validateWebsite() {
		ClientView view = (ClientView) getView();
		if (view.getTextWebsite().length() == 0) {
			return "Empty Website";
		}
		return null;
	}
	public String validateFacebook() {
		ClientView view = (ClientView) getView();
		if (view.getTextFacebook().length() == 0) {
			return "Empty Facebook";
		}
		return null;
	}
	
	public void refreshDropdowns() {}
	
}
