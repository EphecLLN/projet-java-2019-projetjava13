package projet.view;

import java.util.InputMismatchException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import projet.controller.ProjetController;
import projet.model.Cliqueur;

public class ProjetConsole extends ProjetVue implements Observer {
	protected Scanner sc;
	
	
	public ProjetConsole(Cliqueur model,
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
					printResume();
					break;
				case "2" : 
					controller.bonusUn();
					printResume();
					break;
				case "3" :
					controller.bonusDeux();
					printResume();
					break;
				case "4" : 
					controller.bonusTrois();
					printResume();
					break;
				default : 
					affiche("Input incorrect");
					printResume();	
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
