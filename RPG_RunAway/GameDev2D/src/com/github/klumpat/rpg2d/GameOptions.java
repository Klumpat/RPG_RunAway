package com.github.klumpat.rpg2d;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import com.github.klumpat.rpg2d.mainmenu.Hauptfenster;


public class GameOptions  extends JDialog{
	
	JButton btnHauptmenu = new JButton("Hauptmenü");
		


	
	public GameOptions(GameFrame owner) {
		super(owner, "Spieloptionen");
		setLocationRelativeTo(null);
		setSize(275, 300);
		setVisible(true);
		btnHauptmenu.setBounds(75, 25, 125, 25);
		btnHauptmenu.addActionListener(new MenuHandler());
		add(btnHauptmenu);
	}
	private class MenuHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnHauptmenu)System.exit(0);
			
			
		}
	}
	public void startGame(){
        new Thread( new Runnable(){
          public void run() {
            Hauptfenster.main(null);
          }
          }).start();
	}
	
}
