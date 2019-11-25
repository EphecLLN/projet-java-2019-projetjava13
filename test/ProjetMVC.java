package projet.test;

import projet.controller.ProjetController;
import projet.model.Cliqueur;
import projet.view.ProjetConsole;
import projet.view.ProjetGUI;
import projet.view.ProjetVue;

public class ProjetMVC {
	public ProjetMVC() {

	Cliqueur model = new Cliqueur();
	
	ProjetController ctrlConsole = new ProjetController(model);
	ProjetController ctrlGUI = new ProjetController(model);
	
	ProjetVue console = new ProjetConsole(model,ctrlConsole);
	ProjetVue gui = new ProjetGUI(model,ctrlGUI,200,400);
	
	ctrlConsole.addView(console);
	ctrlGUI.addView(gui);
	}
	
	public static void main(String args[]) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ProjetMVC();
			}
		});
	}
	
}
