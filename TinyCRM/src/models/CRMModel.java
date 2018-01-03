package models;

import java.util.ArrayList;

import beans.CRMBean;

public abstract class CRMModel {
	
	private ArrayList<CRMBean> list = new ArrayList<CRMBean>();  // Holds all beans in memory
	private int index =-1; // Index = -1 when empty list of beans 

	/**
	 * Initialize the model
	 */
	public void doInit() {
		
	}
	
	/**
	 * Handle MOVE LEFT action
	 */
	public void doLeft() {
		this.setIndex(Math.max(this.getIndex()-1, 0));
	};
	
	/**
	 * Handle MOVE RIGHT action
	 */
	public void doRight() {
		index = Math.min(index+1, list.size()-1);
	}

	/**
	 * Handle EDIT RECORD action
	 */
	public void doEdit() {
		// For now all done by controller itself. Edit does not trickle down.
	}
	
	/**
	 * Handle ADD RECORD action. Requires creating new bean 
	 */
	public abstract void doAdd();  // Needs to call specific bean constructor
	
	/**
	 * Handle DELETE RECORD action
	 */
	public void doDelete() {
		// TODO: Verify that integrity is preserved before deleting. E.g. dangling references
		list.remove(index);
		index = index-1;
	}
	
	/**
	 * Handle SAVE RECORD action
	 */
	public void doSave() {

	}
	
	/**
	 * Handle CANCEL (Edit) Action
	 */
	public void doCancel() {

	}

	/**
	 * Returns the ith Bean in the list
	 * @param i Index of bean requested
	 * @return Bean with given index
	 */
	protected CRMBean getBean(int i) { return list.get(i); }
	
	/**
	 * Returns the "current" (displayed) bean in the list
	 * @return Current bean
	 */
	public CRMBean getCurrentBean() { return list.get(index); }
	
	/**
	 * Returns all the beans
	 * @return ArrayList holding all beans
	 */
	public ArrayList<CRMBean> getAllBeans() {
		return list;
	}
	
	/**
	 * Returns current number of beans in list
	 * @return Number of beans
	 */
	public int getCount() { return list.size(); }
	
	/** 
	 * Returns current bean index
	 * @return Current index
	 */
	public int getIndex() { return index; }
	
	/**
	 * Sets index of current bean to i
	 * @param Desired bean index
	 */
	protected void setIndex(int index) { this.index = index; }
	
	/**
	 * Add a bean to the list
	 * @param b Bean to be added
	 */
	protected void setList(ArrayList<CRMBean> l) { list = l; }
	
	/**
	 * Load beans from a file
	 * @param Name of file to load beans from
	 * @return List of beans
	 */
	protected abstract ArrayList<CRMBean> parseBeansFromFile(String filename);
	
	/**
	 * Saves beans to a file
	 * @param Name of file to save beans into
	 */
	protected abstract void saveBeansToFile(String filename);
	
}
