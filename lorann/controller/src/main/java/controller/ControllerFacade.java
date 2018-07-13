package controller;

import java.sql.SQLException;
import java.util.List;


import model.Example;
import model.IModel;

import view.IView;

/**
 * <h1>The class ControllerFacade.</h1>
 * 
 * implements the interface IController
 * 
 * @author Emilien BRUN
 * @version 2.0
 */
public class ControllerFacade implements IController {

   /**
    * The instanciation of the view
    */
    private final IView  view;
   
    /**
     * The blue player
     */
    private Player blue;
    
    /**
     * The red player
     */
    private Player red;
    
    /**
     * the boolean game over
     */
    private boolean gameOver = false;
    
    /**
     * The play time
     */
    private double time = 0;
    
    /**
     * Get the instenciation of the view
     * @return	view
     */
	public IView getView() {
		return this.view;
	}
	
	   /**
	    * Get the instanciation of the model
	    * @return model
	    */
	public IModel getModel() {
		System.out.println("je demande le model");
	    return this.model;
	}
   
	/**
	 * The instanciation of the model
	 */
    private final IModel model;

    
 
    
    /**
     * launch the code
     * @throws SQLException
     */
    public void start() throws SQLException {
    	System.out.println("LANCEMENT DU CONTROLLER");
      
    	System.out.println("creation de red control");
       this.red = new Player("Red", 300, 450, Direction.HAUT, model);
       System.out.println("creation de blue control");
       this.blue = new Player("Blue", 100, 150, Direction.BAS, model);
       
       view.initialisation();
       
       System.out.println("initialisation de la map demandé");
       model.initialisationMap();
       
       // JEU
       boolean collision;
       int nb = 20;
       System.out.println("on entre dans le jeu");
      long  start = 0;
       while(!gameOver) {
    	 
    	   if(view.RecupHave() == true) {
    		   if(view.RecupJoueur() == "Blue") {
    			   if(view.RecupOrdre() == "Droite") {
    				   traitementOrdre("Blue","Droite");
    			   } else {
    				   traitementOrdre("Blue","Gauche");
    			   }			   
    				  
    		   }else {
    			   if(view.RecupOrdre() == "Droite") {
    				   traitementOrdre("Red","Droite");
    			   } else {
    				   traitementOrdre("Red","Gauche");
    			   }			   
    				  
    		   }
    		   view.getClavier().setHaveOrdre(false);
    	   }
    	   
    	   
    	   start=System.nanoTime();
    	  if((System.nanoTime()-start)>600000)
    	   {
    		  time = System.nanoTime()/1000000000;
    		   view.refresh();
    		  
    		   System.out.println("c'est le temps de jouer!");
	    	  nb++;
	    	  System.out.println("deplacement de blue");
	    	  collision =  deplacement(blue);
	    	  if (collision) {
	    		  System.out.println("blue a eut une collision");
	    		  System.out.println("model game over demandé");
	    		  model.gameOver("Red", time);
	    		  System.out.println("view game over demandé");
	    		  view.gameOver("Red", time);
	    		  
	    		 // break;
	    	  }
	    	  view.refresh();
	    	  
	    	  System.out.println("deplacement de red");
	    	  collision = deplacement(red);
	    	  if (collision) {
	    		  System.out.println("red a eut une collision");
	    		  System.out.println("model game over demandé");
	    		  model.gameOver("Blue", time);
	    		  System.out.println("view game over demandé");
	    		  view.gameOver("Blue", time);
	    		  //break;
	    	  }
	    	  view.refresh();
	    	  
	    	  
	    	  
	    	  
    	  
    	   }
       }
         
   }
    
