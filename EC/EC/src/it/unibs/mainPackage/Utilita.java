package it.unibs.mainPackage;

import java.util.ArrayList;

public class Utilita {
	
	
	public static int contaTrue(ArrayList<Boolean> riga) {
		int risultato=0;
		for(int i=0;i<riga.size();i++) {
			if(riga.get(i)==true) {
				risultato++;
			}
		}
		return risultato;
		
	}
	public static ArrayList<Boolean> intersezione(boolean[] matriceInput, boolean[] matriceInput2) {
		ArrayList<Boolean> risultato= new ArrayList<Boolean>();
		for(int i=0;i< matriceInput.length;i++) {
			risultato.add( matriceInput[i] && matriceInput2[i]);
		}
		return risultato;
	}
	
	public static ArrayList<Boolean> intersezione(ArrayList<Boolean> matriceInput, ArrayList<Boolean> matriceInput2) {
		ArrayList<Boolean> risultato= new ArrayList<Boolean>();
		for(int i=0;i< matriceInput.size();i++) {
			risultato.add( matriceInput.get(i) && matriceInput2.get(i));
		}
		return risultato;
	}
	

	public static ArrayList<Integer> intersezioneInteger(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
		ArrayList<Integer> risultato = new ArrayList<Integer>();
		for(int i=0;i< lista1.size();i++) {
			if (lista2.contains(lista1.get(i))) {
				risultato.add(lista1.get(i));
			}
		}
		return risultato;
	}
	
	
	
	
	
	public static ArrayList<Boolean> unione(boolean [] lista1, boolean [] lista2) {
		ArrayList<Boolean> risultato= new ArrayList<Boolean>();
		for(int i=0;i< lista1.length;i++) {
			risultato.add( lista1[i] || lista2[i]);
		}
		return risultato;
	}
	public static ArrayList<Boolean> unione(ArrayList<Boolean> matriceInput, ArrayList<Boolean> matriceInput2) {
		ArrayList<Boolean> risultato= new ArrayList<Boolean>();
		for(int i=0;i< matriceInput.size();i++) {
			risultato.add( matriceInput.get(i) || matriceInput2.get(i));
		}
		return risultato;
	}

	public static ArrayList<Boolean> unione(ArrayList<Boolean> unione, boolean[] lista2) {
		ArrayList<Boolean> risultato= new ArrayList<Boolean>();
		for(int i=0;i< lista2.length;i++) {
			risultato.add( unione.get(i) || lista2[i]);
		}
		return risultato;
	}
	
}
