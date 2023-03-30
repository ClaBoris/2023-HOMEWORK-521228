package it.uniroma3.diadia;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
/**
 * Classe ideata per eseguire i test della classe Partita;
 * @author Claudia Borsani
 *
 */

public class PartitaTest {
	
	//
    public Labirinto lab1; 
    public Stanza curr;
    public Partita pt1;
    //
    public Partita pt2;
    //
    public Partita pt3;
    //
    public Partita pt4;
    //
    public Partita pt5;
    
    @Before
    public void setUp() {
    	
    	//per vedere se è vinta curr!=vincente
    	pt1=new Partita();
    	this.lab1 = new Labirinto();
    	this.curr = new Stanza("StCurr"); 
    	this.pt1.getLabirinto().setStanzaCorrente(curr);
    	
    	//per vedere se è vinta curr==vincente
    	pt2=new Partita();
    	this.pt2.getLabirinto().setStanzaCorrente(this.pt2.getLabirinto().getStanzaVincente());
    	
    	//per vedere se è vinta curr==null
    	this.pt3 = new Partita();
    	
    	//per vedere se è finita (true) 
    	this.pt4=new Partita();
    	this.pt4.getGiocatore().setCfu(0);
    	
    	//per vedere se è finita (false)
    	this.pt5=new Partita();
    	this.pt5.getGiocatore().setCfu(1);
    }
    
    @Test
    public void testIsNotVinta() {
    	assertEquals(false, this.pt1.vinta());
    }
    
    @Test
    public void testIsVinta() {
    	assertEquals(true, this.pt2.vinta());
    }
    
    @Test
    public void testInVintaNull() {
    	assertEquals(false, this.pt3.vinta());
    }
    
    @Test
    public void testIsFinita() {
    	assertEquals(0, this.pt4.getGiocatore().getCfu());
    }
    
    @Test
    public void testInNotFinita() {
    	assertFalse(this.pt5.isFinita());
    }
}
