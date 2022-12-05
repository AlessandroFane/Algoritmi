package it.unibs.inputOutput;

import java.io.BufferedReader;
import java.io.BufferedWriter; 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import it.unibs.mainPackage.Riassunto;

import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
public class Input_Output {

	
	public static ArrayList<ArrayList<Boolean>> leggiMatrice(String percorso) throws FileNotFoundException {
		
		ArrayList<ArrayList<Boolean>> matriceInput=new ArrayList<ArrayList<Boolean>>();
		//Scanner scan = new Scanner(System.in);
		//String inputFileName = scan.next();
		File file = new File(percorso);
		Scanner in = new Scanner(file);
		boolean booleano=false;
		String riga;
		while (in.hasNextLine()) {
			
			if(in.hasNext(";;;")) {
				//System.out.println("bellaa");
				riga=in.nextLine();
				continue;
			}
			
			ArrayList<Boolean> linea = new ArrayList<Boolean>();
			int num_val_dominio=0;
			while(in.hasNextInt()) {
				int valore=in.nextInt();
				//System.out.println(">>>>"+valore);
				num_val_dominio++;
				if(valore==1) {
					booleano = true;
				}
				else if(valore==0) {
					booleano = false;
				}
				else {
					System.out.println("ERRORE:preso valore diverso da 0 e da 1");
				}
				linea.add(booleano);
			}
			if(Riassunto.getCardinalità_dominio()==0) {
				Riassunto.setCardinalità_dominio(num_val_dominio);
			}
			else {
				if(Riassunto.getCardinalità_dominio()!=num_val_dominio) {
					System.out.println("ERRORE");
				}
			}
			if (!linea.isEmpty()) {
				matriceInput.add(linea);
			}
			
			in.nextLine();
		}
		return matriceInput;
	}

	public static void scriviFile(String percorso,String rigaSuccessiva) throws IOException{
		
		BufferedWriter out=new BufferedWriter(new FileWriter(percorso, true));
		try {			
			out.write(rigaSuccessiva+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			    if (out != null) {
			        out.close();
			    }
			}
		
	}
	
	
	 public static void copiaFileIngresso(Path percorsoSrc, Path percorsoDest) throws IOException {
	        Files.copy(percorsoSrc, percorsoDest, StandardCopyOption.REPLACE_EXISTING);
	    }
	 
	 public static void modificaFileIngresso(String percorso) throws IOException
	 {
		    File origine = new File(percorso);
		    File temp = new File("File\\File_Ingresso_Modificati\\file_temp.txt");
			FileWriter fw = new FileWriter(temp);
			FileReader fr = new FileReader(origine);
			BufferedReader br = new BufferedReader(fr);
			BufferedWriter bw = new BufferedWriter(fw);
			String lineaModificata="";
			int count=1;
			
			String riga; // controlla
			
			while((riga=br.readLine())!= null && riga.substring(0, 3).equals(";;;"))
			{
					System.out.println(("riga non calcolata:  "+ riga));
					bw.write(riga);
					bw.newLine();
			}
			lineaModificata= riga +" ;;;"+ count;
			count++;
			bw.write(lineaModificata);
			bw.newLine();
			while ((riga=br.readLine())!= null && !riga.isEmpty())
			{
				lineaModificata= riga +" ;;;"+ count;
				count++;
				bw.write(lineaModificata);
				bw.newLine();
			}
			 br.close();
			 bw.close();
			 origine.delete();
			 temp.renameTo(origine);
			
	 }


	 
	
		
		
	
	 

	     

}
