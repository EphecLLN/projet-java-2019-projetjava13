package projet.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import projet.controller.*;
import projet.model.Bonus;
import projet.model.Cliqueur;;

public class ProjetGUI extends ProjetVue implements ActionListener{

	private static JLabel counterLabel;
	private JLabel perSecLabel;
	JLabel resultLabel;
	private JButton button1,button2,button3,button4,button5,button6;
	int  timerSpeed;
	boolean timerOn;
	private Font font1,font2;
	private PieceHandler pHandler = new PieceHandler();
	private Timer timer;
	private static JLabel messageText;
	private JTextField loginText;
	
		public ProjetGUI(Bonus model,
				ProjetController controller, Object posX, Object posY) {
	
			super(model, controller);
			timerOn = false;
			createFont();
			createUi();
			
		}
		
		public void createFont() {
			
			font1 = new Font("Times New Roman",Font.PLAIN,32);
			font2 = new Font("Times New Roman",Font.PLAIN,16);
		}
		
	public void createUi() {
		//JFrame de base
		JFrame window = new JFrame();
		window.setSize(800,900);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.white);
		window.setLayout(null);
		
		
		//Contenu de la JFrame
		JPanel piecePanel = new JPanel();
		piecePanel.setBounds(100, 220, 200, 200);
		piecePanel.setBackground(Color.white);
		window.add(piecePanel);
		
		ImageIcon piece = new ImageIcon(getClass().getClassLoader().getResource("img/coin-shine1.gif"));
		//JButton contenu dans l'image
		JButton pieceButton = new JButton();
		pieceButton.setBackground(Color.white);
		pieceButton.setFocusPainted(false);
		pieceButton.setBorder(null);
		pieceButton.setIcon(piece);
		pieceButton.addActionListener(pHandler);
		pieceButton.setActionCommand("incremente");
		piecePanel.add(pieceButton);
		//JPanel d'affichage du nombre de pieces mais aussi des bonus
		JPanel counterPanel = new JPanel();
		counterPanel.setBounds(100,100, 200, 100);
		counterPanel.setBackground(Color.white);
		counterPanel.setLayout(new GridLayout(2,1));
		window.add(counterPanel);
		//les labels sont crées plus haut car ils seront modifiés dynamiquement
		counterLabel = new JLabel(Cliqueur.pieceCounter + " euros");
		counterLabel.setForeground(Color.black);
		counterLabel.setFont(font1);
		counterPanel.add(counterLabel);
		
		perSecLabel = new JLabel();
		perSecLabel.setForeground(Color.black);
		perSecLabel.setFont(font2);
		counterPanel.add(perSecLabel);
		
		resultLabel = new JLabel();
		resultLabel.setForeground(Color.black);
		resultLabel.setFont(font2);
		resultLabel.setBounds(250, 560, 300, 200);
		window.add(resultLabel);
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBounds(500, 170, 250, 250);
		itemPanel.setBackground(Color.white);
		itemPanel.setLayout(new GridLayout(4, 1));
		window.add(itemPanel);
		
		JPanel Panel = new JPanel();
		Panel.setBounds(250, 450, 300, 50);
		Panel.setBackground(Color.lightGray);
		Panel.setLayout(new GridLayout(1, 2));
		window.add(Panel);
		
		JPanel Pan = new JPanel();
		Pan.setBounds(250, 500, 300, 50);
		Pan.setBackground(Color.lightGray);
		Pan.setLayout(new GridLayout(1, 1));
		window.add(Pan);
		
		messageText = new JLabel();
		messageText.setBounds(500, 70, 250, 150);
		messageText.setBackground(Color.white);
		messageText.setFont(font2);
		window.add(messageText);
	
		loginText = new JTextField();
		loginText.setBackground(Color.white);
		loginText.setFont(font2);
		Panel.add(loginText);
		
		button1 = new JButton("+0.1 par s pour "+ Cliqueur.prixperSeconde +"euros");
		button1.setFont(font2);
		button1.setFocusPainted(false);
		button1.addActionListener(pHandler);
		button1.setActionCommand("bonusUn");
		itemPanel.add(button1);
		
		button2 = new JButton("?");
		button2.setFont(font2);
		button2.setFocusPainted(false);
		button2.addActionListener(pHandler);
		button2.setActionCommand("bonusDeux");
		itemPanel.add(button2);
		
		button3 = new JButton("?");
		button3.setFont(font2);
		button3.setFocusPainted(false);
		button3.addActionListener(pHandler);
		button3.setActionCommand("bonusTrois");
		itemPanel.add(button3);
		
		button4 = new JButton("?");
		button4.setFont(font2);
		button4.setFocusPainted(false);
		button4.addActionListener(pHandler);
		button4.setActionCommand("bonusQuatre");
		itemPanel.add(button4);
		
