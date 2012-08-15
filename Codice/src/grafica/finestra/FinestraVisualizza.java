package grafica.finestra;

import entita.Giocatore;
import grafica.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import logica.Controllore;

//Classe schermata visualizza
public class FinestraVisualizza extends Finestra
{
    //Costruttore
    public FinestraVisualizza()
    {
        Disegna();                                                              //Richiama metodo di impostazione base della finestra        
    }
    
    //Metodo creazione schermata visualizza
    private void Disegna()
    {
        contenitore.setLayout(new GridBagLayout());                             //Imposta tipo layout della finestra
        
        //Bottone indietro
        ImpostazioniComponente componenteBottoneIndietro = new ImpostazioniComponente(0, 0, GridBagConstraints.BOTH, 0.0, 1, 1); //Crea impostazioni bottone indietro
        Bottone bottoneIndietro = new Bottone(new ImageIcon("Immagini/Freccetta.png"), "Indietro", "Torna alla home", 100, 20, new Controllore.BottoneIndietro()); //Crea il bottone indietro
        contenitore.add(bottoneIndietro, componenteBottoneIndietro);            //Aggiunge il bottone indietro al contenitore
        
        //Barra vuota
        ImpostazioniComponente componenteBarraVuota = new ImpostazioniComponente(1, 0, GridBagConstraints.BOTH, 1.0, 1, 1); //Crea impostazioni per barra principale
        JPanel barraVuota = new JPanel();                                       //Crea pannello per barra vuota
        barraVuota.setBackground(Color.decode("#6AA84F"));                      //Imposta colore di sfondo della barra
        contenitore.add(barraVuota, componenteBarraVuota);                      //Aggiunge barra vuota al contenitore
        
        //Barra esci
        ImpostazioniComponente componenteBottoneEsci = new ImpostazioniComponente(2, 0, GridBagConstraints.BOTH, 0.0, 1, 1); //Crea impostazioni per il bottone esci sulla barra
        Bottone bottoneEsci = new Bottone("Esci", "Esci dal programma", 100, 20, new Controllore.BottoneEsci()); //Crea bottone esci
        contenitore.add(bottoneEsci, componenteBottoneEsci);                    //Aggiunge bottone esci al contenitore
        
        //Logo del programma
        ImpostazioniComponente componenteLogo = new ImpostazioniComponente(0, 1, GridBagConstraints.NONE, 0.0, 3, 1); //Crea impostazioni per logo programma
        JLabel logo = new JLabel(new ImageIcon("Immagini/Monopoly_logo.png"));  //Crea immagine del logo
        contenitore.add(logo, componenteLogo);                                  //Aggiunge logo al contenitore
        
        //Sezione bottoni
        ImpostazioniComponente componenteBottoni = new ImpostazioniComponente(0, 2, GridBagConstraints.NONE, 0.0, 3, 1); //Crea impostazioni per pulsanti
        JPanel sezioneBottoni = new JPanel(new GridLayout(1, 2, 60, 0));        //Crea pannello per i pulsanti
        sezioneBottoni.setBorder(new EmptyBorder(125, 75, 75, 75));              //Imposta i bordi del pannello
        Bottone bottoneVisualizza = new Bottone("Classifiche Giocatori", "Visualizza classifiche", 200, 25, new Controllore.BottoneClassifica()); //Crea bottone classifiche
        Bottone bottoneAggiorna = new Bottone("Partite", "Gestisce le partite", 200, 25, new Controllore.BottonePartite()); //Crea bottone partite
        sezioneBottoni.add(bottoneVisualizza);                                  //Aggiunge il bottone accedi al pannello
        sezioneBottoni.add(bottoneAggiorna);                                    //Aggiunge il bottone esci al pannello
        contenitore.add(sezioneBottoni, componenteBottoni);                     //Aggiunge il pannello bottoni al contenitore
        
        pack();
    }
    
    //Metodo di ritorno della finestra
    @Override
    public Finestra Ritorna()
    {
        return new FinestraHome();
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
