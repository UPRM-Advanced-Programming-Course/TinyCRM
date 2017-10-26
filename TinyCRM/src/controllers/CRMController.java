package controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.swing.JOptionPane;

import exceptions.InvalidFormFieldData;
import models.CRMModel;
import views.TCRMView;

public abstract class CRMController {

	private CRMModel model;
	private TCRMView view;

	private Map<String, String> validationErrors = new HashMap<String, String>();

	private boolean currentBeanIsNew = false;
	
	private Consumer<String> switchModuleListener = null;

	public CRMController(TCRMView crmView, CRMModel crmModel) {
		this.view = crmView;
		this.model = crmModel;

		this.view.setModuleSelectionListener(() -> doSelectModule());
		
		this.view.setLeftButtonListener(()   -> doLeft());
		this.view.setRightButtonListener(()  -> doRight());
		this.view.setEditButtonListener(()   -> doEdit());
		this.view.setAddButtonListener(()    -> doAdd());
		this.view.setDeleteButtonListener(() -> doDelete());
		this.view.setSaveButtonListener(()   -> doSave());
		this.view.setCancelButtonListener(() -> doCancel());

		refreshView();
		//view.setMessagesText("Welcome to TinyCRM: Contacts");

	}

	public CRMModel getModel() {
		return model;
	}

	public void setModel(CRMModel model) {
		this.model = model;
	}

	public TCRMView getView() {
		return view;
	}

	public void setView(TCRMView view) {
		this.view = view;
	}
	
	public void doInit() {
		model.doInit();
		view.beanToForm(model.getCurrentBean());
	}

	public void doLeft() {
		System.out.println("CRMController.doLeft()");
		if (getModel().getIndex() > 0) {
			this.getModel().doLeft();
			if (model.getCount() > 0) {
				view.beanToForm(model.getCurrentBean());
			}
		}
		this.refreshView();
	};

	public void doRight() {
		System.out.println("CRMController.doRight()");
		this.getModel().doRight();
		if (model.getCount() > 0) {
			view.beanToForm(model.getCurrentBean());
		}
		this.refreshView();
	};

	public void doEdit() {
		System.out.println("CRMController.doEdit()");
		view.enableEditMode();
		this.getModel().doEdit();		
		this.refreshView();
		view.setMessagesText("Edit Current Record and Click Save or Cancel");
	};

	public void doAdd() {
		System.out.println("CRMController.doAdd()");
		this.getModel().doAdd();
		currentBeanIsNew = true;
		view.beanToForm(model.getCurrentBean());
		this.doEdit();
		view.setMessagesText("Edit Current Record and Click Save or Cancel");
	};

	public void doDelete() {
		System.out.println("CRMController.doDelete()");
		int sureToDelete = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete ths record?", "Warning!", JOptionPane.YES_NO_OPTION);
		System.out.println("Sure to Delete =" + sureToDelete);
		if (sureToDelete == 0) {
			this.getModel().doDelete();
			if (model.getCount() == 0) {
				view.clearForm();
			}
			else {
				view.beanToForm(model.getCurrentBean());
			}
			this.refreshView();
			view.setMessagesText("Record Deleted Successfully");
		}
		else {
			this.refreshView();
			view.setMessagesText("Record Not Deleted");
		}
	};

	public void doSave() {
		System.out.println("CRMController.doSave()");
		// Validate form data
		view.clearFieldErrors();
		try {
			this.validateForm();
			view.formToBean(model.getCurrentBean());
			this.getModel().doSave();
			currentBeanIsNew = false;
			view.disableEditMode();
			this.refreshView();
			view.setMessagesText("Record Saved Successfully");
		}
		catch (InvalidFormFieldData e) {
			this.refreshView();
		}
	};

	public void doCancel() {
		System.out.println("CRMController.doCancel()");
		view.disableEditMode();
		this.getModel().doCancel();
		if (currentBeanIsNew) {
			this.getModel().doDelete();
		}
		if (model.getCount() > 0) {
			view.beanToForm(model.getCurrentBean());
		}
		else {
			view.clearForm();
		}
		validationErrors.clear();
		this.refreshView();
	}
	
	public void setSwitchModuleListener(Consumer <String> f) {
		switchModuleListener = f;
	}

	public void doSelectModule() {
		String selection = view.getModuleSelected();
		this.refreshView();
		switchModuleListener.accept(selection);
	}

	protected void refreshView() {
		System.out.println("Refreshing View Info");
		view.updateIndexCount(model.getIndex(), model.getCount());
		view.disableLeftButton();
		view.disableRightButton();
		view.disableEditButton();
		view.disableAddButton();
		view.disableDeleteButton();
		view.disableSaveButton();
		view.disableCancelButton();
		if (view.inEditMode()) {
			view.enableSaveButton();
			view.enableCancelButton();
		}
		else {
			if (model.getIndex() > 0) view.enableLeftButton();
			if ((model.getCount() > 0) && (model.getIndex() < model.getCount()-1)) view.enableRightButton();
			if (model.getCount()>0) view.enableEditButton();
			view.enableAddButton();
			if (model.getCount()>0) view.enableDeleteButton();
		}
	}

	public abstract void validateForm() throws InvalidFormFieldData;

	public abstract void refreshDropdowns();

	public void clearValidationErrors() {
		validationErrors.clear();
	}

	public Map<String,String> getValidationErrors() {
		return validationErrors;
	}

	public void addValidationError(String fieldName, String msg) {
		validationErrors.put(fieldName, msg);
	}

}
