package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	//per impostare la stanza adiacente (true)
	public Stanza st1;
	public Stanza st2;
	
	//per vedere se la stanza ha l'attrezzo
	public Stanza stPiena;
	public Attrezzo martello;
	
	//per aggiungere l'attrezzo
	public Stanza stVuota;
    public Attrezzo ascia;	
	
	@Before
	public void setUp() {
		//
		this.st1 = new Stanza("biblioteca");
		this.st2 = new Stanza("n8");
		st1.impostaStanzaAdiacente("nord", st2);
		//
		this.stPiena = new Stanza("stPiena");
		this.martello = new Attrezzo("Martello",3);
		this.stPiena.addAttrezzo(martello);
		//
		this.stVuota=new Stanza("stVuota");
		this.ascia=new Attrezzo("Ascia",5);
	}
	
	@Test
	public void testStanzaAdiacenteNord() {
		assertSame(st2,st1.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testHasAttrezzo() {
		assertTrue("martello",this.stPiena.hasAttrezzo("Martello"));
	}
	
    @Test
    public void testAddAttrezzo() {
    	assertEquals(true,this.stVuota.addAttrezzo(ascia));
    }
	
}
