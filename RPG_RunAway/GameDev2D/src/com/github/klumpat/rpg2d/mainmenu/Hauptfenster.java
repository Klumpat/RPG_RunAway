package com.github.klumpat.rpg2d.mainmenu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.klumpat.rpg2d.Game;

public class Hauptfenster extends JFrame {	private static final long serialVersionUID = 1L;
	
	JButton btnClose, btnStartGame, btnLoadGame, btnOptions, btnCredits;
	JLabel lblVersion, lblBG;
	
		
	//BufferedImage look; 
		
	
	final static String VERSION = "v0.1";
	
	public static void main(String[] args) {
		JFrame Hauptfenster = new Hauptfenster();
	}
		
	
	public Hauptfenster() {
		super("Hauptmenü");
		
		
		//load GFX
//		try {
//			look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("hauptfenster/HauptmenüBG.png"));}
//			catch (IOException e) {e.printStackTrace();}
		
		
		//settings
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(275, 300);
		setLocationRelativeTo(null);
		setUndecorated(false);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		
		//setLayout(new BoxLayout(rootPane, EXIT_ON_CLOSE));
		
		
		
		
		
		//Buttons
		btnStartGame = new JButton("Neues Spiel");
		btnStartGame.setBounds(75, 25, 125, 25);
		
		btnLoadGame = new JButton("Spiel Laden");
		btnLoadGame.setBounds(75, 75, 125, 25);
		
		btnOptions = new JButton("Optionen");
		btnOptions.setBounds(75, 125, 125, 25);
		
		btnClose = new JButton("Spiel beenden");
		btnClose.setBounds(75, 175, 125, 25);
		
		btnCredits = new JButton("Credits");
		btnCredits.setBounds(75, 225, 125, 25);
		
		//Textfelder
		
		lblVersion = new JLabel();
		lblVersion.setBounds(25,225,75,25);
		lblVersion.setText(VERSION);
		
		//Hintergrund
		
		
		// Listener
		btnClose.addActionListener(new MenuHandler());
		btnStartGame.addActionListener(new MenuHandler());
		
		//add components
		
		add(btnClose);
		add(btnStartGame);
		add(btnLoadGame);
		add(btnOptions);
		add(btnCredits);
		add(lblVersion);
				
	}
	private class MenuHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnClose)System.exit(0);
			if (e.getSource() == btnStartGame)startGame();
			if (e.getSource() == btnLoadGame)System.exit(0);
			if (e.getSource() == btnOptions)System.exit(0);
			if (e.getSource() == btnCredits)System.exit(0);
			
		}
		
	}
	public void startGame(){
        new Thread( new Runnable(){
          public void run() {
            Game.main(null);
          }
          }).start();
           
	}
}
	

