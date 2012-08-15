package grafica.finestra;

import entita.Giocatore;
import grafica.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import logica.Controllore;

//Classe aggiungi giocatore
public class FinestraGiocatore extends Finestra
{
    private JTextField campoNomeGiocatore = new JTextField(15);                 //Campo inserimento nome giocatore
    
    //Costruttore
    public FinestraGiocatore()
    {
        Disegna();
    }
    
    //Metodo di disegno finestra
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
        
        //Sezione inserimento utente
        ImpostazioniComponente componenteAggiungi = new ImpostazioniComponente(0, 2, GridBagConstraints.NONE, 0.0, 4, 1); //Crea impostazioni per sezione aggiungi giocatore
        JPanel pannelloAggiungi = new JPanel(new FlowLayout());                 //Crea pannello per inserimento giocatore
        pannelloAggiungi.setBorder(new EmptyBorder(100, 0, 100, 0));              //Imposta bordi del pannello
        JLabel etichettaNome = new JLabel("Nome");                              //Crea etichetta nome
        Bottone bottoneAggiungi = new Bottone("Aggiungi Giocatore", "Inserisce il nuovo giocatore nel database", 150, 25, new Controllore.BottoneAggiungi()); //Crea bottone per aggiungere il giocatore
        pannelloAggiungi.add(etichettaNome);                                    //Aggiunge etichetta nome nel pannello
        pannelloAggiungi.add(campoNomeGiocatore);                               //Aggiunge campo di testo nel pannello
        pannelloAggiungi.add(bottoneAggiungi);                                  //Aggiunge bottone per aggiungere nel pannello
        contenitore.add(pannelloAggiungi, componenteAggiungi);                  //Aggiunge pannello per aggiunta giocatori nel pannello
        
        pack();
    }

    //Metodo di ritorno alla finestra
    @Override
    public Finestra Ritorna()
    {
        return new FinestraAggiorna();
    }
    
    //Metodo recupera campo nome giocatore
    @Override
    public JTextField getCampoNomeGiocatore()
    {
        return campoNomeGiocatore;
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
