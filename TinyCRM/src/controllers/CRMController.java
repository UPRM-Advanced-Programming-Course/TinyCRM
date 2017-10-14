package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import exceptions.InvalidFormFieldData;
import main.CRMMain;
import models.CRMModel;
import views.CRMView;

public abstract class CRMController {

	private CRMModel model;
	private CRMView view;

	private Map<String, String> validationErrors = new HashMap<String, String>();

	private boolean currentBeanIsNew = false;

	public CRMController(CRMView crmView, CRMModel crmModel) {
		this.view = crmView;
		this.model = crmModel;

		this.view.setModuleComboBoxListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Combo Box Selected");
				doSelectModule();
			}
		});

		this.view.setModuleComboBoxModel(new String[] {"Contacts", "Clients", "Opportunities", "Reports"});

		this.view.setLeftAdapter(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doLeft();
			}
		});
		this.view.setRightAdapter(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doRight();
			}
		});
		this.view.setEditAdapter(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doEdit();
			}
		});
		this.view.setAddAdapter(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doAdd();
			}
		});
		this.view.setDeleteAdapter(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doDelete();
			}
		});
		this.view.setSaveAdapter(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doSave();
			}
		});
		this.view.setCancelAdapter(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doCancel();
			}
		});

		refreshView();
		view.setMessagesLabel("Welcome to TinyCRM: Contacts");

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
		view.setMessagesLabel("Edit Current Record and Click Save or Cancel");
	};

	public void doAdd() {
		System.out.println("CRMController.doAdd()");
		this.getModel().doAdd();
		currentBeanIsNew = true;
		view.beanToForm(model.getCurrentBean());
		this.doEdit();
		view.setMessagesLabel("Edit Current Record and Click Save or Cancel");
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
			view.setMessagesLabel("Record Deleted Successfully");
		}
		else {
			this.refreshView();
			view.setMessagesLabel("Record Not Deleted");
		}
	};

	public void doSave() {
		System.out.println("CRMController.doSave()");
		// Validate form data
		view.clearFieldErrors();
		try {
			validateForm();
			view.formToBean(model.getCurrentBean());
			this.getModel().doSave();
			currentBeanIsNew = false;
			view.disableEditMode();
			this.refreshView();
			view.setMessagesLabel("Record Saved Successfully");
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

	public void doSelectModule() {
		String selection = view.getModuleSelected();
		this.refreshView();
		CRMMain.switchToModule(selection);
		//		if (!selection.equals("Contacts")) {
		//			view.setMessagesLabel(selection + " Module Not Available Yet");
		//			view.setModuleSelected("Contacts");
		//		}
		//		else {
		//			view.setMessagesLabel(selection + "Welcome to TinyCRM: Contacts");
		//			view.setModuleSelected("Contacts");
		//		}
	}

	public void refreshView() {
		System.out.println("Refreshing View Info");
//		if (model.getCount() > 0) {
//			this.getView().beanToForm(this.getModel().getCurrentBean());
//		}
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
//		String errorString = "";
//		Map<String,String> validationErrors = getValidationErrors();
//		view.clearFieldErrors();
//		if (validationErrors.size()>0) {
//			C
//			view.setErrorFirstName("");
//		}
//		view.setMessagesLabel(errorString);
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
