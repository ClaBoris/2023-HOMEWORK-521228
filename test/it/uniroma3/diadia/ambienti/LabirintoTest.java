package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {
	
	private Labirinto lab; 
	private Stanza curr;
	private Stanza vinc;
	
	@Before
	public void setUp() {
		this.lab = new Labirinto();
		this.curr = new Stanza("n11");
		this.vinc = new Stanza("biblioteca");
		
		this.lab.setStanzaCorrente(curr);
		this.lab.setStanzaVincente(vinc);
	}
	
	@Test
	public void testGetStanzaCorrente() {
		assertEquals(curr, this.lab.getStanzaCorrente());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals(vinc, this.lab.getStanzaVincente());
	}
     
}
