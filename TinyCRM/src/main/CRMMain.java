package main;

import java.awt.EventQueue;
import java.util.HashMap;

import controllers.CRMController;
import controllers.ClientController;
import controllers.ContactController;
import models.CRMModel;
import models.ClientModel;
import models.ContactModel;
import swingViews.ClientSwingView;
import swingViews.ContactSwingView;
import swingViews.SwingView;

public class CRMMain {

	// Create Contacts module MVC objects
	public static SwingView clientView = new ClientSwingView();
	public static CRMModel clientModel = new ClientModel();
	public static CRMController clientController = new ClientController(clientView, clientModel);

	// Create Clients module MVC objects
	public static SwingView contactView = new ContactSwingView();
	public static CRMModel contactModel = new ContactModel();
	// Contacts module has relationship with Clients module so we pass the Clients model object to the Contacts controller
	public static CRMController contactController = new ContactController(contactView, contactModel, clientModel); 
	
	private static String currentModule;
	private static SwingView currentView;

	// mapModuleToView holds the view object for each module
	public static HashMap<String,SwingView> mapModuleToView = new HashMap<String,SwingView>();
	// mapModuleToIndex holds the index in the module selection combo box for each module
	public static HashMap<String,Integer> mapModuleToIndex = new HashMap<String,Integer>();

	public static void main (String[] args) {

		
		contactView.setModuleSelectionItems(new String[] {"Contacts", "Clients", "Opportunities", "Reports"});
		clientView.setModuleSelectionItems(new String[] {"Contacts", "Clients", "Opportunities", "Reports"});

		mapModuleToView.put("Contacts", contactView);
		mapModuleToView.put("Clients", clientView);

		mapModuleToIndex.put("Contacts", 0);
		mapModuleToIndex.put("Clients", 1);
		
		contactController.doInit();
		contactController.setSwitchModuleListener((String s) -> CRMMain.switchToModule(s));


		// TODO: Uncomment when Client module file storage completed
		//clientController.doInit();
		clientController.setSwitchModuleListener((String s) -> CRMMain.switchToModule(s));

		//contactView.setModuleSelected(mapModuleToIndex.get("Contacts"));
		switchToModule("Contacts"); // Initially open the Contacts module

	}

	public static void switchToModule(String module) {

		SwingView nextView = mapModuleToView.get(module);

		if (nextView != null) {
			nextView.setMessagesText("Welcome to TinyCRM: " + module);

			if (currentView != null) {
				currentView.setVisible(false);
			}
			
			currentModule = module;
			currentView = nextView;
			
			SwingView v = currentView;
			
			EventQueue.invokeLater(() -> currentView.setVisible(true));
			
			currentView.setModuleSelected(mapModuleToIndex.get(currentModule));


		}
		else {
			//currentView.setModuleSelected(mapModuleToIndex.get(currentModule));
			currentView.setMessagesText(module + " Module Not Available Yet");
		}
	}
}
