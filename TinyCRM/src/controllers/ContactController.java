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
		// Validate form data
		boolean formDataValid = true;
		if (formDataValid) this.getModel().doLeft();
		this.getView().display(this.getModel().getCurrentBean());
		this.getView().updateIndexCount(this.getModel().getIndex(), this.getModel().getCount());
		return errors;
	}

	public ArrayList<String> doRight() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("ContactController.doRight()");
		// Validate form data
		boolean formDataValid = true;
		if (formDataValid) this.getModel().doRight();
		this.getView().display(this.getModel().getCurrentBean());
		this.getView().updateIndexCount(this.getModel().getIndex(), this.getModel().getCount());
		return errors;
	}

	public ArrayList<String> doEdit() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("ContactController.doEdit()");
		// Add code to handle action here
		boolean formDataValid = true;
		if (formDataValid) this.getModel().doEdit();
		this.getView().display(this.getModel().getCurrentBean());
		this.getView().updateIndexCount(this.getModel().getIndex(), this.getModel().getCount());
		return errors;
	}

	public ArrayList<String> doAdd() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("ContactController.doAdd()");
		// Validate form data
		boolean formDataValid = true;
		if (formDataValid) this.getModel().doAdd();
		this.getView().display(this.getModel().getCurrentBean());
		this.getView().updateIndexCount(this.getModel().getIndex(), this.getModel().getCount());
		return errors;
	}

	public ArrayList<String> doDelete() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("ContactController.doDelete()");
		// Validate form data
		boolean formDataValid = true;
		if (formDataValid) this.getModel().doDelete();
		this.getView().display(this.getModel().getCurrentBean());
		this.getView().updateIndexCount(this.getModel().getIndex(), this.getModel().getCount());
		return errors;
	}

	public ArrayList<String> doSave() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("ContactController.doSave()");
		// Validate form data
		boolean formDataValid = true;
		if (formDataValid) this.getModel().doSave();
		this.getView().display(this.getModel().getCurrentBean());
		this.getView().updateIndexCount(this.getModel().getIndex(), this.getModel().getCount());
		return errors;
	}
	
}
