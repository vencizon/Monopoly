package grafica.finestra;

import entita.Giocatore;
import grafica.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import logica.Controllore;

//Classe finestra continua partita
public class FinestraContinuaPartita extends Finestra
{
    private JTextField giocatore = new JTextField(10);                          //Campo giocatore
    private JTextField dado = new JTextField(10);                               //Campo dado
    private JTextField azione = new JTextField(10);                             //Campo azione
    
    //Costruttore
    public FinestraContinuaPartita()
    {
        Disegna();                                                              //Richiama metodo di disegno
    }
    
    //Metodo di disegno schermata
    private void Disegna()
    {
        contenitore.setLayout(new GridBagLayout());                             //Imposta il lo schema della schermata
        
        //Bottone indietro
        ImpostazioniComponente componenteBottoneIndietro = new ImpostazioniComponente(0, 0, GridBagConstraints.BOTH, 0.0, 1, 1); //Crea impostazioni bottone indietro
        Bottone bottoneIndietro = new Bottone(new ImageIcon("Immagini/Freccetta.png"), "Indietro", "Torna alla home", 100, 20, new Controllore.BottoneIndietro()); //Crea il bottone indietro
        contenitore.add(bottoneIndietro, componenteBottoneIndietro);            //Aggiunge il bottone indietro al contenitore
        
        //Bottone home
        ImpostazioniComponente componenteBottoneHome = new ImpostazioniComponente(1, 0, GridBagConstraints.BOTH, 0.0, 1, 1); //Crea impostazioni per bottone home
        Bottone bottoneHome = new Bottone("Home", "Torna alla schermata principale", 100, 20, new Controllore.BottoneHome()); //Crea il bottone home
        contenitore.add(bottoneHome, componenteBottoneHome);                    //Aggiunge bottone home al contenitore
        
        //Barra vuota
        ImpostazioniComponente componenteBarraVuota = new ImpostazioniComponente(2, 0, GridBagConstraints.BOTH, 1.0, 1, 1); //Crea impostazioni per barra principale
        JPanel barraVuota = new JPanel();                                       //Crea pannello per barra vuota
        barraVuota.setBackground(Color.decode("#6AA84F"));                      //Imposta colore di sfondo della barra
        contenitore.add(barraVuota, componenteBarraVuota);                      //Aggiunge barra vuota al contenitore
        
        //Barra esci
        ImpostazioniComponente componenteBottoneEsci = new ImpostazioniComponente(3, 0, GridBagConstraints.BOTH, 0.0, 1, 1); //Crea impostazioni per il bottone esci sulla barra
        Bottone bottoneEsci = new Bottone("Esci", "Esci dal programma", 100, 20, new Controllore.BottoneEsci()); //Crea bottone esci
        contenitore.add(bottoneEsci, componenteBottoneEsci);                    //Aggiunge bottone esci al contenitore
        
        //Logo del programma
        ImpostazioniComponente componenteLogo = new ImpostazioniComponente(0, 1, GridBagConstraints.NONE, 0.0, 4, 1); //Crea impostazioni per logo programma
        JLabel logo = new JLabel(new ImageIcon("Immagini/Monopoly_logo.png"));  //Crea immagine del logo
        contenitore.add(logo, componenteLogo);                                  //Aggiunge logo al contenitore
        
        //Sezione inserimento mosse
        ImpostazioniComponente componenteInserimento = new ImpostazioniComponente(0, 2, GridBagConstraints.NONE, 0.0, 4, 1); //Crea impostazioni per sezione inserimento
        JPanel pannelloInserimento = new JPanel(new GridBagLayout());           //Crea pannello inserimento dati
        pannelloInserimento.setBorder(new EmptyBorder(50, 0, 25, 0));           //Imposta bordi del pannello inserimento
        ImpostazioniComponente componenteMossa = new ImpostazioniComponente(0, 0, GridBagConstraints.NONE, 0.0, 1, 1); //Crea impostazioni componente mossa
        JPanel pannelloMossa = new JPanel();                                    //Crea pannello per sezione mosse
        pannelloMossa.setBorder(new EmptyBorder(0, 20, 0, 50));                 //Imposta bordi del pannello mossa
        pannelloMossa.setLayout(new BoxLayout(pannelloMossa, BoxLayout.Y_AXIS)); //Imposta layout verticale per pannello mosse
        JLabel etichettaMossa = new JLabel("Ultima Mossa");                     //Crea etichetta ultima mossa
        JTextArea areaDati = new JTextArea(8, 10);                              //Crea area dati ultima mossa
        areaDati.setBorder(new EtchedBorder());                                 //Imposta bordo per area dati
        pannelloMossa.add(etichettaMossa);                                      //Aggiunge l'etichetta al pannello ultima mossa
        pannelloMossa.add(areaDati);                                            //Aggiunge area dati al pannello ultima mossa
        pannelloInserimento.add(pannelloMossa, componenteMossa);                //Aggiunge pannello mossa al pannello inserimento
        ImpostazioniComponente componenteCampi = new ImpostazioniComponente(1, 0, GridBagConstraints.NONE, 0.0, 1, 1); //Crea impostazioni componente campi
        JPanel pannelloCampi = new JPanel(new GridLayout(3, 3));                //Crea pannello campi
        JPanel pannelloEtichettaGiocatore = new JPanel();                       //Crea pannello etichetta giocatore
        JLabel etichettaGiocatore = new JLabel("Giocatore");                    //Crea etichetta giocatore
        pannelloEtichettaGiocatore.add(etichettaGiocatore);                     //Aggiunge l'etichetta giocatore al pannello etichetta giocatore
        pannelloCampi.add(pannelloEtichettaGiocatore);                          //Aggiunge pannello etichetta giocatore al pannello campi
        JPanel pannelloGiocatore = new JPanel();                                //Crea pannello campo giocatore
        pannelloGiocatore.add(giocatore);                                       //Aggiunge campo giocatore al pannello giocatore
        pannelloCampi.add(pannelloGiocatore);                                   //Aggiunge pannello giocatore al pannello campi
        JPanel pannelloEtichettaDado = new JPanel();                            //Crea pannello etichetta dado
        JLabel etichettaDado = new JLabel("Dado");                              //Crea etichetta dado
        pannelloEtichettaDado.add(etichettaDado);                               //Aggiunge l'etichetta dado al pannello etichetta dado
        pannelloCampi.add(pannelloEtichettaDado);                               //Aggiunge pannello etichetta dado al pannello campi
        JPanel pannelloDado = new JPanel();                                     //Crea pannello dado
        pannelloDado.add(dado);                                                 //Aggiunge campo dado al pannello dado        
        pannelloCampi.add(pannelloDado);                                        //Aggiunge pannello dado al pannello campi
        JPanel pannelloEtichettaAzione = new JPanel();                          //Crea pannello etichetta azione
        JLabel etichettaAzione = new JLabel("Azione");                          //Crea etichetta azione
        pannelloEtichettaAzione.add(etichettaAzione);                           //Aggiunge etichetta azione al pannello etichetta azione
        pannelloCampi.add(pannelloEtichettaAzione);                             //Aggiunge pannello etichetta azione al pannello campi
        JPanel pannelloAzione = new JPanel();                                   //Crea pannello azione
        pannelloAzione.add(azione);                                             //Aggiunge campo azione al pannello azione
        pannelloCampi.add(pannelloAzione);                                      //Aggiunge pannello azione al pannello campi
        pannelloInserimento.add(pannelloCampi, componenteCampi);                //Aggiunge il pannello campi al pannello inserimento
        ImpostazioniComponente componenteBottoneAggiungi = new ImpostazioniComponente(1, 1, GridBagConstraints.NONE, 0.0, 1, 1); //Crea impostazioni bottone aggiungi
        Bottone bottoneAggiungiMossa = new Bottone("Aggiungi Mossa", "Aggiunge la mossa creata nel database", 125, 25, new Controllore.BottoneAggiungiMossa()); //Crea bottone aggiungi mossa
        pannelloInserimento.add(bottoneAggiungiMossa, componenteBottoneAggiungi); //Aggiunge bottone al pannello inserimento
        contenitore.add(pannelloInserimento, componenteInserimento);            //Aggiunge pannello inserimento al contenitore
                
        pack();
    }
    
    //Metodo ritorna finestra precedente
    @Override
    public Finestra Ritorna()
    {
        return new FinestraAggiorna();
    }
    
    //Metodo recupera giocatore
    public JTextField getGiocatore()
    {
        return giocatore;
    }
    
    //Metodo recupera giocatore
    public JTextField getDado()
    {
        return dado;
    }
    
    //Metodo recupera giocatore
    public JTextField getAzione()
    {
        return azione;
    }

    //Metodi da implementare
    @Override
    public JTextField getCampoUser()
    {
        return null;
    }

    @Override
    public JTextField getCampoPass()
    {
        return null;
    }

    @Override
    public JTextField getCampoNomeGiocatore()
    {
        return null;
    }

    @Override
    public JTextField getNomePartita()
    {
        return null;
    }

    @Override
    public String getCampoGiorno()
    {
        return null;
    }

    @Override
    public String getCampoMese()
    {
        return null;
    }

    @Override
    public String getCampoAnno()
    {
        return null;
    }

    @Override
    public ArrayList<Giocatore> getListaGiocatori()
    {
        return null;
    }

    @Override
    public void setElencoGiocatoriScelti()
    {
    }

    @Override
    public JTable getTabellaPartecipanti()
    {
        return null;
    }
}
