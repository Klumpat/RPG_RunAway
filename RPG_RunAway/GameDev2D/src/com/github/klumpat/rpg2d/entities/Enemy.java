package com.github.klumpat.rpg2d.entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy {
	private Rectangle bounding;
	private float f_posx;
	private float f_posy;
	private float f_MobTimer = 0;
	private float f_TimeTillMobAction = 5;
	private float speed = 50;
	
	private BufferedImage look;


	
	public Enemy(int x, int y){
		try {
		look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/enemy.png"));}
		catch (IOException e) {e.printStackTrace();}
		bounding = new Rectangle(x, y, look.getWidth(), look.getHeight());
		f_posx = x;
		f_posy = y;
	}
	
	public void update(float timeSinceLastFrame, Player player){
		chasePlayer(player,timeSinceLastFrame);
		
		bounding.x=(int)f_posx;
		bounding.y=(int)f_posy;
		}
		
	
	public Rectangle getBounding(){
		return bounding;
	}
	
	private void changeLocation(float timeSinceLastFrame){
		
		// benötige algorhythmus damit der gegner nach einer bestimmten Zeit "f_TimeTillMobAction" sich von seiner jetztigen Position wegbewegt - idealerweise einen random punkt im fenster
	}

	public BufferedImage getLook() {
		return look;
	}
	
	public void killed(Enemy enemy){
		System.out.println("Mob ist tot");
	}
	
	public void chasePlayer(Player player, float timeSinceLastFrame){
		if(player.getPosX()<this.f_posx){
			this.f_posx-=this.speed*timeSinceLastFrame;}
		if(player.getPosX()>this.f_posx){
			this.f_posx+=this.speed*timeSinceLastFrame;}
		if(player.getPosY()<this.f_posy){
			this.f_posy-=this.speed*timeSinceLastFrame;}
		if(player.getPosY()>this.f_posy){
			this.f_posy+=this.speed*timeSinceLastFrame;}
		else ;
		
	}

}