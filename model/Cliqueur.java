package projet.model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.Timer;

public class Cliqueur extends Observable {
	
	static int pieceCounter,timerSpeed,valeurPiece,prixBonus,valeurBonus,prixperSeconde,prixAuto,prixMalus;
	static double perSecond;
	static boolean timerOn;
	static Timer timer;
	
	public Cliqueur() {
		prixAuto = 200;
		prixperSeconde = 20;
		perSecond = 0;
		pieceCounter = 0;
		timerOn = false;
		valeurPiece = 1;
		prixBonus = 10;
		valeurBonus = 100;
	}
	
	public static void clearScreen() {    
		for(int i = 1; i <= 10; i++){
			System.out.println();
		}
	}  
	
	public void add() {
		pieceCounter += valeurPiece;
	}
	
	public void bonusUn() {
		if(pieceCounter>=prixBonus) {
		pieceCounter = pieceCounter - prixBonus;
		prixBonus = prixBonus + 10;
		valeurPiece ++; 
		System.out.println(valeurPiece);
		}
		else {
			System.out.println("Compte insuffisant");
		}
	}

	public void bonusDeux() {
		if(pieceCounter>=prixperSeconde) {
		pieceCounter = pieceCounter - prixperSeconde;
		prixperSeconde = prixperSeconde + 20;
		perSecond = perSecond+0.1; 
		timerUpdate(); 
		}
		else {
			System.out.println("Compte insuffisant");
		}
	}
	
	public void bonusTrois() {
		if(pieceCounter>=prixAuto) {
		pieceCounter = pieceCounter - prixAuto;
		perSecond = perSecond*2;
		prixAuto = prixAuto*2;
	}
		else {
			System.out.println("Compte insuffisant");
		}
	}
	
	public void bonusQuatre() {
		if(pieceCounter>=prixMalus) {
		pieceCounter = pieceCounter - prixMalus;
		prixMalus = prixMalus*2;
		
		//TODO
	}
		else {
			System.out.println("Compte insuffisant");
		}
	}
	public void text() {
		System.out.println("Pour ajouter : " +valeurPiece + " pieces tapez  1");
		System.out.println("Pour ajouter ("+valeurPiece+") pièces pour " + prixBonus + ", tapez  2" );
		System.out.println("Pour ajouter 0.1 pieces par seconde pour " + prixperSeconde + " tapez  3");
		System.out.println("Pour doubler la vitesse pour : "+ prixAuto +" tapez  4");
		System.out.println("Pour appliquer un malus pour : "+ prixMalus +" tapez  5");
		System.out.println("Vous avez : "+ pieceCounter +" pieces");
		System.out.println("Vous gagnez : "+ perSecond +" pieces par secondes");
	}
	
	public void setTimer() {
		timer = new Timer(timerSpeed,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pieceCounter++;
			}		
		});
	}
	
public String timerUpdate() {
		
		if(timerOn==false) {
			timerOn = true;
		}
		else if(timerOn==true) {
			timer.stop();
		}
		double speed = 1/perSecond*1000;
		timerSpeed = (int)Math.round(speed);
		
		String nbr = String.format("%.1f", perSecond);
		
		
		setTimer();
		timer.start();
		return nbr;
	}
	
	
}

