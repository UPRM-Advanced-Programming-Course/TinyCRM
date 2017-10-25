package views;

import beans.CRMBean;

public interface TCRMView {

	void setMessagesText(String text);

	String getModuleSelected();
	void setModuleSelected(int index);
	void setModuleSelectionItems(String[] modules);
	void setModuleSelectionListener(Runnable listener);

	void beanToForm(CRMBean bean);
	void formToBean(CRMBean bean);

	void updateIndexCount(int index, int count);

	boolean inEditMode();
	void enableEditMode();
	void disableEditMode();
	
	void setRightButtonListener(Runnable listener);
	void setLeftButtonListener(Runnable listener);
	void setEditButtonListener(Runnable listener);
	void setAddButtonListener(Runnable listener);
	void setDeleteButtonListener(Runnable listener);
	void setSaveButtonListener(Runnable listener);
	void setCancelButtonListener(Runnable listener);
	
	//TODO: Add module selector setter/getter/listener

	void enableLeftButton();
	void enableRightButton();
	void enableEditButton();
	void enableAddButton();
	void enableDeleteButton();
	void enableSaveButton();
	void enableCancelButton();
	
	void disableLeftButton();
	void disableRightButton();
	void disableEditButton();
	void disableAddButton();
	void disableDeleteButton();
	void disableSaveButton();
	void disableCancelButton();
	
	void clearForm();
	void clearFieldErrors();

}