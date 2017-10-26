package models;

import java.util.ArrayList;

import beans.CRMBean;

public abstract class CRMModel {
	
	private ArrayList<CRMBean> list = new ArrayList<CRMBean>();
	private int index =-1; // Empty list

	public void doInit() {
		
	}
	
	public void doLeft() {
		System.out.println("CRMModel.doLeft()");
		this.setIndex(Math.max(this.getIndex()-1, 0));
	};
	
	public void doRight() {
		System.out.println("CRMModel.doRight()");
		index = Math.min(index+1, list.size()-1);
	}

	public void doEdit() {
		System.out.println("CRMModel.doEdit()");
		// For now all done by controller
	}
	
	public abstract void doAdd();  // Needs to call specific bean constructor
	
	public void doDelete() {
		System.out.println("CRMModel.doDelete()");
		list.remove(index);
		index = index-1;
	}
	
	public void doSave() {
		System.out.println("CRMModel.doSave()");
		// TODO: Save records permanently in file or DB
	}
		
	public void doCancel() {
		System.out.println("CRMModel.doCancel()");
	}

	public CRMBean getBean(int i) { return list.get(i); }
	
	public CRMBean getCurrentBean() { return list.get(index); }
	
	public ArrayList<CRMBean> getAllBeans() {
		return list;
	}
		
	public int getCount() { return list.size(); }
	
	public int getIndex() { return index; }
	
	public void setIndex(int index) { this.index = index; }
	
	public void add(CRMBean b) { list.add(b); }
	
	public ArrayList<CRMBean> getList() {
		return list;
	}
	
}
