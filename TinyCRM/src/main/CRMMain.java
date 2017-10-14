package main;

import java.awt.EventQueue;
import java.util.HashMap;

import controllers.CRMController;
import controllers.ClientController;
import controllers.ContactController;
import models.CRMModel;
import models.ClientModel;
import models.ContactModel;
import views.CRMView;
import views.ClientView;
import views.ContactView;

public class CRMMain {

	public static CRMView clientView = new ClientView();
	public static CRMModel clientModel = new ClientModel();
	public static CRMController clientController = new ClientController(clientView, clientModel);

	public static CRMView contactView = new ContactView();
	public static CRMModel contactModel = new ContactModel();
	public static CRMController contactController = new ContactController(contactView, contactModel, clientModel);

	private static String currentModule = "Contacts";
	private static CRMView currentView = contactView;

	public static HashMap<String,CRMView> mapModuleToView = new HashMap<String,CRMView>();
	public static HashMap<String,Integer> mapModuleToIndex = new HashMap<String,Integer>();

	public static void main (String[] args) {
		
		contactController.doInit();

		// Map each module name to its corresponding view
		mapModuleToView.put("Contacts", contactView);
		mapModuleToView.put("Clients", clientView);

		mapModuleToIndex.put("Contacts", 0);
		mapModuleToIndex.put("Clients", 1);
		
		switchToModule("Contacts");
		
	}

	public static void switchToModule(String module) {

		CRMView nextView = mapModuleToView.get(module);

		if (nextView != null) {
			nextView.setMessagesLabel(module + "Welcome to TinyCRM: " + module);
			nextView.setModuleSelected(mapModuleToIndex.get(module));
			//currentView.setVisible(false);
			currentView.setMessagesLabel("");
			currentView.setModuleSelected(mapModuleToIndex.get(currentModule));
			currentModule = module;
			currentView = nextView;

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						nextView.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else {
			currentView.setMessagesLabel(module + " Module Not Available Yet");
			currentView.setModuleSelected(mapModuleToIndex.get(currentModule));
		}
	}
}
