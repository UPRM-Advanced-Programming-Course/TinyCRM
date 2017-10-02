package main;

import java.awt.EventQueue;

import controllers.CRMController;
import controllers.ContactController;
import models.CRMModel;
import models.ContactModel;
import views.CRMView;
import views.ContactView;

public class CRMMain {
	
	public static void main (String[] args) {
		
		CRMView view = new ContactView();
		CRMModel model = new ContactModel();
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
