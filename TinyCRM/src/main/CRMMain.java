package main;

import java.awt.EventQueue;

import controllers.CRMController;
import controllers.ContactController;
import models.ContactModel;
import views.ContactView;

public class CRMMain {
	
	public static void main (String[] args) {
		
		ContactView view = new ContactView();
		ContactModel model = new ContactModel();
		CRMController controller = new ContactController(view, model);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
