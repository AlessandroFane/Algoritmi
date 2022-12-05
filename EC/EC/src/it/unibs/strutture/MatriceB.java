package it.unibs.strutture;

import java.util.ArrayList;

public class MatriceB implements StrutturaCompatibilità{

	private ArrayList<ArrayList<Boolean>> tabella=new ArrayList<ArrayList<Boolean>>();
	
	
	
	
	
	
	
	public MatriceB() {
		
	}

	public MatriceB(ArrayList<ArrayList<Boolean>> tabella) {
		this.tabella = tabella;
	}

	
	
	
	
	@Override
	public void inizializzaColonna(int lunghezzaColonna) {
		ArrayList<Boolean> colonna = new ArrayList<Boolean>();
		for(int i=1;i<=lunghezzaColonna;i++) {
			colonna.add(false);
		}
		tabella.add(colonna);
		
	}

	@Override
	public boolean getValoreCella( int colonna, int riga) {
		return tabella.get(colonna).get(riga);
	}
	@Override
	public void setValoreCella( int colonna, int riga, boolean valore) {
		tabella.get(colonna).set(riga, valore);
	}
	
	public ArrayList<Integer> getIndiciTrueSottoCollezione(int riga_iniziale,int riga_finale,int colonna){
		
		ArrayList<Boolean> b = tabella.get(colonna);
		ArrayList<Integer> soluzione=new ArrayList<Integer>();
		for(int i=riga_iniziale;i<=riga_finale;i++) {
			if (b.get(i)) {
				soluzione.add(i);
			}
		}
		return soluzione;
	}
	

	
	@Override
	public String toString() {
		return "MatriceB [tabella=" + tabella + "]";
	}

	public ArrayList<ArrayList<Boolean>> getTabella() {
		return tabella;
	}

	public void setTabella(ArrayList<ArrayList<Boolean>> tabella) {
		this.tabella = tabella;
	}


	

	
	
	
}
