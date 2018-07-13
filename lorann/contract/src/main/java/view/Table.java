package view;

import java.util.ArrayList;

public class Table {

    private ArrayList tableMur;
    
    public Table() {
    	setTableMur(new ArrayList());
    }
    
	public void Ajoute(String couleur, int x, int y) {
		// TODO Auto-generated method stub
		tableMur.add(couleur);
		tableMur.add(x);
		tableMur.add(y);
	}

	public ArrayList getTableMur() {
		return tableMur;
	}

	public void setTableMur(ArrayList tableMur) {
		this.tableMur = tableMur;
	}
	
	public int getMax() {
		return tableMur.size();
		
	}

}
