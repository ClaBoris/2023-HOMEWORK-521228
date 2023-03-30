package it.uniroma3.diadia;




import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai(+ direnzione)", "aiuto", "fine", "prendi(+nome_attrezzo)", "posa(+nome_attrezzo)"};

	private Partita partita;
	private static IOConsole io;

	public DiaDia(IOConsole io) {
		this.partita = new Partita();
		this.io = io;
	}

	public void gioca() {
		String istruzione; 

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do {	

			istruzione=this.io.leggiRiga();
		}while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if (comandoDaEseguire.getNome()==null) {
			return false;
		}
		if(this.partita.getGiocatore().getCfu()==0) {
			this.io.mostraMessaggio("Hai perso");
			return true;
		}
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine();
			return true;
		} 
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else 
			this.io.mostraMessaggio("Comando Sconosciuto");
		if (this.partita.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");//System.out.println("Hai vinto!");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" "); 
		this.io.mostraMessaggio("");                                          
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--cfu);
		}
		this.io.mostraMessaggio("Stanza corrente:");
		this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione()); 
	}


	/**
	 * Prende (rimuove) un attrezzo dalla stanza e lo mette nella borsa
	 * @param nomeAttrezzo
	 * @return ritorna true se l'operazione è eseguita correttamente, altrimenti false
	 */
	private void prendi (String nomeAttrezzo) {
		if(!this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) { 
			this.io.mostraMessaggio("Attrezzo"+" " + nomeAttrezzo +" "+"non è presente nella stanza");
			return;
		}
		Attrezzo a = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		this.partita.getGiocatore().getBorsa().addAttrezzo(a); //metto l'attrezzo nella borsa
		this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a); //quindi lo rimuovo dalla stanza
		this.io.mostraMessaggio("Attrezzo" + " " + nomeAttrezzo +" "+ "preso.");
	}
	/**
	 * Prende l'attrezzo dalla borsa e lo mette nella stanza
	 * @param nomeAttrezzo
	 * @return true se l'operazione viene effettuata correttamente, altirmenti false
	 */
	private void posa (String nomeAttrezzo) {
		if(!this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			this.io.mostraMessaggio("Attrezzo" + " " + nomeAttrezzo + " " + "non è nella borsa.");
			return;
		}
		Attrezzo a = this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		this.io.mostraMessaggio("Attrezzo" + " " + nomeAttrezzo + " " + "posato nella stanza.");
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("Grazie per aver giocato!");
	}

	public static void main(String[] argc) {
		IOConsole ioConsole=new IOConsole();
		DiaDia gioco = new DiaDia(ioConsole);
		gioco.gioca();
	}
}