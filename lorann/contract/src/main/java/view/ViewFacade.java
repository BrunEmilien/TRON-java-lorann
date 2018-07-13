package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.IController;
import model.IModel;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade extends JFrame implements IView {

	private IModel model;
	private IController controller;
	private Panneau pan;
	private Table table;
	private Clavier clavier;
		
		public Panneau getPan() {
		return pan;
	}

	public void setPan(Panneau pan) {
		this.pan = pan;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

		/**
	     * Instantiates a new view facade.
	     */
	    public ViewFacade() {
	        super();
	        
	        System.out.println("je suis la view");
	        setTable(new Table());
	        initialisation();
	    }
	    JOptionPane jop1;
		public void gameOver(String winner, double time) {
			// TODO Auto-generated method stub
			System.out.println("le message de game over va s'afficher");
			// TODO Auto-generated method stub
			jop1 = new JOptionPane();
			System.out.println("1");
			jop1.showMessageDialog(null, "Le gagnant est " + winner + " en " + time + " secondes!", "VICTOIRE", JOptionPane.INFORMATION_MESSAGE);
			// JOptionPane.showMessageDialog(null, "Le gagnant est " + winner + " en " + time + " secondes!");
			System.out.println("2");
		
		}

		public void initialisation() {
			// TODO Auto-generated method stub
			
			System.out.println("je cree paneau");
			this.pan = new Panneau(table);
			setClavier(new Clavier());
			this.setTitle("TRON Game");
			this.setSize(600, 400);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setAlwaysOnTop(true);
			this.setFocusable(true);
			this.requestFocusInWindow();
			this.addKeyListener(getClavier());
			this.setContentPane(pan);
			
			this.setVisible(true);
			
		}

		public Clavier getClavier() {
			return clavier;
		}

		public void setClavier(Clavier clavier) {
			this.clavier = clavier;
		}

		@Override
		public void displayMessage(String message) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void initialisation(IModel model) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void affichage() {
			// TODO Auto-generated method stub
			
		}

		

		@Override
		public void refresh() {
			// TODO Auto-generated method stub
			System.out.println("JE REFRESH");
			pan.repaint();
			this.setContentPane(new Panneau(table));
			this.setVisible(true);
		}
 
		
		public boolean RecupHave() {
			return getClavier().isHaveOrdre();
		}
		
		public String RecupJoueur() {
			return getClavier().getCouleur();
			}
		
		public String RecupOrdre() {
			return getClavier().getOrdre();
		}
		
		
	
}
