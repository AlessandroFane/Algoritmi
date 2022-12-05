package it.unibs.test;


import java.util.ArrayList;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import it.unibs.strutture.MatriceB;
import it.unibs.strutture.StrutturaCompatibilità;



class StrutturaCompatibilitàTest {

	StrutturaCompatibilità tabella = new MatriceB();


	// Test del metodo toString()
	@Test
	public void testGetValoreCella() {
		Assert.assertTrue(tabella.toString().equals("MatriceB [tabella=" + "[]" + "]"));
	}
	
	// Test del metodo inizializzaColonna()
	@Test
	public void testInizializzaColonna0() {
		tabella.inizializzaColonna(0);
		Assert.assertTrue(tabella.toString().equals("MatriceB [tabella=" + "[[]]" + "]"));
	}
	@Test
	public void testInizializzaColonna1() {
		tabella.inizializzaColonna(0);
		tabella.inizializzaColonna(2);
		Assert.assertTrue(tabella.toString().equals("MatriceB [tabella=" + "[[], [false, false]]" + "]"));
	}
	@Test
	public void testInizializzaColonna2() {
		tabella.inizializzaColonna(0);
		tabella.inizializzaColonna(8);
		Assert.assertTrue(tabella.toString().equals("MatriceB [tabella=" + "[[], [false, false, false, false, false, false, false, false]]" + "]"));
	}
	
	@Test
	// Test setValoreCella()
	public void setValoreCella0() {
		tabella.inizializzaColonna(0);
		tabella.inizializzaColonna(8);
		tabella.setValoreCella(1, 2, true);
		Assert.assertTrue(tabella.toString().equals("MatriceB [tabella=" + "[[], [false, false, true, false, false, false, false, false]]" + "]"));
	}
	
	@Test
	public void setValoreCella1() {
		tabella.inizializzaColonna(0);
		tabella.inizializzaColonna(5);
		tabella.inizializzaColonna(6);
		tabella.inizializzaColonna(7);
		tabella.setValoreCella(1, 2, true);;
		tabella.setValoreCella(1, 2, false);
		tabella.setValoreCella(2, 2, false);
		tabella.setValoreCella(3, 3, true);
		tabella.setValoreCella(3, 6, true);
		Assert.assertTrue(tabella.toString().equals("MatriceB [tabella=" + "[[], [false, false, false, false, false], [false, false, false, false, false, false], [false, false, false, true, false, false, true]]" + "]"));
	}
	
	@Test
	// Test getValoreCella()
	public void getValoreCella0() {
		tabella.inizializzaColonna(0);
		tabella.inizializzaColonna(8);
		tabella.setValoreCella(1, 2, true);
		Assert.assertTrue(tabella.getValoreCella(1, 2)==true);
	}
	
	@Test
	public void getValoreCella1() {
		tabella.inizializzaColonna(0);
		tabella.inizializzaColonna(5);
		tabella.inizializzaColonna(6);
		tabella.inizializzaColonna(7);
		tabella.setValoreCella(2, 1, true);
		tabella.setValoreCella(2, 1, false);
		tabella.setValoreCella(2, 2, false);
		tabella.setValoreCella(3, 3, true);
		tabella.setValoreCella(3, 5, true);
		Assert.assertTrue(tabella.getValoreCella(2, 0)==false);
	}
	
	@Test
	// Test getIndiciTrueSottoCollezione()
	public void getSottoCollezione0() {
		tabella.inizializzaColonna(0);
		tabella.inizializzaColonna(8);
		tabella.setValoreCella(1, 2, true);
		ArrayList<Integer> soluzione=new ArrayList<Integer>();
		soluzione.add(2);
		Assert.assertTrue(tabella.getIndiciTrueSottoCollezione(2, 3, 1).equals(soluzione));
	}
	
	@Test
	public void getIndiciTrueSottoCollezione1() {
		tabella.inizializzaColonna(0);
		tabella.inizializzaColonna(5);
		tabella.inizializzaColonna(6);
		tabella.inizializzaColonna(3);
		tabella.inizializzaColonna(6);
		tabella.inizializzaColonna(3);
		tabella.setValoreCella(5, 2, true);
		//ArrayList<Integer> soluzione=new ArrayList<Integer>();
		Assert.assertTrue(tabella.getIndiciTrueSottoCollezione(1, 4, 1).isEmpty());
	}
	
	@Test
	public void getIndiciTrueSottoCollezione2() {
		tabella.inizializzaColonna(0);
		tabella.inizializzaColonna(5);
		tabella.inizializzaColonna(6);
		tabella.inizializzaColonna(3);
		tabella.inizializzaColonna(6);
		tabella.inizializzaColonna(3);
		tabella.setValoreCella(2, 5, true);
		ArrayList<Integer> soluzione=new ArrayList<Integer>();
		soluzione.add(5);
		Assert.assertTrue(tabella.getIndiciTrueSottoCollezione(5, 5, 2).equals(soluzione));
	}
	
	@Test
	public void getIndiciTrueSottoCollezione3() {
		tabella.inizializzaColonna(0);
		tabella.inizializzaColonna(3);
		tabella.inizializzaColonna(6);
		tabella.inizializzaColonna(3);
		tabella.inizializzaColonna(3);
		tabella.inizializzaColonna(6);
		tabella.inizializzaColonna(3);
		tabella.setValoreCella(5, 1, true);
		tabella.setValoreCella(5, 3, true);
		tabella.setValoreCella(5, 5, true);
		ArrayList<Integer> soluzione=new ArrayList<Integer>();
		soluzione.add(1);
		soluzione.add(3);

		Assert.assertTrue(tabella.getIndiciTrueSottoCollezione(0, 3, 5).equals(soluzione));
	}
	
	



}
