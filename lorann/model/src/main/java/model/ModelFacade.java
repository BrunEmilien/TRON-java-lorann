package model;

import java.sql.SQLException;
import java.util.List;


import model.dao.ExampleDAO;
import view.IView;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author EmilienBRUN
 * @version 2.0
 */
public final class ModelFacade implements IModel {

	private int time;
	MapElements Map[][] = new MapElements[400][600];
	private String winner;

	
	
	public int getTime() {
		System.out.println("je demande le temps");
		return time;
	}
	public void setTime(int time) {
		System.out.println("je donne le temps");
		this.time = time;
	}
	public MapElements getMap(int x, int y) {
		//System.out.println("je demande ce qu'il y a dans la case " + x + " / " + y);
		return Map[x][y];
		
		
	}
	
	public String getWinner() {
		System.out.println("je demande le gagnant");
		return winner;
	}
	public void setWinner(String winner) {
		System.out.println("je donnele gagnant est " + winner);
		this.winner = winner;
	}


	
	
	public void setMap(String couleur, int x, int y) {
		System.out.println("je donne ce qu'il y a dans la case " + x + " / " + y);
		Map[x][y] = new Wall(couleur, x, y);
	}
	
    
	/**
     * Instantiates a new model facade.
     */
    public ModelFacade() {
    	super();
    	System.out.println("je suis model");
        
        start();
    }

    
    
    
    
  
    	
    	
    
    
    
    
    
    
	
	
	
	@Override
	public Example getExampleById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Example getExampleByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Example> getAllExamples() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void initialisationMap() {
		// TODO Auto-generated method stub
		System.out.println("initialisation de la map");
		// TODO Auto-generated method stub
    	System.out.println("création de blue");
		
		setMap("Blue", 100, 150);
		System.out.println("creation de red");
		
		setMap("Red", 300, 450);
		
		System.out.println("creation des murs de protection");
		int i = 0;
		System.out.println("protection axe Y");
		for (i = 0; i < 599; i++) {
			setMap("Black", 0, i);
			setMap("Black", 399, i);
		}
		System.out.println("protection axe X");
		for (i = 0; i < 399; i++) {
			setMap("Black", i, 0);
			setMap("Black", i, 599);
		}
		
	}
	@Override
	public void deplacement(String couleur, int x, int y) {
		System.out.println("model deplacement");
		// TODO Auto-generated method stub
		
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("LANCEMENT DU MODEL");
		setTime(0);
		setWinner("");
	}
	@Override
	public void gameOver(String winner, double time) {
		System.out.println("game over du model:");
		// envoie des données a la BDD
		System.out.println("envoie des données dans la BDD");
	}
	
	
}
