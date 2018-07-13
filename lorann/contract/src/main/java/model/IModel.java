package model;

import java.sql.SQLException;
import java.util.List;


/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Emilien BRUN
 * @version 2.0
 */
public interface IModel {

    /**
     * Gets the example by id.
     *
     * @param id
     *            the id
     * @return the example by id
     * @throws SQLException
     *             the SQL exception
     */
    Example getExampleById(int id) throws SQLException;

    /**
     * Gets the example by name.
     *
     * @param name
     *            the name
     * @return the example by name
     * @throws SQLException
     *             the SQL exception
     */
    Example getExampleByName(String name) throws SQLException;

    /**
     * Gets the all examples.
     *
     * @return the all examples
     * @throws SQLException
     *             the SQL exception
     */
    List<Example> getAllExamples() throws SQLException;
    
    /**
     * Set a Wall object on the Map
     * 
     * @param couleur
     * @param x
     * @param y
     */
    void setMap(String couleur, int x, int y);
    

    /**
     * initialisation of the map
     */
    void initialisationMap();
	
    /**
     * get the play's time
     * @return the time
     */
	int getTime();
	
	/**
	 * set the play's time
	 * @param time
	 */
	void setTime(int time);
	
	/**
	 * Get an MapElements on the map at the coordonees x/y
	 * @param x
	 * @param y
	 * @return MapElements
	 */
	MapElements getMap(int x, int y);
	
	/**
	 * Get the winner
	 * @return winner
	 */
	String getWinner();
	
	/**
	 * Set the winner
	 * @param winner
	 */
	void setWinner(String winner);

	/**
	 * The start of the model. 
	 * for launch the code
	 */
	void start();
	
	/**
	 * launch the Game over's code
	 * @param winner
	 * @param time
	 */
	void gameOver(String winner, double time);

	void deplacement(String couleur, int x, int y);
	

}
