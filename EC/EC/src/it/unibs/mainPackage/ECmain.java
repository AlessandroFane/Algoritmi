package it.unibs.mainPackage;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import it.unibs.inputOutput.Input_Output;
import it.unibs.strutture.MatriceB;
import it.unibs.strutture.StrutturaCompatibilità;

public class ECmain {

	// static final boolean[][] matriceInput =
	// {{false,false,true,false,false},{true,true,false,true,false},{false,true,true,true,true},{false,false,false,false,true},{true,true,true,false,false},{false,false,false,true,true}};
	// static final boolean[][] matriceInput =
	// {{true,false,true,false,false,false,false,false,false,true},{false,false,false,true,false,false,true,true,true,false},{false,true,false,true,false,false,false,true,false,false},{false,true,false,false,true,true,false,false,false,false},{false,false,false,false,true,true,true,false,true,false},{false,true,true,false,false,false,false,false,false,true},{true,false,false,false,true,true,false,false,false,false},{true,false,false,true,false,false,false,true,false,false}};
	// static final boolean[][] matriceInput =
	// {{false,false,false,false,false,false,false,false,false,false},{false,false,false,true,false,false,true,true,true,false},{false,false,false,false,false,false,false,false,false,false},{true,true,true,true,true,true,true,true,true,true},{false,true,true,true,true,true,true,true,true,true},{true,true,true,true,true,true,true,true,true,false},{true,false,false,false,true,true,false,false,false,false},{true,true,true,true,true,true,true,true,true,true}};
	// static final boolean[][] matriceInput =
	// {{false,false,false,false,false,false,false,false,false,false},{false,false,false,true,false,false,true,true,true,false},{true,true,true,false,true,true,false,false,false,false},{true,true,true,true,true,true,true,true,true,true},{false,true,true,true,true,true,true,true,true,true},{true,true,true,true,true,true,true,true,true,false},{false,false,false,false,false,false,false,false,false,true},{true,true,true,true,true,true,true,true,true,true}};

	// static final ArrayList<ArrayList<Boolean>> matriceInput =
	// Input_Output.leggiMatrice("C:\\Users\\aless\\eclipse-workspace\\Sudoku\\File_Ingresso\\File_1.txt");

	static final String NOME_CARTELLA = "File1_sudoku";
	static ArrayList<ArrayList<Boolean>> matriceInput;
	static final ArrayList<ArrayList<Integer>> cov = new ArrayList<ArrayList<Integer>>();
	static final StrutturaCompatibilità B = new MatriceB();
	static final ArrayList<Integer> mappatura = new ArrayList<Integer>();
	static final String FILE_OUTPUT = "File\\File_Uscita\\" + NOME_CARTELLA + ".txt";
	static final String FILE_OUTPUT_PLUS = "File\\File_Uscita\\" + NOME_CARTELLA + "_PLUS.txt";

	static final String FILE_MODIFICATO = "File\\File_Ingresso_Modificati\\" + NOME_CARTELLA + ".txt";
	static final String FILE_MODIFICATO_PLUS = "File\\File_Ingresso_Modificati\\" + NOME_CARTELLA + "_PLUS.txt";
	static final Path pathSrc = Paths.get("File\\File_Ingresso\\" + NOME_CARTELLA + ".txt");
	static final Path pathDest = Paths.get(FILE_MODIFICATO);
	static final Path pathDestPlus = Paths.get(FILE_MODIFICATO_PLUS);

