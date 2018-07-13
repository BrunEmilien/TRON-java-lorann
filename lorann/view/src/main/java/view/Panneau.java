package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Panneau extends JPanel{
	private Graphics g;
	
	private int x=0;
	private int y=0;
	private int xT=600;
	private int yT=400;
	private String couleur = "Black";
	private Table table;
	
	
	public Panneau(Table tableD) {
		super();
		System.out.println("le message de game over va s'afficher");
		this.x=0;
		this.y=0;
		this.xT=400;
		this.yT=600;
		this.table = tableD;
		
		
		System.out.println("fin constructeur");
		
	}

	public void paintComponent(Graphics g){
		System.out.println("paint");
		super.paintComponent(g);
		//SINON ON MET UNE IMAGE
		g.setColor(Color.BLACK);
		g.fillRect(y, x, 600, 400);
		
		for(int i = 0; i < (table.getMax()/3); i++) {
		
			setCouleur(table.getTableMur().get(i*3));
			setX((int)table.getTableMur().get(i*3+1));
			setY((int)table.getTableMur().get(i*3+2));
			
			System.out.println(couleur);
			switch(couleur) {
			
			case "Blue":
				
				g.setColor(Color.BLUE);
				g.fillRect(y, x, 1, 1);
				break;
				
			case "Red":
				g.setColor(Color.RED);
				g.fillRect(y, x, 1, 1);
				break;
				
			case "Black":
				
				g.setColor(Color.BLACK);
				g.fillRect(y, x, 1, 1);
				break;
			}
		}
	    
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getxT() {
		return xT;
	}

	public void setxT(int xT) {
		this.xT = xT;
	}

	public int getyT() {
		return yT;
	}

	public void setyT(int yT) {
		this.yT = yT;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(Object object) {
		this.couleur = (String) object;
	}

	public void refresh(String couleurF, int xF, int yF) {
		// TODO Auto-generated method stub
		setX(xF);
		setY(yF);
		setyT(1);
		setxT(1);
		setCouleur(couleurF);
		repaint();
	}
	

	
}
