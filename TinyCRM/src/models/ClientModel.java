package models;

import beans.ClientBean;

public class ClientModel extends CRMModel {

	public ClientModel() {

	}

	@Override
	public void doLeft() {
		super.doLeft();
		System.out.println("ClientModel.doLeft()");
	}

	@Override
	public void doRight() {
		super.doRight();
		System.out.println("ClientModel.doRight()");
	}

	@Override
	public void doEdit() {
		super.doEdit();
		System.out.println("ClientModel.doEdit()");
	}

	@Override
	public void doAdd() {
		System.out.println("ClientModel.doAdd()");
		int id = 1;
		if (this.getCount() > 0) {
			id = ((ClientBean) this.getBean(this.getCount()-1)).getId() + 1;
		}
		this.add(new ClientBean(id));
		this.setIndex(this.getCount() - 1);
	}

	@Override
	public void doDelete() {
		super.doDelete();
		System.out.println("ClientModel.doDelete()");

	}

	@Override
	public void doSave() {
		super.doSave();
		System.out.println("ClientModel.doSavet()");
	}

}