	public static void main(String[] args) {
		double[][] values;
		Instant inst1 = Instant.now();
		Riassunto.aggiungiElemento_distribuzione_partizioni_in_uscita();
		ArrayList<Integer> cardinalita = new ArrayList<Integer>();
		//boolean ec = true;
		boolean ec= Boolean.parseBoolean(args[0]);
		System.out.println("Algoritmo ec = "+ ec);
		String file_uscita = FILE_OUTPUT;
		if (!ec) {
			file_uscita = FILE_OUTPUT_PLUS;
		}
		Bottone bottone = new Bottone();
		bottone.inizializzaBottone();
		File path = new File(file_uscita);
		path.delete();
		// File copiaFileIngresso = new File(NOME_CARTELLA+".txt");
		if(ec)
		{
			try {
				Input_Output.copiaFileIngresso(pathSrc, pathDest);
				System.out.println("File copied successfully.");
				Input_Output.modificaFileIngresso(FILE_MODIFICATO);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else
		{
			try {
				Input_Output.copiaFileIngresso(pathSrc, pathDestPlus);
				System.out.println("File copied successfully.");
				Input_Output.modificaFileIngresso(FILE_MODIFICATO_PLUS);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		int numero_colonna = -1;

		ArrayList<Integer> intersezioneIndici = new ArrayList<Integer>();
		ArrayList<Boolean> unione = new ArrayList<Boolean>();
		int cardinalitaU = 0;
		try {
			matriceInput = Input_Output.leggiMatrice("File\\File_Ingresso\\" + NOME_CARTELLA + ".txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (!ec) {
			Riassunto.inizializzaCardinalitaDominio();
		}

		// System.out.println(matriceInput[2].length);
		for (int i = 0; i < matriceInput.size(); i++) {
			System.out.println("Indice di riga... "+i);
			boolean valore = matriceInput.get(i).get(0);
			boolean diverso = false;

			Riassunto.aggiungiElemento_distribuzione_partizioni_in_uscita();
			Riassunto.setNumero_insiemi(i + 1);
			for (int j = 1; j < matriceInput.get(i).size(); j++) {
				if (matriceInput.get(i).get(j) != valore)
					diverso = true;
			}
			if (diverso == false) {
				if (valore) {
					// aggiungi valore a COV riga 6
					if (!ec) {
						Riassunto.setValore_distribuzione_cardinalita_in_ingresso(Riassunto.getCardinalità_dominio());
					}
					ArrayList<Integer> sol = new ArrayList<Integer>();
					sol.add(i + 1);
					salvaOutputSenzaMappatura(sol,file_uscita);

				}
				else {
					if (!ec) {
						Riassunto.setValore_distribuzione_cardinalita_in_ingresso(0);
					}
				}
				continue;
			} else {
				mappatura.add(i);
			}

			numero_colonna = numero_colonna + 1; // numero colonne che non son vuote e non son nulle
			// in B aggiungere la colonna relativa a i riga 8
			B.inizializzaColonna(numero_colonna);
			Riassunto.setNum_nodi_totali(Riassunto.getNum_nodi_totali() + (int) Math.pow(2, numero_colonna));
			Riassunto.setNumero_nodi_visitati(Riassunto.getNumero_nodi_visitati() + 1); // Aggiunge le radici

			if (!ec) {

				Riassunto.setValore_distribuzione_cardinalita_in_ingresso(Utilita.contaTrue(matriceInput.get(mappatura.get(numero_colonna))));
				cardinalita.add(Utilita.contaTrue(matriceInput.get(mappatura.get(numero_colonna))));
			}

			for (int j = 0; j < numero_colonna; j++) {
				Riassunto.setNumero_nodi_visitati(Riassunto.getNumero_nodi_visitati() + 1); // Aggiunge i nodi aventi
																							// due indici
				if (!(Utilita.intersezione(matriceInput.get(mappatura.get(numero_colonna)),
						matriceInput.get(mappatura.get(j))).contains(true))) {
					ArrayList<Integer> indici = new ArrayList<Integer>();

					indici.add(numero_colonna);
					indici.add(j);
					boolean booleanociclo = false;
					if (!ec) {
						cardinalitaU = cardinalita.get(numero_colonna) + cardinalita.get(j);
						booleanociclo = (cardinalitaU == Riassunto.getCardinalità_dominio());
					} else {
						unione.clear();
						unione = Utilita.unione(matriceInput.get(mappatura.get(numero_colonna)),
								matriceInput.get(mappatura.get(j)));
						booleanociclo = !(unione.contains(false));
					}

					if (booleanociclo) {
						salvaOutput(indici,file_uscita);

					} else {
						B.setValoreCella(numero_colonna, j, true);
						intersezioneIndici.clear();
						if (j - 1 >= 0) {
							intersezioneIndici = Utilita.intersezioneInteger(
									B.getIndiciTrueSottoCollezione(0, j - 1, numero_colonna),
									B.getIndiciTrueSottoCollezione(0, j - 1, j));
							if (!intersezioneIndici.isEmpty()) {
								Riassunto.setNumero_nodi_visitati(Riassunto.getNumero_nodi_visitati() + 1);
								if (!ec) {
									esploraPlus(indici, cardinalitaU, intersezioneIndici);
								} else {
									esplora(indici, unione, intersezioneIndici);
								}

							}
						}
					}
				}
			}
		}

		System.out.println(B.toString());
		System.out.println(cov);
		System.out.println(Riassunto.stampa());
		try {
			Input_Output.scriviFile(file_uscita, Riassunto.stampa());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Instant inst2 = Instant.now();
		System.out.println("Elapsed Time: " + Duration.between(inst1, inst2).toString());
		System.exit(0);
	}

	public static void esplora(ArrayList<Integer> indici, ArrayList<Boolean> unione,
			ArrayList<Integer> intersezioneIndici) {
		ArrayList<Boolean> utemp = new ArrayList<Boolean>();
		ArrayList<Integer> itemp = new ArrayList<Integer>();
		ArrayList<Integer> intertemp = new ArrayList<Integer>();
		for (int k = 0; k < intersezioneIndici.size(); k++) {
			itemp = (ArrayList<Integer>) indici.clone();
			itemp.add(intersezioneIndici.get(k));
			utemp = Utilita.unione(unione, matriceInput.get(mappatura.get(intersezioneIndici.get(k))));
			if (!utemp.contains(false)) {
				salvaOutput(itemp,FILE_OUTPUT);
			} else {
				intertemp = Utilita.intersezioneInteger(intersezioneIndici,
						B.getIndiciTrueSottoCollezione(0, intersezioneIndici.get(k) - 1, intersezioneIndici.get(k)));

				if (!intertemp.isEmpty()) {
					Riassunto.setNumero_nodi_visitati(Riassunto.getNumero_nodi_visitati() + 1); // Aggiunge i nodi
																								// aventi più di due
																								// indici
					esplora(itemp, utemp, intertemp);
				}
			}
		}
	}

	public static void esploraPlus(ArrayList<Integer> indici, int cardU, ArrayList<Integer> intersezioneIndici) {
		int cardtemp = -1;
		ArrayList<Integer> itemp = new ArrayList<Integer>();
		ArrayList<Integer> intertemp = new ArrayList<Integer>();
		for (int k = 0; k < intersezioneIndici.size(); k++) {
			itemp = (ArrayList<Integer>) indici.clone();
			itemp.add(intersezioneIndici.get(k));
			cardtemp = cardU + Utilita.contaTrue(matriceInput.get(mappatura.get(intersezioneIndici.get(k))));
			if (cardtemp == Riassunto.getCardinalità_dominio()) {
				salvaOutput(itemp,FILE_OUTPUT_PLUS);
			} else {
				intertemp = Utilita.intersezioneInteger(intersezioneIndici,
						B.getIndiciTrueSottoCollezione(0, intersezioneIndici.get(k) - 1, intersezioneIndici.get(k)));

				if (!intertemp.isEmpty()) {
					Riassunto.setNumero_nodi_visitati(Riassunto.getNumero_nodi_visitati() + 1); // Aggiunge i nodi
																								// aventi più di due
																								// indici
					esploraPlus(itemp, cardtemp, intertemp);
				}
			}
		}
	}
	
	public static void salvaOutput(ArrayList<Integer> itemp, String file_uscita) {
		for (int i = 0; i < itemp.size(); i++) {
			itemp.set(i, (mappatura.get(itemp.get(i))) + 1);
		}
		salvaOutputSenzaMappatura(itemp,file_uscita);
	}
	
	public static void salvaOutputSenzaMappatura(ArrayList<Integer> itemp, String file_uscita) {
		cov.add(itemp);
		Riassunto.setNumero_partizioni_in_uscita(cov.size());
		System.out.println(itemp.toString());
		Riassunto.setDistribuzione_partizioni_in_uscita(itemp.size());
		try {
			Input_Output.scriviFile(file_uscita, itemp.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


