package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
 //per aggiungere attrezzo nella borsa: il peso è coerente 
 private Attrezzo ascia;
 private Borsa b1;
 
 //per aggiungere attrezzo nella borsa: attrezzo troppo pesante
 private Attrezzo fucile;
 private Borsa b2;
 
 //per vedere se la borsa ha un attrezzo
 private Attrezzo spada;
 private Borsa b3;
 
 //per vedere se la borsa non ha un attrezzo
 private Attrezzo rivoltella;
 private Borsa b4;
 
 //per rimuovere l'attrezzo dalla borsa: l'attrezzo è presente nella borsa
 private Attrezzo tirapugni;
 private Borsa b5;
 
 //per rimuovere l'attrezzo dalla borsa: la borsa è vuota
 private Attrezzo coltello;
 private Borsa b6;
 
 
 @Before
 public void setUp() {
	 //
	 this.ascia = new Attrezzo("Ascia", 5);
	 this.b1= new Borsa(10);
	 this.b1.addAttrezzo(ascia);
	 //
	 this.fucile = new Attrezzo ("Fucile", 11);
	 this.b2 = new Borsa (10);
	 //
	 this.spada=new Attrezzo("Spada", 7);
	 this.b3 = new Borsa (8);
	 this.b3.addAttrezzo(spada);
	 //
	 this.rivoltella= new Attrezzo("Rivoltella",6);
	 this.b4 = new Borsa(7);
	 //
	 this.tirapugni = new Attrezzo("Tirapugni",1);
	 this.b5 = new Borsa(8);
	 this.b5.addAttrezzo(tirapugni);
	 //
	 this.coltello = new Attrezzo ("Coltello",1);
	 this.b6 = new Borsa(5);
 }
 
 @Test
 public void testAddAttrezzo() {
	 assertEquals(ascia,this.b1.getAttrezzo("Ascia"));
 }
  
 @Test
 public void testAddAttrezzoPesante() {
	 assertFalse(this.b2.addAttrezzo(fucile));
 }
 	
 @Test
 public void testHasAttrezzo() {
	 assertTrue(this.b3.hasAttrezzo("Spada"));
 }
 
 @Test
 public void testHasNotAttrezzo() {
	 assertFalse(this.b4.hasAttrezzo("Rivoltella"));
 }
 
 @Test
 public void testRemoveAttrezzo() {
	 assertTrue(this.b5.hasAttrezzo("Tirapugni"));
 }
	
 @Test
 public void testNotRemoveAttrezzo() {
	 assertFalse(this.b6.hasAttrezzo("Coltello"));
 }
}
