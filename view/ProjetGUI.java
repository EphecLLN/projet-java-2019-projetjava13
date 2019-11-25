package projet.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import projet.controller.*;
import projet.model.*;;

public class ProjetGUI extends ProjetVue implements ActionListener {

	private JLabel counterLabel, perSecLabel;
	private JButton button1,button2,button3,button4;
	int pieceCounter, pieceValeur, timerSpeed, cursorNumber, cursorPrice, bonusNumber, bonusPrice;
	double perSecond;
	boolean timerOn,bonusUnlocked;
	private Font font1,font2;
	private PieceHandler pHandler = new PieceHandler();
	private Timer timer;
	private JTextArea messageText;
	
	
		public ProjetGUI(Cliqueur model,
				ProjetController controller, Object posX, Object posY) {
	
			super(model, controller);
			timerOn = false;
			perSecond = 0;
			pieceCounter = 0;
			cursorNumber = 0;
			cursorPrice = 10;
			bonusPrice = 100;
			bonusNumber = 0;
			pieceValeur = 1;
			bonusUnlocked = false;
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
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.white);
		window.setLayout(null);
		
		//Contenu de la JFrame
		JPanel piecePanel = new JPanel();
		piecePanel.setBounds(100, 220, 200, 200);
		piecePanel.setBackground(Color.white);
		window.add(piecePanel);
		
		ImageIcon piece = new ImageIcon(getClass().getClassLoader().getResource("img/piece200x200.jpg"));
		//JButton contenu dans l'image
		JButton pieceButton = new JButton();
		pieceButton.setBackground(Color.black);
		pieceButton.setFocusPainted(false);
		pieceButton.setBorder(null);
		pieceButton.setIcon(piece);
		pieceButton.addActionListener(pHandler);
		pieceButton.setActionCommand("piece");
		piecePanel.add(pieceButton);
		//JPanel d'affichage du nombre de pieces mais aussi des bonus
		JPanel counterPanel = new JPanel();
		counterPanel.setBounds(100,100, 200, 100);
		counterPanel.setBackground(Color.white);
		counterPanel.setLayout(new GridLayout(2,1));
		window.add(counterPanel);
		//les labels sont crées plus haut car ils seront modifiés dynamiquement
		counterLabel = new JLabel(pieceCounter + " euros");
		counterLabel.setForeground(Color.black);
		counterLabel.setFont(font1);
		counterPanel.add(counterLabel);
		
		perSecLabel = new JLabel();
		perSecLabel.setForeground(Color.black);
		perSecLabel.setFont(font2);
		counterPanel.add(perSecLabel);
		
		JPanel itemPanel = new JPanel();
		itemPanel.setBounds(500, 170, 250, 250);
		itemPanel.setBackground(Color.lightGray);
		itemPanel.setLayout(new GridLayout(4, 1));
		window.add(itemPanel);
		
		messageText = new JTextArea();
		messageText.setBounds(500, 70, 250, 150);
		messageText.setBackground(Color.white);
		messageText.setFont(font2);
		window.add(messageText);
	
		button1 = new JButton("+0.1 par s pour "+ cursorPrice +"euros" + "(" + cursorNumber+")");
		button1.setFont(font2);
		button1.setFocusPainted(false);
		button1.addActionListener(pHandler);
		button1.setActionCommand("Cursor");
		itemPanel.add(button1);
		
		button2 = new JButton("?");
		button2.setFont(font2);
		button2.setFocusPainted(false);
		button2.addActionListener(pHandler);
		button2.setActionCommand("Bonus");
		itemPanel.add(button2);
		
		button3 = new JButton("?");
		button3.setFont(font2);
		button3.setFocusPainted(false);
		button3.addActionListener(pHandler);
		button3.setActionCommand("Cursor");
		itemPanel.add(button3);
		
		button4 = new JButton("?");
		button4.setFont(font2);
		button4.setFocusPainted(false);
		button4.addActionListener(pHandler);
		button4.setActionCommand("Cursor");
		itemPanel.add(button4);
		
		
	
		window.setVisible(true);
	}
	
	public void setTimer() {
		timer = new Timer(timerSpeed,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				pieceCounter++;
				counterLabel.setText(pieceCounter + " euros");
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
		double speed = 1/perSecond*1000;
		timerSpeed = (int)Math.round(speed);
		
		String nbr = String.format("%.1f", perSecond);
		perSecLabel.setText(nbr + " euros par seconde");
		
		
		setTimer();
		timer.start();
	}
	
	
	public class PieceHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String action = event.getActionCommand();
			
			switch(action) {
			case "piece":
				pieceCounter+=pieceValeur;
				counterLabel.setText(pieceCounter+" euros");
				
				if(bonusUnlocked==false) {
					if(pieceCounter>=100) {
					bonusUnlocked = true;
					button2.setText("Change de monnaie pour "+ bonusPrice +"euros" + "(" + bonusNumber+")");
					}
			
		}
				break;
			case "Cursor" :
				if(pieceCounter>=cursorPrice) {
				pieceCounter = pieceCounter - cursorPrice;
				cursorPrice += 5;
				counterLabel.setText(pieceCounter + " euros");
				cursorNumber++;
				button1.setText("+0.1 par s pour "+ cursorPrice +"euros" + "(" + cursorNumber+")");
				perSecond = perSecond + 0.1;
				timerUpdate();
				}
				else {
					messageText.setText("Vous n'avez pas assez de pièces");
				}
			case "Bonus" :
				if(pieceCounter>=bonusPrice) {
				pieceCounter = pieceCounter - bonusPrice;
				bonusPrice += 100;
				pieceValeur = 2;
				button2.setText("Change de monnaie pour "+ bonusPrice +"euros" + "(" + bonusNumber+")");
				
				}
				else {
					messageText.setText("Vous n'avez pas assez de pièces");
					}
			}
	
	
	
		}
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affiche(String string) {
		// TODO Auto-generated method stub
		
	}
}