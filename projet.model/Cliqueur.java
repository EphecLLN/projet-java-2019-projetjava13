package projet.model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.Timer;

public class Cliqueur {
	
	public static int pieceCounter;
	public static int timerSpeed;
	public static int valeurPiece;
	public static int prixBonus;
	public static int valeurBonus;
	public static int prixperSeconde;
	public static int prixAuto;
	public static int prixMalus;
	public static double perSecond;
	static boolean timerOn;
	static Timer timer;
	public static String login;
	
	public static String getLogin() {
		return login;
	}

	public static void setLogin(String login) {
		Cliqueur.login = login;
	}

	public static void setTimer(Timer timer) {
		Cliqueur.timer = timer;
	}

	public Cliqueur() {
		prixAuto = 200;
		prixperSeconde = 10;
		perSecond = 0;
		pieceCounter = 0;
		timerOn = false;
		valeurPiece = 1;
		prixBonus = 20;
		valeurBonus = 100;
		prixMalus = 500;
	}
	
	public int getPieceCounter() {
		return pieceCounter;
	}

	public void setPieceCounter(int pieceCounter) {
		this.pieceCounter = pieceCounter;
	}

	public int getTimerSpeed() {
		return timerSpeed;
	}

	public void setTimerSpeed(int timerSpeed) {
		this.timerSpeed = timerSpeed;
	}

	public int getValeurPiece() {
		return valeurPiece;
	}

	public void setValeurPiece(int valeurPiece) {
		this.valeurPiece = valeurPiece;
	}

	public int getPrixBonus() {
		return prixBonus;
	}

	public void setPrixBonus(int prixBonus) {
		this.prixBonus = prixBonus;
	}

	public int getValeurBonus() {
		return valeurBonus;
	}

	public void setValeurBonus(int valeurBonus) {
		this.valeurBonus = valeurBonus;
	}

	public int getPrixperSeconde() {
		return prixperSeconde;
	}

	public void setPrixperSeconde(int prixperSeconde) {
		this.prixperSeconde = prixperSeconde;
	}

	public int getPrixAuto() {
		return prixAuto;
	}

	public void setPrixAuto(int prixAuto) {
		this.prixAuto = prixAuto;
	}

	public int getPrixMalus() {
		return prixMalus;
	}

	public void setPrixMalus(int prixMalus) {
		this.prixMalus = prixMalus;
	}

	public double getPerSecond() {
		return perSecond;
	}

	public void setPerSecond(double perSecond) {
		this.perSecond = perSecond;
	}

	public static boolean isTimerOn() {
		return timerOn;
	}

	public static void setTimerOn(boolean timerOn) {
		Cliqueur.timerOn = timerOn;
	}

	public static Timer getTimer() {
		return timer;
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
