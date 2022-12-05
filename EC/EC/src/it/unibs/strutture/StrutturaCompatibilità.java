package it.unibs.strutture;

import java.util.ArrayList;

public interface StrutturaCompatibilità {
	
	//InizializzaColonna aggiunge il numero di false = lunghezzaColonna
	public void inizializzaColonna(int lunghezzaColonna);
	//getValoreCella ricordarsi che gli indici di riga e colonna partono da 0
	public boolean getValoreCella(int colonna,int riga);
	//getValoreCella ricordarsi che gli indici di riga e colonna partono da 0
	public void setValoreCella(int colonna,int riga, boolean valore);
	
	//restituisce gli indici che sono true all'interno della sotto collezione
	public ArrayList<Integer> getIndiciTrueSottoCollezione(int riga_iniziale,int riga_finale,int colonna);
	
	public String toString();
}
