package projet.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Observable;

public class Bonus extends Observable{
	Cliqueur cliq = new Cliqueur(); 

	 public void add() {
			cliq.pieceCounter += Cliqueur.valeurPiece;
		}

		public void bonusUn() {
			if(cliq.pieceCounter>=cliq.prixperSeconde) {
			cliq.pieceCounter = cliq.pieceCounter - cliq.prixperSeconde;
			cliq.prixperSeconde = cliq.prixperSeconde + 10;
			cliq.perSecond = cliq.perSecond+0.1; 
			cliq.timerUpdate(); 
			}
			else {
				System.out.println("Compte insuffisant");
			}
		}
		
		public void bonusDeux() {
			if(cliq.pieceCounter>=cliq.prixBonus) {
			cliq.pieceCounter = cliq.pieceCounter - cliq.prixBonus;
			cliq.prixBonus = cliq.prixBonus + 20;
			cliq.valeurPiece ++; 
			}
			else {
				System.out.println("Compte insuffisant");
			}
		}
		
		public void bonusTrois() {
			if(cliq.pieceCounter>=cliq.prixAuto) {
			cliq.pieceCounter = cliq.pieceCounter - cliq.prixAuto;
			cliq.perSecond = cliq.perSecond*2;
			cliq.prixAuto = cliq.prixAuto*2;
		}
			else {
				System.out.println("Compte insuffisant");
			}
		}
		
		public void bonusQuatre() {
			if(cliq.pieceCounter>=cliq.prixMalus) {
			cliq.pieceCounter = cliq.pieceCounter - cliq.prixMalus;
			cliq.prixMalus = cliq.prixMalus*2;
			cliq.valeurPiece = cliq.valeurPiece*2;
			
			//TODO
		}
			else {
				System.out.println("Compte insuffisant");
			}
		}

		
		public void text() {
			System.out.println("Pour ajouter : " +cliq.valeurPiece + " pieces tapez  1");
			System.out.println("Pour ajouter 0.1 pieces par seconde, pour " + cliq.prixperSeconde + " tapez  2");
			System.out.println("Pour ajouter ("+cliq.valeurPiece+") pièces, pour " + cliq.prixBonus + ", tapez  3" );
			System.out.println("Pour doubler la vitesse par sec, pour : "+ cliq.prixAuto +" tapez  4");
			System.out.println("Pour doubler la valeur des pièces, pour : "+ cliq.prixMalus +" tapez  5");
			System.out.println("Pour Enregistrer votre progression tapez  6 puis votre login");
			System.out.println("Vous avez : "+ cliq.pieceCounter +" pieces");
			System.out.println("Vous gagnez : "+ cliq.perSecond+" pieces par secondes");
			System.out.println("Chaque clic vaut "+ cliq.valeurPiece);
		}
		
		public void enregistre() {
			try {
				Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","student");
				Statement myStmt = myConn.createStatement();
				myStmt.executeUpdate("insert into cliques ( euro,parSeconde,parClique,Login)values ("+Cliqueur.pieceCounter +","+Cliqueur.perSecond+","+Cliqueur.valeurPiece+",'"+Cliqueur.login+"')");
			}
			catch(Exception exc) {
				exc.printStackTrace();
			}		
		}

		public static ArrayList Collection() {
			ArrayList listNom = new ArrayList();
			try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","student");
			Statement myStmt = myConn.createStatement();
			ResultSet rs=myStmt.executeQuery("Select * from demo.cliques order by euro desc");
				while (rs.next())
				{
				ArrayList list = new ArrayList();
				 String login = rs.getString("Login");
				 list.add(login);
				 int parSeconde = rs.getInt("parSeconde");
				 list.add(parSeconde);
				 int parClique = rs.getInt("parClique");
				 list.add(parClique);
				 int euro = rs.getInt("euro");
				 list.add(euro);
				 listNom.add(list);
				}
				System.out.println(listNom);
			}
			
			catch(SQLException sqle) {
				 System.err.println("Erreur Localisation BD");
			}
			return listNom;
			
		}

}

