package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PieceMain {

	JLabel counterLabel, perSecLabel;
	JButton button1,button2,button3,button4;
	int pieceCounter, timerSpeed;
	double perSecond;
	boolean timerOn;
	Font font1,font2;
	PieceHandler pHandler = new PieceHandler();
	Timer timer;
	
	public static void main(String[] args) {
		
		new PieceMain();

	}
	
		public PieceMain() {
	
			timerOn = false;
			perSecond = 0;
			pieceCounter = 0;
			
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
		
		ImageIcon piece = new ImageIcon(getClass().getClassLoader().getResource("piece200x200.jpg"));
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
	
		button1 = new JButton("Cursor");
		button1.setFont(font1);
		button1.setFocusPainted(false);
		button1.addActionListener(pHandler);
		button1.setActionCommand("Cursor");
		itemPanel.add(button1);
		
		button2 = new JButton("?");
		button2.setFont(font1);
		button2.setFocusPainted(false);
		button2.addActionListener(pHandler);
		button2.setActionCommand("Cursor");
		itemPanel.add(button2);
		
		button3 = new JButton("?");
		button3.setFont(font1);
		button3.setFocusPainted(false);
		button3.addActionListener(pHandler);
		button3.setActionCommand("Cursor");
		itemPanel.add(button3);
		
		button4 = new JButton("?");
		button4.setFont(font1);
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
				pieceCounter++;
				counterLabel.setText(pieceCounter+" euros");
				break;
			case "Cursor" :
				perSecond = perSecond + 0.1;
				timerUpdate();
		}
	}
	
	
	
	}
}
