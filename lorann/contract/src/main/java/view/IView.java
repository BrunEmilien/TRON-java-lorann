package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.IController;
import model.IModel;

/**
 * <h1>The Interface IView.</h1>
 *
 * @author Emilien BRUN
 * @version 2.0
 */
public interface IView {

	public Panneau getPan();
	public void setPan(Panneau pan);
	public Table getTable();
		public void setTable(Table table);
		public void gameOver(String winner, double time);
		public void initialisation();
		public void displayMessage(String message);
		public void initialisation(IModel model);
		public void affichage();
		public void refresh();
		public boolean RecupHave();
		public String RecupJoueur();
		public String RecupOrdre();
		public Clavier getClavier();
}
