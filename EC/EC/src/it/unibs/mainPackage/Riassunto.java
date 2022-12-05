package it.unibs.mainPackage;

import java.util.ArrayList;

public class Riassunto {

	
	private static int numero_insiemi=0;
	private static int cardinalità_dominio=0;
	private static int numero_nodi_visitati=0;
	private static int numero_partizioni_in_uscita=0;
	private static ArrayList<Integer> distribuzione_partizioni_in_uscita=new ArrayList<Integer>();
	private static int num_nodi_totali=0;
	private static float percentuale_nodi_visitati=0;
	
	
	private static ArrayList<Integer> distribuzione_cardinalita_in_ingresso=new ArrayList<Integer>();
	
	
	
	
	
	
	public static void inizializzaCardinalitaDominio() {
		for (int i=0;i<=cardinalità_dominio;i++) {
			distribuzione_cardinalita_in_ingresso.add(0);
		}
	}
	public static void aggiungiElemento_distribuzione_partizioni_in_uscita() {
		distribuzione_partizioni_in_uscita.add(0);
	}
	
	
	
	public static int getNumero_insiemi() {
		return numero_insiemi;
	}
	public static void setNumero_insiemi(int numero_insiemi2) {
		numero_insiemi = numero_insiemi2;
	}
	public static int getCardinalità_dominio() {
		return cardinalità_dominio;
	}
	public static void setCardinalità_dominio(int cardinalità_dominio2) {
		cardinalità_dominio = cardinalità_dominio2;
	}
	public static int getNumero_nodi_visitati() {
		return numero_nodi_visitati;
	}
	public static void setNumero_nodi_visitati(int numero_nodi_visitati_) {
		numero_nodi_visitati = numero_nodi_visitati_;
		Riassunto.percentuale_nodi_visitati=((float)numero_nodi_visitati/(float)num_nodi_totali)*100;
	}
	public static int getNumero_partizioni_in_uscita() {
		return numero_partizioni_in_uscita;
	}
	public static void setNumero_partizioni_in_uscita(int numero_partizioni_in_uscita_) {
		numero_partizioni_in_uscita = numero_partizioni_in_uscita_;
	}

	
	
	
	public static ArrayList<Integer> getDistribuzione_partizioni_in_uscita() {
		return distribuzione_partizioni_in_uscita;
	}
	public static void setDistribuzione_partizioni_in_uscita(int chiave) {
		distribuzione_partizioni_in_uscita.set(chiave, distribuzione_partizioni_in_uscita.get(chiave)+1);
	}
	public static int getNum_nodi_totali() {
		return num_nodi_totali;
	}
	public static void setNum_nodi_totali(int num_nodi_totali_) {
		num_nodi_totali = num_nodi_totali_;
		percentuale_nodi_visitati=((float)numero_nodi_visitati/(float)num_nodi_totali)*100;
	}
	
	
	public static ArrayList<Integer> getDistribuzione_cardinalita_in_ingresso() {
		return distribuzione_cardinalita_in_ingresso;
	}

	public static void setValore_distribuzione_cardinalita_in_ingresso(int indice) {
		distribuzione_cardinalita_in_ingresso.set(indice, distribuzione_cardinalita_in_ingresso.get(indice)+1);
	}

	public static void setDistribuzione_cardinalita_in_ingresso(ArrayList<Integer> distribuzione_cardinalita_in_ingresso) {
		Riassunto.distribuzione_cardinalita_in_ingresso = distribuzione_cardinalita_in_ingresso;
	}

	

	public static String stampa() {
		String stringa=		";;; Riassunto [numero_insiemi=" + numero_insiemi 
							+ ", cardinalita'_dominio=" + cardinalità_dominio
							+ ", numero_nodi_visitati=" + numero_nodi_visitati 
							+ ", numero_nodi_totali=" + num_nodi_totali 
							+ ", percentuale_nodi_visitati=" + (String.format("%.02f", percentuale_nodi_visitati)) +"%"
							+ ", numero_partizioni_in_uscita=" + numero_partizioni_in_uscita
							+ ", distribuzione_partizioni_in_uscita=" + distribuzione_partizioni_in_uscita;

		if (!distribuzione_cardinalita_in_ingresso.isEmpty()) {
			stringa=stringa+ ", distribuzione_cardinalita_in_ingresso=" + distribuzione_cardinalita_in_ingresso + "]";
		}
		else {
			stringa=stringa+ "]";
		}
		
		return stringa;

	}
	
	
	
	
	
}
