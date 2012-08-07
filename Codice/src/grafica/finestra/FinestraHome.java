package grafica.finestra;

import grafica.Bottone;
import grafica.ImpostazioniComponente;
import grafica.finestra.Finestra;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import logica.Controllore;

//Classe schermata home
public class FinestraHome extends Finestra
{
    //Costruttore
    public FinestraHome()
    {
        Disegna();                                                              //Richiama metodo di impostazione base della finestra
    }
    
    //Metodo creazione schermata home
    private void Disegna()
    {
        contenitore.setLayout(new GridBagLayout());                             //Imposta tipo layout della finestra
        
        //Barra vuota
        ImpostazioniComponente componenteBarraVuota = new ImpostazioniComponente(0, 0, GridBagConstraints.BOTH, 1.0, 1, 1); //Crea impostazioni per barra principale
        JPanel barraVuota = new JPanel();                                       //Crea pannello per barra vuota
        barraVuota.setBackground(Color.decode("#6AA84F"));                      //Imposta colore di sfondo della barra
        contenitore.add(barraVuota, componenteBarraVuota);                      //Aggiunge barra vuota al contenitore
        
        //Barra esci
        ImpostazioniComponente componenteBottoneEsci = new ImpostazioniComponente(1, 0, GridBagConstraints.BOTH, 0.0, 1, 1); //Crea impostazioni per il bottone esci sulla barra
        Bottone bottoneEsci = new Bottone("Esci", "Esci dal programma", 100, 20, new Controllore.BottoneEsci()); //Crea bottone esci
        contenitore.add(bottoneEsci, componenteBottoneEsci);                    //Aggiunge bottone esci al contenitore
        
        //Logo del programma
        ImpostazioniComponente componenteLogo = new ImpostazioniComponente(0, 1, GridBagConstraints.NONE, 0.0, 2, 1); //Crea impostazioni per logo programma
        JLabel logo = new JLabel(new ImageIcon("Immagini/Monopoly_logo.png"));  //Crea immagine del logo
        contenitore.add(logo, componenteLogo);                                  //Aggiunge logo al contenitore
        
        //Sezione bottoni
        ImpostazioniComponente componenteBottoni = new ImpostazioniComponente(0, 2, GridBagConstraints.NONE, 0.0, 2, 1); //Crea impostazioni per pulsanti
        JPanel sezioneBottoni = new JPanel(new GridLayout(1, 2, 60, 0));        //Crea pannello per i pulsanti
        sezioneBottoni.setBorder(new EmptyBorder(125, 75, 75, 75));              //Imposta i bordi del pannello
        Bottone bottoneVisualizza = new Bottone("Visualizza Dati", "Visualizza dati del database", 150, 25, new Controllore.BottoneVisualizzaDati()); //Crea bottone visualizza
        Bottone bottoneAggiorna = new Bottone("Aggiorna Database", "Aggiorna dati nel database", 150, 25, new Controllore.BottoneAggiornaData()); //Crea bottone aggiorna
        sezioneBottoni.add(bottoneVisualizza);                                  //Aggiunge il bottone accedi al pannello
        sezioneBottoni.add(bottoneAggiorna);                                    //Aggiunge il bottone esci al pannello
        contenitore.add(sezioneBottoni, componenteBottoni);                     //Aggiunge il pannello bottoni al contenitore
        
        pack();
    }
    
    //Metodo di ritorna a finestra
    @Override
    public Finestra Ritorna()
    {
        return null;
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
    public JTextField getCampoGiorno()
    {
        return null;
    }

    @Override
    public JTextField getCampoMese()
    {
        return null;
    }

    @Override
    public JTextField getCampoAnno()
    {
        return null;
    }
}
