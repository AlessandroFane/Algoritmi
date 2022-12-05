package it.unibs.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import it.unibs.mainPackage.Utilita;

class UtilitàTest {

	@Test
	public void testIntersezioneInteger() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> risultato = new ArrayList<Integer>();
		a.add(3);
		a.add(7);
		a.add(4);
		a.add(2);
		b.add(3);
		b.add(7);
		b.add(9);
		b.add(12);
		c=Utilita.intersezioneInteger(a, b);
		risultato.add(3);
		risultato.add(7);
		Assert.assertTrue(c.equals(risultato));
	}
	
	@Test
	public void testIntersezioneInteger1() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> risultato = new ArrayList<Integer>();
		a.add(3);
		a.add(7);
		a.add(4);
		a.add(2);
		b.add(12);
		b.add(3);
		b.add(9);
		b.add(7);
		c=Utilita.intersezioneInteger(a, b);
		risultato.add(3);
		risultato.add(7);
		Assert.assertTrue(c.equals(risultato));
	}
	
	@Test
	public void testIntersezioneInteger2() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> risultato = new ArrayList<Integer>();

		a.add(4);

		b.add(4);
		c=Utilita.intersezioneInteger(a, b);
		risultato.add(4);
		Assert.assertTrue(c.equals(risultato));
	}
	
	@Test
	public void testIntersezioneInteger3() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> risultato = new ArrayList<Integer>();


		c=Utilita.intersezioneInteger(a, b);
		Assert.assertTrue(c.equals(risultato));
	}
	
	@Test
	public void testIntersezioneInteger4() {
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		ArrayList<Integer> risultato = new ArrayList<Integer>();

		a.add(3);
		a.add(7);
		b.add(6);
		b.add(9);

		c=Utilita.intersezioneInteger(a, b);
		Assert.assertTrue(c.equals(risultato));
	}


}
