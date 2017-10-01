package views;

import java.awt.event.MouseAdapter;

import javax.swing.JFrame;

import beans.CRMBean;

public abstract class CRMView extends JFrame {

	private static final long serialVersionUID = 1L;

	private MouseAdapter leftAdapter;
	private MouseAdapter rightAdapter;
	private MouseAdapter editAdapter;
	private MouseAdapter addAdapter;
	private MouseAdapter deleteAdapter;
	private MouseAdapter saveAdapter;
	
	public MouseAdapter getLeftAdapter() {
		return leftAdapter;
	}

	public void setLeftAdapter(MouseAdapter leftAdapter) {
		this.leftAdapter = leftAdapter;
	}

	public MouseAdapter getRightAdapter() {
		return rightAdapter;
	}

	public void setRightAdapter(MouseAdapter rightAdapter) {
		this.rightAdapter = rightAdapter;
	}

	public MouseAdapter getEditAdapter() {
		return editAdapter;
	}

	public void setEditAdapter(MouseAdapter editAdapter) {
		this.editAdapter = editAdapter;
	}

	public MouseAdapter getAddAdapter() {
		return addAdapter;
	}

	public void setAddAdapter(MouseAdapter addAdapter) {
		this.addAdapter = addAdapter;
	}

	public MouseAdapter getDeleteAdapter() {
		return deleteAdapter;
	}

	public void setDeleteAdapter(MouseAdapter deleteAdapter) {
		this.deleteAdapter = deleteAdapter;
	}

	public MouseAdapter getSaveAdapter() {
		return saveAdapter;
	}

	public void setSaveAdapter(MouseAdapter saveAdapter) {
		this.saveAdapter = saveAdapter;
	}
	
	public abstract void display(CRMBean bean);
}
