package models;

import java.util.ArrayList;

import beans.CRMBean;

public abstract class CRMModel {
	
	private ArrayList<CRMBean> list = new ArrayList<CRMBean>();
	private int index =-1; // Empty list

	public abstract void doLeft();
	
	public void doRight() {		
		index = Math.min(index+1, list.size()-1);
	}

	public void doEdit() {
		// For now all done by controller
	}
	public abstract void doAdd();
	
	public void doDelete() {
		list.remove(index);
		index = Math.max(0, index-1);
	}
	
	public void doSave() {
		
	}
		
	public CRMBean getBean(int i) { return list.get(i); }
	
	public CRMBean getCurrentBean() { return list.get(index); }
		
	public int getCount() { return list.size(); }
	
	public int getIndex() { return index; }
	
	protected void setIndex(int index) { this.index = index; }
	
	public void add(CRMBean b) {
		list.add(b);
	}

}
