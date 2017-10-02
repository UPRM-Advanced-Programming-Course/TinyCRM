package controllers;

import java.util.ArrayList;

import models.CRMModel;
import views.CRMView;

public class ContactController extends CRMController {

	public ContactController(CRMView view, CRMModel model) {
		super(view, model);
	}
	
	public ArrayList<String> doLeft() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("ContactController.doLeft()");
		// Add code to handle action here
		return errors;
	}

	public ArrayList<String> doRight() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("ContactController.doRight()");
		// Add code to handle action here
		return errors;
	}

	public ArrayList<String> doEdit() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("ContactController.doEdit()");
		// Add code to handle action here
		return errors;
	}

	public ArrayList<String> doAdd() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("ContactController.doAdd()");
		// Add code to handle action here
		return errors;
	}

	public ArrayList<String> doDelete() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("ContactController.doDelete()");
		// Add code to handle action here
		return errors;
	}

	public ArrayList<String> doSave() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("ContactController.doSave()");
		// Add code to handle action here
		return errors;
	}
	
}
