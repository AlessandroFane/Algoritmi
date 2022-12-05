package it.unibs.mainPackage;


import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bottone{
	
	

	public void inizializzaBottone() {
		JButton button = new JButton("STOP");
		JFrame frame = new JFrame("JButton Demo");
		JPanel panel = new JPanel();
		panel.add(button);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		ActionListener a = new Ascoltatore();
		button.addActionListener(a);
	}



	
	
}
