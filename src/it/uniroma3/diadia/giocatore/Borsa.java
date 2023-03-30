package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public static final int DEFAULT_PESO_MAX_BORSA=10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = DEFAULT_PESO_MAX_BORSA;
		this.attrezzi= new Attrezzo[10];
		this.numeroAttrezzi=0;
	}
	/**
	 * Aggiunge un oggetto nella borsa
	 * @param attrezzo
	 * @return true se l'oggetto è aggiunto correttamente, altrimenti false
	 */

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(this.getPeso() + attrezzo.getPeso()>this.getPesoMax()) {
			return false;
		}
		if(this.numeroAttrezzi==10) {
			return false;
		}
		this.attrezzi[this.numeroAttrezzi]=attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	/**
	 * Restituisce il peso massimo della borsa
	 * @return
	 */
	public int getPesoMax() {
		return pesoMax;
	}
	/**
	 * Controlla se l'attrezzo che ho nella borsa ha lo stesso nome dell'attrezzo passato come parametro
	 * @param nomeAttrezzo
	 * @return L'attrezzo richiesto,altrimenti null
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if(this.attrezzi[i]!=null)
				if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
					a = attrezzi[i];
		return a;
	}

	/**
	 * Calcola il peso della borsa
	 * @return il peso della borsa
	 */
	public int getPeso() {
		int peso = 0;
		if(numeroAttrezzi==0)
			return peso;
		else {
			for (int i= 0; i<this.numeroAttrezzi; i++)
				peso = peso + this.attrezzi[i].getPeso();
		}
		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		boolean trovato;
		trovato=false;
		for(Attrezzo att : this.attrezzi) {
			if(nomeAttrezzo!=null && att!=null) {
				if(att.getNome().equals(nomeAttrezzo)) 
					trovato = true;
			}
		}
		return trovato;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null; 
		int i = 0; 
		while(a==null && i<this.attrezzi.length) {
			if(this.attrezzi[i]!=null) {
				if(this.attrezzi[i].getNome().equals(nomeAttrezzo)) {
					a=this.attrezzi[i];
					this.attrezzi[i]=null;
				}
			}
			i++;
		}
		return a;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

}
