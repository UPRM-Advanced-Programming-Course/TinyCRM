package models;

import beans.ContactBean;

public class ContactModel extends CRMModel {

	public ContactModel() {

	}

	@Override
	public void doLeft() {
		System.out.println("ContactModel.doLeft()");
		this.setIndex(Math.max(this.getIndex()-1, 0));
	}

	@Override
	public void doRight() {
		super.doRight();
		System.out.println("ContactModel.doRight()");
	}

	@Override
	public void doEdit() {
		super.doEdit();
		System.out.println("ContactModel.doEdit()");
	}

	@Override
	public void doAdd() {
		System.out.println("ContactModel.doAdd()");
		int id = 1;
		if (this.getCount() > 0) {
			id = ((ContactBean) this.getBean(this.getCount()-1)).getId() + 1;
		}
		this.add(new ContactBean(id));
		this.setIndex(this.getCount() - 1);
	}

	@Override
	public void doDelete() {
		super.doDelete();
		System.out.println("ContactModel.doDelete()");

	}

	@Override
	public void doSave() {
		super.doSave();
		System.out.println("ContactModel.doSavet()");
	}

}
