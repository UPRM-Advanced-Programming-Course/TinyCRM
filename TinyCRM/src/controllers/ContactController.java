package controllers;

import java.util.ArrayList;

import models.CRMModel;
import views.CRMView;

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
	
}
