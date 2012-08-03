package grafica;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import logica.Controllore;

//Classe Schermata aggiorna
public class FinestraAggiorna extends Finestra
{
    //Costruttore
    public FinestraAggiorna()
    {
        Disegna();                                                              //Richiama metodo di impostazione base della finestra        
    }
    
    //Metodo creazione schermata visualizza
    private void Disegna()
    {
        contenitore.setLayout(new GridBagLayout());                             //Imposta tipo layout della finestra
        
        //Bottone indietro
        ImpostazioniComponente componenteBottoneIndietro = new ImpostazioniComponente(0, 0, GridBagConstraints.BOTH, 0.0, 1); //Crea impostazioni bottone indietro
        Bottone bottoneIndietro = new Bottone(new ImageIcon("Immagini/Freccetta.png"), "Indietro", "Torna alla home", 100, 20, new Controllore.BottoneIndietro()); //Crea il bottone indietro
        contenitore.add(bottoneIndietro, componenteBottoneIndietro);            //Aggiunge il bottone indietro al contenitore
        
        //Barra vuota
        ImpostazioniComponente componenteBarraVuota = new ImpostazioniComponente(1, 0, GridBagConstraints.BOTH, 1.0, 1); //Crea impostazioni per barra principale
        JPanel barraVuota = new JPanel();                                       //Crea pannello per barra vuota
        barraVuota.setBackground(Color.decode("#6AA84F"));                      //Imposta colore di sfondo della barra
        contenitore.add(barraVuota, componenteBarraVuota);                      //Aggiunge barra vuota al contenitore
        
        //Barra esci
        ImpostazioniComponente componenteBottoneEsci = new ImpostazioniComponente(2, 0, GridBagConstraints.BOTH, 0.0, 1); //Crea impostazioni per il bottone esci sulla barra
        Bottone bottoneEsci = new Bottone("Esci", "Esci dal programma", 100, 20, new Controllore.BottoneEsci()); //Crea bottone esci
        contenitore.add(bottoneEsci, componenteBottoneEsci);                    //Aggiunge bottone esci al contenitore
        
        //Logo del programma
        ImpostazioniComponente componenteLogo = new ImpostazioniComponente(0, 1, GridBagConstraints.NONE, 0.0, 3); //Crea impostazioni per logo programma
        JLabel logo = new JLabel(new ImageIcon("Immagini/Monopoly_logo.png"));  //Crea immagine del logo
        contenitore.add(logo, componenteLogo);                                  //Aggiunge logo al contenitore
        
        //Sezione bottoni
        ImpostazioniComponente componenteBottoni = new ImpostazioniComponente(0, 2, GridBagConstraints.NONE, 0.0, 3);
        JPanel sezioneBottoni = new JPanel(new GridLayout(3, 1, 0, 15));
        sezioneBottoni.setBorder(new EmptyBorder(100, 100, 50, 100));
        Bottone bottoneAggiungiGiocatore = new Bottone("Aggiungi Giocatore", "Aggiunge un nuovo giocatore al database", 150, 25, new Controllore.BottoneAggiungiGiocatore());
        Bottone bottoneIniziaPartita = new Bottone("Inizia Partita", "Crea una nuova partita nel database", 150, 25, new Controllore.BottoneIniziaPartita());
        Bottone bottoneContinuaPartita = new Bottone("Continua Partita", "Aggiorna una partita all'interno database", 150, 25, new Controllore.BottoneContinuaPartita());
        sezioneBottoni.add(bottoneAggiungiGiocatore);
        sezioneBottoni.add(bottoneIniziaPartita);
        sezioneBottoni.add(bottoneContinuaPartita);
        contenitore.add(sezioneBottoni, componenteBottoni);
        
        pack();
    }
    
    //Metodo di ritorno della finestra
    @Override
    public Finestra Ritorna()
    {
        return new FinestraHome();
    }
}
