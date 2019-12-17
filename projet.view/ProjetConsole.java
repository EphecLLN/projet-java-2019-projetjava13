package projet.view;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import projet.controller.ProjetController;
import projet.model.Bonus;
import projet.model.Cliqueur;

public class ProjetConsole extends ProjetVue implements Observer {
	protected Scanner sc;
	
	
	public ProjetConsole(Bonus model,
			ProjetController controller) {
		super(model, controller);
		update(null, null);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();	
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(model);
		printResume();
	}
	
	private void printResume(){
		model.text();
	}
	
	private class ReadInput implements Runnable{
		public void run() {
			while(true){
			{

				String j = sc.next();
					switch(j){
				case "1" :
					controller.incremente();
					break;
				case "2" : 
					controller.bonusUn();
					break;
				case "3" :
					controller.bonusDeux();
					break;
				case "4" : 
					controller.bonusTrois();
					break;
				case "5":
					controller.bonusQuatre();
					break;
				case "6":
					affiche("Introduisez votre login");
					String sca = sc.next();
					 Cliqueur.login = sca;
					controller.enregistre();
					break;
				case "7":
					controller.resultats();
					break;
				default : 
					System.err.println("Input incorrect");
					printResume();
					break;
					}
				
		}
	}
}
	}
	@Override
	public void affiche(String string) {
		System.out.println(string);
		
	}
}
