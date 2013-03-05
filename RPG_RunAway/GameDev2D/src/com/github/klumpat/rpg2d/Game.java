package com.github.klumpat.rpg2d;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import com.github.klumpat.rpg2d.entities.Enemy;
import com.github.klumpat.rpg2d.entities.Player;

public class Game {
	
	
	public static void main(String[] args) {
		
		//Initialisierung
		
		
		Player player = new Player(300, 300);
		List<Enemy> enemy = new LinkedList<>();
		enemy.add(new Enemy(100, 100));
		
		
		GameFrame f = new GameFrame(player, enemy);
		GameOptions o;
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 600);
		f.setLocationRelativeTo(null);
		f.setUndecorated(true);
		f.setVisible(true);
		f.setResizable(false);
		
		
		
		long lastFrameTime = System.currentTimeMillis();
		boolean optionsState = false;
		
		
		
		// Rechen <--> Zeichen
		
		
		while(true){
			
//			if(player.getBounding().intersects(enemy.getBounding()))enemy.spawnNewEnemy(enemy);
			
			
			
			
			//FrameZeitberechnung
			long thisFrameTime = System.currentTimeMillis();
			float timeSinceLastFrame = (float)(thisFrameTime-lastFrameTime)/1000f;
			lastFrameTime=thisFrameTime;
			
			//Entitiy Updates
			for(int i = 0; i == enemy.size(); i++){
			enemy.get(i).update(timeSinceLastFrame, player);}
			
			player.update(timeSinceLastFrame);
			
			
			//Repaint
			f.repaintScreen();
			
			
			
			//Speicherschoner ;P
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
	
	private static GameOptions startGameOptions(GameFrame f){
		return new GameOptions(f);
		
	}
}