		button5 = new JButton("Enregistrer");
		button5.setFont(font2);
		button5.setFocusPainted(false);
		button5.addActionListener(pHandler);
		button5.setActionCommand("enregistre");
		Panel.add(button5);
		
		button6 = new JButton("Résultats");
		button6.setFont(font2);
		button6.setFocusPainted(false);
		button6.addActionListener(pHandler);
		button6.setActionCommand("resultats");
		Pan.add(button6);
	
		window.setVisible(true);
	}
	public void createUI2() {
		JFrame window2 = new JFrame();
		window2.setSize(300,200);
		window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window2.getContentPane().setBackground(Color.white);
		window2.setLayout(null);
		window2.setVisible(true);
	}
	public void setTimer() {
		timer = new Timer(timerSpeed,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Cliqueur.pieceCounter++;
				counterLabel.setText(Cliqueur.pieceCounter + " euros");
			}		
		});
	}
	
public void timerUpdate() {
		
		if(timerOn==false) {
			timerOn = true;
		}
		else if(timerOn==true) {
			timer.stop();
		}
		double speed = 1/Cliqueur.perSecond*1000;
		timerSpeed = (int)Math.round(speed);
		
		String nbr = String.format("%.1f", Cliqueur.perSecond);
		perSecLabel.setText("<html>"+nbr + " euros par seconde <br>Vous gagnez "+Cliqueur.valeurPiece+ " par clic<html>");
		
		
		setTimer();
		timer.start();
	}
	public static void actualise() {
		counterLabel.setText(Cliqueur.pieceCounter+" euros");
		messageText.setText("");
	}
	public void test(JButton b) {
		if(b.getText()=="?") {
			messageText.setText("Vous n'avez pas débloqué ce bonus");
		}
	}
	
	public class PieceHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String action = event.getActionCommand();
			
			switch(action) {
			case "incremente":
				controller.incremente();
				actualise();
					if(Cliqueur.pieceCounter>=100) {
					button2.setText("Change de monnaie pour "+ Cliqueur.prixBonus +"euros" + "(" + Cliqueur.prixBonus+")");
				
					}
					if(Cliqueur.pieceCounter>=200) {
						button2.setText("Change de monnaie pour "+ Cliqueur.prixBonus +"euros" + "(" + Cliqueur.prixBonus+")");
						button3.setText("Double 'par sec' pour "+ Cliqueur.prixAuto +"euros");
						}
					if(Cliqueur.pieceCounter>=500) {
						button2.setText("Change de monnaie pour "+ Cliqueur.prixBonus +"euros" + "(" + Cliqueur.prixBonus+")");
						button3.setText("Double 'par sec' pour "+ Cliqueur.prixAuto +"euros");
						button4.setText("Double le clic pour "+ Cliqueur.prixMalus +"euros");
						}
				break;
			case "bonusUn" :

				if(Cliqueur.pieceCounter>=Cliqueur.prixperSeconde) {
				controller.bonusUn();
				timerUpdate();
				actualise();
				button1.setText("+0.1 par s pour "+ Cliqueur.prixperSeconde +"euros");
				
				}
				else {
					messageText.setText("Vous n'avez pas assez de pièces");
					
				}
				break;
			case "bonusDeux" :
				if(Cliqueur.pieceCounter>=Cliqueur.prixBonus) {
				controller.bonusDeux();
				model.text();
				actualise();
				button2.setText("Change de monnaie pour "+ Cliqueur.prixBonus +"euros");
				}
				else {
					messageText.setText("Vous n'avez pas assez de pièces");
					test(button2);
					}
		break;
		
		case "bonusTrois" :
			if(Cliqueur.pieceCounter>=Cliqueur.prixAuto) {
			controller.bonusTrois();
			model.text();
			actualise();
			timerUpdate();
			button3.setText("Double 'par sec' pour "+ Cliqueur.prixAuto +"euros");
			}
			else {
				messageText.setText("Vous n'avez pas assez de pièces");
				test(button3);
				}
			break;
		case "bonusQuatre" :
			if(Cliqueur.pieceCounter>=Cliqueur.prixMalus) {
			controller.bonusQuatre();
			model.text();
			actualise();
			timerUpdate();
			button4.setText("Double le clic pour "+ Cliqueur.prixMalus +"euros");
			}
			else {
				messageText.setText("Vous n'avez pas assez de pièces");
				test(button4);
				}
			break;
		
			
			case "enregistre":
				try {
				Cliqueur.login = loginText.getText();
				controller.enregistre();
				}
				catch(NullPointerException e) {
					messageText.setText("Introduisez un nom");
				}
				break;
				
				
			case "resultats":
				controller.resultats();
				ArrayList al = model.Collection();
				String table = "<html>";
				for (int i = 0;i<al.size();i++) {
					table += (i+1) +") " +al.get(i).toString() + "<br>";
				}
				table += "</html>";
				resultLabel.setText(table);
				break;
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affiche(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
}