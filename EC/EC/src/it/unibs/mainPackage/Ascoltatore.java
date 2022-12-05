package it.unibs.mainPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


import it.unibs.inputOutput.Input_Output;

public class Ascoltatore implements ActionListener{



	
	static final String FILE_OUTPUT = ECmain.FILE_OUTPUT;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
		try {
			Input_Output.scriviFile(FILE_OUTPUT, Riassunto.stampa());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Stampa Stato
		System.exit(0);
	}
}
