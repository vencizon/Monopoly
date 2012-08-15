package grafica.finestra;

import entita.Giocatore;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import logica.Controllore;
import database.Data;
import grafica.*;

//Classe finestra login
public class FinestraLogin extends Finestra
{
    private JTextField campoUser = new JTextField(10);                          //Campo username
    private JTextField campoPass = new JPasswordField(10);                      //Campo password
    private Controllore controllo;                                              //Crea un controllore
    
    //Costruttore
    public FinestraLogin(Data d)
    {
        Disegna();                                                              //Richiama metodo di impostazione base della finestra
        controllo = new Controllore(d, this);                                   //Costruisce il controllore per questa finestra
    }
    
    //Metodo creazione schermata principale
    private void Disegna()
    {
        contenitore.setLayout(new GridBagLayout());                             //Imposta tipo layout della finestra
        
        //Barra principale
        ImpostazioniComponente componenteBarraVuota = new ImpostazioniComponente(0, 0, GridBagConstraints.BOTH, 0.0, 1, 1); //Crea impostazioni per barra principale
        JPanel barraVuota = new JPanel();                                       //Crea pannello per barra vuota
        barraVuota.setBackground(Color.decode("#6AA84F"));                      //Imposta colore di sfondo della barra
        contenitore.add(barraVuota, componenteBarraVuota);                      //Aggiunge barra vuota al contenitore
        
        //Logo del programma
        ImpostazioniComponente componenteLogo = new ImpostazioniComponente(0, 1, GridBagConstraints.NONE, 0.0, 1, 1); //Crea impostazioni per logo programma
        JLabel logo = new JLabel(new ImageIcon("Immagini/Monopoly_logo.png"));  //Crea immagine del logo
        contenitore.add(logo, componenteLogo);                                  //Aggiunge logo al contenitore
        
        //Sezione Inserimento dati
        ImpostazioniComponente componenteDati = new ImpostazioniComponente(0, 2, GridBagConstraints.NONE, 0.0, 1, 1); //Crea impostazioni per inserimento dati
        JPanel sezioneDati = new JPanel(new GridLayout(2, 2, 50, 0));           //Crea pannello inserimento dati utente        
        JLabel etichettaUser = new JLabel("Username");                          //Crea etichetta username
        JLabel etichettaPass = new JLabel("Password");                          //Crea etichetta password
        sezioneDati.setBorder(new EmptyBorder(100, 50, 50, 50));                //Imposta bordi alla sezione dati
        sezioneDati.add(etichettaUser);                                         //Aggiunge etichetta username al pannello dati
        sezioneDati.add(etichettaPass);                                         //Aggiunge etichetta password al pannello dati
        sezioneDati.add(campoUser);                                             //Aggiunge campo username al pannello dati
        sezioneDati.add(campoPass);                                             //Aggiunge campo password al pannello dati
        contenitore.add(sezioneDati, componenteDati);                           //Aggiunge sezione inserimento dati utente al contenitore

        //Sezione bottoni
        ImpostazioniComponente componenteBottoni = new ImpostazioniComponente(0, 3, GridBagConstraints.NONE, 0.0, 1, 1); //Crea impostazioni per pulsanti
        JPanel sezioneBottoni = new JPanel(new GridLayout(1, 2, 60, 0));        //Crea pannello per i pulsanti
        sezioneBottoni.setBorder(new EmptyBorder(0, 50, 50, 50));               //Imposta i bordi del pannello
        Bottone bottoneAccedi = new Bottone("Accedi", "Effettua l'accesso", 100, 25, new Controllore.BottoneAccedi()); //Crea bottone accedi
        Bottone bottoneEsci = new Bottone("Esci", "Esci dal programma", 100, 25, new Controllore.BottoneEsci()); //Crea bottone esci
        sezioneBottoni.add(bottoneAccedi);                                      //Aggiunge il bottone accedi al pannello
        sezioneBottoni.add(bottoneEsci);                                        //Aggiunge il bottone esci al pannello
        contenitore.add(sezioneBottoni, componenteBottoni);                     //Aggiunge il pannello bottoni al contenitore
       
        pack();                                                                 //Ridisegna la finestra
    }
    
    //Metodo recupera username
    @Override
    public JTextField getCampoUser()
    {
        return campoUser;
    }
    
    //Metodo recupera password
    @Override
    public JTextField getCampoPass()
    {
        return campoPass;
    }
    
    //Metodo da implementare
    @Override
    public Finestra Ritorna()
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