    /**
     * deplacement.
     * The move of the player
     * @param joueur
     * @return boolean
     * 			true if collision else false
     */
    private boolean deplacement(Player joueur) {
    	System.out.println("un joueur se deplace");
		boolean collision;
		
    	switch(joueur.getDirection()) {
    	case HAUT:
    		System.out.println("vers le haut");
			joueur.setY(joueur.getY()+1);
			
		break;
		
		case BAS:
			System.out.println("vers le bas");
			joueur.setY(joueur.getY()-1);
			
		break;
		
		case DROITE:
			System.out.println("vers la droite");
			joueur.setX(joueur.getX()+1);
			
		break;
		
		case GAUCHE:
			System.out.println("vers la gauche");
			joueur.setX(joueur.getX()-1);
			
		break;
    	}
    	
    	System.out.println("y a t'il une collsion?");
    	collision = checkCollision(joueur);
    	
		if(!collision) {
			System.out.println("non, donc nous créons un mur");
			model.setMap(joueur.getCouleur(), joueur.getX(), joueur.getY());	
			System.out.println("JE VEUX UPDATE LA VUE");
			view.getTable().Ajoute(joueur.getCouleur(), joueur.getX(), joueur.getY());
		}
		return collision;
		
	}

    /**
     * Check the collision for each player
     * @param joueur
     * @return boolean collision
     */
	private boolean checkCollision(Player joueur) {
		System.out.println("je reguarde si il y a eut une collision");
		int posX = joueur.getX();
		int posY = joueur.getY();
		
		if ( model.getMap(posX, posY) == null) {
			System.out.println("il n'y a pas de collision");
			return false;
		} else {
			System.out.println("il y a une collision");
			return true;
		}
		
	}

	/**
	 * the constructor of ControllerFacade
	 * @param view
	 * @param model
	 */
	public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }
    
	/**
	 * demanderGauche return the new direction of the player who turn to left 
	 * 
	 * @param joueur
	 * @return direction
	 */
    private Direction demanderGauche(Player joueur) {
    	System.out.println("c'est par ou la gauche?");
		
    	switch(joueur.getDirection()) {
    	
    	case HAUT :
    		System.out.println("je vais vers le haut du coup c'est a gauche");
    		return Direction.GAUCHE;
    		
    	case BAS :
    		System.out.println("je vais vers le bas du coup c'est a droite");
    		return Direction.DROITE;
    	
    	case DROITE:
    		System.out.println("je vais a droite du coup c'est en haut");
    		return Direction.HAUT;
    		
    	case GAUCHE:
    		System.out.println("je vais a gauche du coup c'est en bas");
    		return Direction.BAS;
    	
    	default :
    		return Direction.HAUT;
    	}
		
		
	}
    
    /**
     * demanderDroite return the new direction of the player who turn tu right
     * @param joueur
     * @return direction
     */
	private Direction demanderDroite(Player joueur) {
		System.out.println("c'est par ou la droite?");
		// TODO Auto-generated method stub
		switch(joueur.getDirection()) {
    	
    	case HAUT :
    		System.out.println("je vais vers le haut du coup c'est a droite");
    		return Direction.DROITE;
    		
    	case BAS :
    		System.out.println("je vais vers le bas du coup c'est a gauche");
    		return Direction.GAUCHE;
    	
    	case DROITE:
    		System.out.println("j evais a droite du coup c'est vers le bas");
    		return Direction.BAS;
    		
    	case GAUCHE:
    		System.out.println("je vais vers la gauche du coup c'est vers le haut");
    		return Direction.HAUT;
    	
    	default :
    		
    		return Direction.HAUT;
    	}
	}
	
	/**
	 * traitementOrdre receive an order and execute him
	 * 
	 * @param joueur
	 * @param ordre
	 */
    public void traitementOrdre(String joueur, String ordre) {
    	System.out.println("je traite les ordres");
    	Direction commande;
    	
    	if (joueur == "Blue") {
    		System.out.println("c'est un ordre de blue");
    		
    		if (ordre == "Droite") {
    			System.out.println("il tourne a droite");
    			
    			commande = demanderDroite(blue);
    			
    		} else {
    			System.out.println("il tourne a gauche");
    			commande = demanderGauche(blue);
    			
    		}
    		
    		System.out.println("je lui donne ca nouvelle direction");
    		blue.setDirection(commande);
    	} else {
    		System.out.println("c'est un ordre de red");
    		if (ordre == "Droite") {
    			System.out.println("il tourne a droite");
    			
    			commande = demanderDroite(red);
    			
    		} else {
    			System.out.println("il tourne a gauche");
    			commande = demanderGauche(red);
    			
    		}
    		System.out.println("je lui donne ca nouvelle direction");
    		red.setDirection(commande);
    	}
    }
    
    
    
}
