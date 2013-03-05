package com.github.klumpat.rpg2d.entities;


import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.klumpat.rpg2d.Keyboard;

public class Player {
	private Rectangle bounding;
	private float f_posx;
	private float f_posy;
	private int i_speed = 200;
	
	private BufferedImage look;

	
	public Player(int x, int y){
		try {
		look = ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/player.png"));}
		catch (IOException e) {e.printStackTrace();}
		
		
		bounding = new Rectangle(x, y, look.getWidth(), look.getHeight());
		setPosX(x);
		f_posy = y;
	}
	
	public void update(float timeSinceLastFrame){
		if(Keyboard.isKeyDown(KeyEvent.VK_W))f_posy-=i_speed*timeSinceLastFrame;;
		if(Keyboard.isKeyDown(KeyEvent.VK_A))setPosX(getPosX() - i_speed*timeSinceLastFrame);;
		if(Keyboard.isKeyDown(KeyEvent.VK_S))f_posy+=i_speed*timeSinceLastFrame;;
		if(Keyboard.isKeyDown(KeyEvent.VK_D))setPosX(getPosX() + i_speed*timeSinceLastFrame);;
		
		if(getPosX()<0)setPosX(0);
		if(f_posy<0)f_posy = 0;
		if(getPosX()>800-bounding.width)setPosX(800-bounding.width);
		if(f_posy>600-bounding.height)f_posy = 600-bounding.height;
		
		bounding.x=(int)getPosX();
		bounding.y=(int)f_posy;
		
	}
	
	public Rectangle getBounding(){
		return bounding;
	}
	public BufferedImage getLook(){
		return look;
	}

	public float getPosX() {
		return f_posx;
	}

	public void setPosX(float f_posx) {
		this.f_posx = f_posx;
	}
	public float getPosY() {
		return f_posy;
	}
	
}