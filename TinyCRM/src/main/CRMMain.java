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

	// Create Contacts module MVC objects
	public static CRMView clientView = new ClientView();
	public static CRMModel clientModel = new ClientModel();
	public static CRMController clientController = new ClientController(clientView, clientModel);

	// Create Clients module MVC objects
	public static CRMView contactView = new ContactView();
	public static CRMModel contactModel = new ContactModel();
	// Contacts module has relationship with Clients module so we pass the Clients model object to the Contacts controller
	public static CRMController contactController = new ContactController(contactView, contactModel, clientModel); 

	private static String currentModule;
	private static CRMView currentView;

	// mapModuleToView holds the view object for each module
	public static HashMap<String,CRMView> mapModuleToView = new HashMap<String,CRMView>();
	// mapModuleToIndex holds the index in the module selection combo box for each module
	public static HashMap<String,Integer> mapModuleToIndex = new HashMap<String,Integer>();

	public static void main (String[] args) {

		contactController.doInit();

		mapModuleToView.put("Contacts", contactView);
		mapModuleToView.put("Clients", clientView);

		mapModuleToIndex.put("Contacts", 0);
		mapModuleToIndex.put("Clients", 1);

		switchToModule("Contacts"); // Initially open the Contacts module

	}

	public static void switchToModule(String module) {

		CRMView nextView = mapModuleToView.get(module);

		if (nextView != null) {
			nextView.setMessagesText(module + "Welcome to TinyCRM: " + module);
			nextView.setModuleSelected(mapModuleToIndex.get(module));
			//currentView.setVisible(false);

			if (currentView != null) {
				currentView.setMessagesText("");
				currentView.setModuleSelected(mapModuleToIndex.get(currentModule));
				currentView.setVisible(false);
			}
			
			currentModule = module;
			currentView = nextView;

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						currentView.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else {
			currentView.setMessagesText(module + " Module Not Available Yet");
			currentView.setModuleSelected(mapModuleToIndex.get(currentModule));
		}
	}
}
