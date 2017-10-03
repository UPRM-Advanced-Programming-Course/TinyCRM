package models;

import java.util.ArrayList;

import beans.CRMBean;

public abstract class CRMModel {
	
	private ArrayList<CRMBean> list = new ArrayList<CRMBean>();
	private int index =-1; // Empty list

	public void doLeft() {
		this.setIndex(Math.max(this.getIndex()-1, 0));
	};
	
	public void doRight() {
		index = Math.min(index+1, list.size()-1);
	}

	public void doEdit() {
		// For now all done by controller
	}
	
	public abstract void doAdd();
	
	public void doDelete() {
		list.remove(index);
		index = index-1;
	}
	
	public void doSave() {
		
	}
		
	public void doCancel() {
	}

	public CRMBean getBean(int i) { return list.get(i); }
	
	public CRMBean getCurrentBean() { return list.get(index); }
		
	public int getCount() { return list.size(); }
	
	public int getIndex() { return index; }
	
	public void setIndex(int index) { this.index = index; }
	
	public void add(CRMBean b) {
		list.add(b);
	}

}
