package controller;

import model.IModel;


/**
 * <h1>The class Player.</h1>
 * 
 * @author Emilien BRUN
 * @version 1.0
 */
public class Player{
	/**
	 * The direction of the player
	 */
	private Direction direction;
	/**
	 * the color of the player
	 */
	private String couleur;
	/**
	 * the life of the player
	 */
	private boolean alive = true;
	/**
	 * the coordonates of the player
	 */
	private int x, y;
	/**
	 * the instanciation of the model
	 */
	private IModel model;

	/**
	 * The getter and setter
	 */
	
	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		System.out.println("je recois le model");
		this.model = model;
	}

	public int getX() {
		System.out.println("je demande le x");
		return x;
	}

	public void setX(int x) {
		System.out.println("je donne le X");
		this.x = x;
	}

	public int getY() {
		System.out.println("je demande le y");
		return y;
	}

	public void setY(int y) {
		System.out.println("je donne le y");
		this.y = y;
	}

	public String getCouleur() {
		System.out.println("je demande la couleur");
		return couleur;
	}

	public void setCouleur(String couleur) {
		System.out.println("je donne la couleur");
		this.couleur = couleur;
	}

	public boolean isAlive() {
		System.out.println("il est vivant?");
		return alive;
	}

	public void setAlive(boolean alive) {
		System.out.println("je donne sont etat");
		this.alive = alive;
	}

	/**
	 * the constructor of the player
	 * @param couleurD
	 * @param xD
	 * @param yD
	 * @param directionD
	 * @param modelD
	 */
	public Player(String couleurD, int xD, int yD, Direction directionD, IModel modelD) {
		// TODO Auto-generated constructor stub
		setCouleur(couleurD);
		setX(xD);
		setY(yD);
		setDirection(directionD);
		setModel(modelD);
		System.out.println("je suis " + couleur + " a la position " + x + " / " + y + " ma direction est " + direction);
		//seDeplacer(direction);
		
		
	}

	/*private void seDeplacer(Direction direction) {
		// TODO Auto-generated method stub
		System.out.println("je veux me déplacer");
		//while (alive == true) {
		
			System.out.println("je suis vivant donc je peut me déplacer");
			int nb = 1;
			if(System.currentTimeMillis()/1000 >= nb) {
				System.out.println("j'ava,ce toute les secondes");
				nb =+ 3000000000000000000000000000000000;
				
				switch(direction) {
				case HAUT:
					setY(y+1);
					//Model.setMap(couleur, x, y);
				break;
				
				case BAS:
					System.out.println("vers le bas");
					setY(y-1);
					System.out.println("je bouge a " + x + " / " + y + " je suis " + couleur);
					model.deplacement( couleur,  x,  y);
					System.out.println("jenregistre le mouvement");
				break;
				
				case DROITE:
					setX(x+1);
					//Model.setMap(couleur, x, y);
				break;
				
				case GAUCHE:
					setX(x-1);
					//Model.setMap(couleur, x, y);
				break;
				}
				
				
				
			//}
		} 
	}*/
		

	public Direction getDirection() {
		System.out.println("je demande la direction de " + couleur);
		// TODO Auto-generated method stub
		return direction;
	}
	
	public void setDirection(Direction ordre) {
		System.out.println("je donne la direction de " + couleur + " est " + ordre);
		direction = ordre;
	}
	
	/**
	 * the player die
	 */
	public void mourir() {
		System.out.println("je meurt");
		setAlive(false);
	}
	
}

