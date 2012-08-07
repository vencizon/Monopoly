package grafica.finestra;

import grafica.Bottone;
import grafica.ImpostazioniComponente;
import grafica.finestra.Finestra;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import logica.Controllore;

//Classe finestra nuova partita
public class FinestraNuovaPartita extends Finestra
{
    private JFormattedTextField dataGiorno = new JFormattedTextField();         //Campo data giorno
    private JFormattedTextField dataMese = new JFormattedTextField();           //Campo data mese
    private JFormattedTextField dataAnno = new JFormattedTextField();           //Campo data anno
    private JTextField nomePartita = new JTextField(10);                        //Campo nome partita
    
    //Costruttore
    public FinestraNuovaPartita()
    {
        dataGiorno.setValue("GG");                                              //Inizializza contenuto campo giorno
        dataMese.setValue("MM");                                                //Inizializza contenuto campo mese
        dataAnno.setValue("AAAA");                                              //Inizializza contenuto campo anno
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
        
        //Sezione inserimento dati
        ImpostazioniComponente componenteCrea = new ImpostazioniComponente(0, 2, GridBagConstraints.NONE, 0.0, 4, 1); //Crea impostazioni per pannello creazione
        JPanel pannelloCrea = new JPanel(new GridLayout(1, 2, 100, 0));         //Crea pannello sezione crea partita
        pannelloCrea.setBorder(new EmptyBorder(50, 0, 50, 0));                  //Imposta bordi sezione crea partita      
        JPanel pannelloLista = new JPanel();                                    //Crea pannello lista
        pannelloLista.setLayout(new BoxLayout(pannelloLista, BoxLayout.Y_AXIS)); //Imposta pannello lista
        JPanel pannelloBottoneGiocatori = new JPanel();                         //Crea pannello bottone aggiungi giocatore
        Bottone bottoneGiocatori = new Bottone("Giocatori", "Aggiunge un giocatore alla partita", 100, 25, new Controllore.BottoneGiocatore()); //Crea bottone aggiungi giocatore
        pannelloBottoneGiocatori.add(bottoneGiocatori);                         //Aggiunge il bottone giocatori al pannello lista giocatori
        JPanel pannelloElenco = new JPanel();                                   //Crea pannello elenco giocatori
        pannelloElenco.setLayout(new BoxLayout(pannelloElenco, BoxLayout.Y_AXIS)); //Imposta layout verticale per elenco giocatori
        JLabel etichettaLista = new JLabel("Lista Partecipanti:");              //Crea etichetta lista
        JTextArea areaGiocatori = new JTextArea(6, 10);                         //Crea area giocatori scelti
        areaGiocatori.setBorder(BorderFactory.createEtchedBorder());            //Imposta bordi per area giocatori
        pannelloElenco.add(etichettaLista);                                     //Aggiunge etichetta lista al pannello elenco
        pannelloElenco.add(areaGiocatori);                                      //Aggiunge area lista al pannello elenco
        pannelloLista.add(pannelloBottoneGiocatori);                            //Aggiunge pannello bottone giocatore al pannello lista
        pannelloLista.add(Box.createRigidArea(new Dimension(0, 25)));           //Crea uno spazio vuoto nel pannello lista
        pannelloLista.add(pannelloElenco);                                      //Aggiunge pannello elenco al pannello lista
        JPanel pannelloPartita = new JPanel();                                  //Crea pannello partita
        pannelloPartita.setLayout(new BoxLayout(pannelloPartita, BoxLayout.Y_AXIS)); //Imposta layout verticale al pannello partita
        JPanel pannelloData = new JPanel(new GridBagLayout());                  //Crea pannello data
        ImpostazioniComponente componenteEtichettaData = new ImpostazioniComponente(0, 0, GridBagConstraints.NONE, 0.0, 1, 1); //Crea impostazioni per etichetta data
        JLabel etichettaData = new JLabel("Data Partita");                      //Crea etichetta data partita
        pannelloData.add(etichettaData, componenteEtichettaData);               //Aggiunge etichetta data al pannello data
        ImpostazioniComponente componenteSezioneData = new ImpostazioniComponente(0, 1, GridBagConstraints.NONE, 0.0, 1, 1); //Crea componente per sezione data
        JPanel sezioneData = new JPanel();                                      //Crea sezione data
        sezioneData.add(dataGiorno);                                            //Aggiunge data giorno alla sezione data
        sezioneData.add(dataMese);                                              //Aggiunge data mese alla sezione data
        sezioneData.add(dataAnno);                                              //Aggiunge data anno alla sezione data
        pannelloData.add(sezioneData, componenteSezioneData);                   //Aggiunge sezione data al pannello data
        pannelloPartita.add(pannelloData);                                      //Aggiunge pannello data al pannello partita
        JPanel pannelloNome = new JPanel(new GridBagLayout());                  //Crea pannello nome
        ImpostazioniComponente componenteEtichettaNome = new ImpostazioniComponente(0, 0, GridBagConstraints.NONE, 0.0, 1, 1); //Crea impostazioni per etichetta nome
        JLabel etichettaNome = new JLabel("Nome Partita");                      //Crea etichetta nome partita
        pannelloNome.add(etichettaNome, componenteEtichettaNome);               //Aggiunge etichetta nome partita al pannello nome
        ImpostazioniComponente componenteCampoNome = new ImpostazioniComponente(0, 1, GridBagConstraints.NONE, 0.0, 1, 1); //Crea impostazioni campo nome partita
        pannelloNome.add(nomePartita, componenteCampoNome);                     //Aggiunge il campo nome partita al pannello nome
        pannelloPartita.add(pannelloNome);                                      //Aggiunge pannello nome al pannello partita
        pannelloPartita.add(Box.createRigidArea(new Dimension(0, 25)));         //Crea uno spazio vuoto
        Bottone bottoneCrea = new Bottone("Crea Partita", "Inserisce la partita nel database", 125, 25, new Controllore.BottoneCreaPartita()); //Crea il bottone crea partita
        pannelloPartita.add(bottoneCrea);                                       //Aggiunge bottone crea partita al pannello crea
        pannelloCrea.add(pannelloLista);                                        //Aggiunge pannello lista al pannello crea
        pannelloCrea.add(pannelloPartita);                                      //Aggiunge pannello partita al pannello crea
        
        contenitore.add(pannelloCrea, componenteCrea);                          //Aggiunge sezione crea partita al contenitore
        
        pack();
    }

    //Metodo ritorna finestra precedente
    @Override
    public Finestra Ritorna()
    {
        return new FinestraAggiorna();
    }
    
    //Metodo recupera giorno
    @Override
    public JTextField getCampoGiorno()
    {
        return dataGiorno;
    }
    
    //Metodo recupera mese
    @Override
    public JTextField getCampoMese()
    {
        return dataMese;
    }
    
    //Metodo recupera giorno
    @Override
    public JTextField getCampoAnno()
    {
        return dataAnno;
    }
    
    //Metodo recupera nome partita
    @Override
    public JTextField getNomePartita()
    {
        return nomePartita;
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
}
