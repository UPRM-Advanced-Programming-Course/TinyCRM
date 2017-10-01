package models;

import java.util.ArrayList;

import beans.ContactBean;

public class ContactModel extends CRMModel {
	
	public static ArrayList<ContactBean> list = new ArrayList<ContactBean>();
	public static int index =-1; // Empty list
	
	@Override
	public void doLeft() {
		index = Math.max(index-1, 0);
	}

	@Override
	public void doRight() {
		index = Math.min(index+1, list.size());
	}

	@Override
	public void doEdit() {
		// For now all done by controller
	}

	@Override
	public void doAdd() {
		int id = list.get(list.size()-1).getId() + 1;
		list.add(new ContactBean(id));
		index = list.size() - 1;
	}

	@Override
	public void doDelete() {
		list.remove(index);
		index = Math.max(0, index-1);
	}

	@Override
	public void doSave() {
		//  For now no DB used
	}

}
