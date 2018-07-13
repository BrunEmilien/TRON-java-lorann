package controller;

import java.sql.SQLException;

import model.IModel;
import view.IView;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Emilien BRUN
 * @version 2.0
 */
public interface IController {

		public IView getView();
		public IModel getModel();
	    public void start() throws SQLException;
	   
	    public void traitementOrdre(String joueur, String ordre);

}
