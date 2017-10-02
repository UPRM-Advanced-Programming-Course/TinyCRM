package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import models.CRMModel;
import views.CRMView;

public abstract class CRMController {

	private CRMModel model;
	private CRMView view;

	public CRMController(CRMView crmView, CRMModel crmModel) {
		this.view = crmView;
		this.model = crmModel;
		this.view.setLeftAdapter(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> errors = doLeft();
			}
		});
		this.view.setRightAdapter(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> errors = doRight();
			}
		});
		this.view.setEditAdapter(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> errors = doEdit();
			}
		});
		this.view.setAddAdapter(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> errors = doAdd();
			}
		});
		this.view.setDeleteAdapter(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> errors = doDelete();
			}
		});
		this.view.setSaveAdapter(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<String> errors = doSave();
			}
		});
	}

	public CRMModel getModel() {
		return model;
	}

	public void setModel(CRMModel model) {
		this.model = model;
	}

	public CRMView getView() {
		return view;
	}

	public void setView(CRMView view) {
		this.view = view;
	}

	public ArrayList<String> doLeft() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("CRMController.doLeft()");
		// Validate form data
		boolean formDataValid = true;
		if (formDataValid) this.getModel().doLeft();
		this.getView().display(this.getModel().getCurrentBean());
		this.getView().updateIndexCount(this.getModel().getIndex(), this.getModel().getCount());
		return errors;
	};

	public ArrayList<String> doRight() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("CRMController.doRight()");
		// Validate form data
		boolean formDataValid = true;
		if (formDataValid) this.getModel().doRight();
		this.getView().display(this.getModel().getCurrentBean());
		this.getView().updateIndexCount(this.getModel().getIndex(), this.getModel().getCount());
		return errors;
	};

	public ArrayList<String> doEdit() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("CRMController.doEdit()");
		// Add code to handle action here
		boolean formDataValid = true;
		if (formDataValid) this.getModel().doEdit();
		this.getView().display(this.getModel().getCurrentBean());
		this.getView().updateIndexCount(this.getModel().getIndex(), this.getModel().getCount());
		return errors;
	};

	public ArrayList<String> doAdd() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("CRMController.doAdd()");
		// Validate form data
		boolean formDataValid = true;
		if (formDataValid) this.getModel().doAdd();
		this.getView().display(this.getModel().getCurrentBean());
		this.getView().updateIndexCount(this.getModel().getIndex(), this.getModel().getCount());
		return errors;
	};

	public ArrayList<String> doDelete() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("CRMController.doDelete()");
		// Validate form data
		boolean formDataValid = true;
		if (formDataValid) this.getModel().doDelete();
		this.getView().display(this.getModel().getCurrentBean());
		this.getView().updateIndexCount(this.getModel().getIndex(), this.getModel().getCount());
		return errors;
	};

	public ArrayList<String> doSave() {
		ArrayList<String> errors = new ArrayList<String>();
		System.out.println("CRMController.doSave()");
		// Validate form data
		boolean formDataValid = true;
		if (formDataValid) this.getModel().doSave();
		this.getView().display(this.getModel().getCurrentBean());
		this.getView().updateIndexCount(this.getModel().getIndex(), this.getModel().getCount());
		return errors;

	};
	
}
