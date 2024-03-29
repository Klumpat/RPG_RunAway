package com.github.klumpat.rpg2d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*					How to Use
 * 
 * Add with ---->  	addKeyListener(new Keyboard());
 * Input ------->	if(Keyboard.isKeyDown(KeyEvent.**KEY**)) then blabla;
 * 
 */


public class Keyboard implements KeyListener{
	
	
	private static boolean[] keys = new boolean[300];  // 300 keys reserved
	public static boolean isKeyDown(int keyCode){
		if(keyCode>=0&&keyCode<keys.length) return keys[keyCode];
		else return false;}
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode>=0&&keyCode<keys.length) keys[keyCode]=true;}
	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode>=0&&keyCode<keys.length) keys[keyCode]=false;}
	/*
	 * 
	 * 					Currently not Used
	 * 
	 */
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
