package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;



public class GiocatoreTest {
	
	private  Giocatore giocatore;
	private Borsa borsa;
	
	
	@Before
	public void setUp() {
		
		this.giocatore = new Giocatore();
		this.giocatore.setCfu(120);
		this.borsa = new Borsa(10);
		this.giocatore.setBorsa(borsa);
		
	}
	
	@Test
	public void testGetCFU() {
		assertEquals(120,this.giocatore.getCfu());
	}
	
	@Test
	public void testGetBorsa() {
		assertEquals(borsa, this.giocatore.getBorsa());
	}
	
}
