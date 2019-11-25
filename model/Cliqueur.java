package projet.model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.Timer;

public class Cliqueur extends Observable {
	
	static int pieceCounter,timerSpeed,valeurPiece,prixBonus,valeurBonus,prixperSeconde,prixAuto,autoClick;
	static double perSecond;
	static boolean timerOn;
	static Timer timer;
	
	public Cliqueur() {
		autoClick = 500;
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
		pieceCounter = pieceCounter - prixBonus;
		prixBonus = prixBonus + 10;
		valeurPiece ++; 
		System.out.println(valeurPiece);
	}

	public void bonusDeux() {
		pieceCounter = pieceCounter - prixperSeconde;
		prixperSeconde = prixperSeconde + 20;
		perSecond = perSecond+0.1; 
		timerUpdate(); 
	}
	
	public void bonusTrois() {
		pieceCounter = pieceCounter - prixAuto;
		pieceCounter += (autoClick*valeurPiece);
		prixAuto = prixAuto + 200;
		autoClick = autoClick + 500;
	}
	public void text() {
		System.out.println("Rajouter : " +valeurPiece + " tapez  1");
		System.out.println("Ajouter un de valeur pour " + prixBonus + " pieces, tapez  2 ("+valeurPiece+")" );
		System.out.println("Ajouter 0.1 pieces par seconde pour " + prixperSeconde + " tapez  3");
		System.out.println("Acheter autoclicker "+autoClick +" pour : "+prixAuto +" tapez  4");
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
