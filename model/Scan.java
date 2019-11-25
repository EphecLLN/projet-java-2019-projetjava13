package projet.model;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
public class Scan extends Cliqueur{

	
		Cliqueur cliq = new Cliqueur();
			
		public void add() {
				pieceCounter += valeurPiece;
			}
			
		public void bonusUn() {
				pieceCounter = pieceCounter - prixBonus;
				prixBonus = prixBonus *2;
				valeurPiece ++; 
				}
			/*if (j == 3) {
				if(pieceCounter >= valeurBonus) {
				pieceCounter = pieceCounter - valeurBonus;
				valeurBonus = valeurBonus*2;
				timerOn = true;
				persecond = 1;
				timer(1000,pieceCounter+=persecond);
				}
				clearScreen();
				System.out.println("vous avez " +pieceCounter + " euros");
				System.out.println("Chaque click vaut " + valeurPiece);
				System.out.println("Vous gagnez " + persecond +" par seconde");
			}*/
		
	
}
