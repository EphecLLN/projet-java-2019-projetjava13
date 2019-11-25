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
		printHelp();
	}
	
	private void printHelp(){
		model.text();
	}
	
	private class ReadInput implements Runnable{
		public void run() {
			while(true){
			{
				try{
					
				int j = sc.nextInt();
					switch(j){
				case 1 :
					controller.incremente();
					printHelp();
					break;
				case 2 : 
					controller.bonusUn();
					printHelp();
					break;
				case 3 :
					controller.bonusDeux();
					printHelp();
					break;
				case 4 : 
					controller.bonusTrois();
					printHelp();
					break;
				default : 
					affiche("Nombre incorrect");
					printHelp();	
					}
				}
			catch(InputMismatchException e){
				affiche("Format d'input incorrect");
				printHelp();
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
