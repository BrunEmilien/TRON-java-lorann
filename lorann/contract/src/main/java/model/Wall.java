package model;

public class Wall extends MapElements{
	
	private String couleur;
	private int x;
	private int y;

	public String getCouleur() {
		System.out.println("je demande la couleur du mur");
		return couleur;
	}

	public void setCouleur(String couleur) {
		System.out.println("je donne la couleur du mur");
		this.couleur = couleur;
	}

	public int getX() {
		System.out.println("je demande le X du mur");
		return x;
	}

	public void setX(int x) {
		System.out.println("je donne le X du mur");
		this.x = x;
	}

	public int getY() {
		System.out.println("je demande le y du mur");
		return y;
	}

	public void setY(int y) {
		System.out.println("je donne le y du mur");
		this.y = y;
	}

	public Wall(String couleurD, int xD, int yD) {
		// TODO Auto-generated constructor stub
		setCouleur(couleurD);
		setX(xD);
		setY(yD);
	}

}