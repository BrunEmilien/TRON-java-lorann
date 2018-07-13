package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.IController;

public class Clavier implements KeyListener {

	private String couleur;
	private String ordre;
	private boolean haveOrdre = false;
	
	@Override
	public void keyPressed(final KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		
		case KeyEvent.VK_Q:
			setCouleur("Blue");
			setOrdre("Gauche");
			setHaveOrdre(true);
			break;
			
		case KeyEvent.VK_D:
			setCouleur("Blue");
			setOrdre("Droite");
			setHaveOrdre(true);
			break;
		
		case KeyEvent.VK_LEFT:
			setCouleur("Red");
			setOrdre("Gauche");
			setHaveOrdre(true);
			break;
			
		case KeyEvent.VK_RIGHT:
			setCouleur("Red");
			setOrdre("Droite");
			setHaveOrdre(true);
			break;
		}
	}

	
	public String getCouleur() {
		return couleur;
	}


	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	public String getOrdre() {
		return ordre;
	}


	public void setOrdre(String ordre) {
		this.ordre = ordre;
	}


	public boolean isHaveOrdre() {
		return haveOrdre;
	}


	public void setHaveOrdre(boolean haveOrdre) {
		this.haveOrdre = haveOrdre;
	}


	@Override
	public void keyReleased(final KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(final KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
