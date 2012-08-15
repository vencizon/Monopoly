package grafica.finestra;

import entita.Giocatore;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.*;

//Classe astratta finestra
public abstract class Finestra extends JFrame
{
    private final int larghezza = 640;                                          //Dimensione larghezza finestra
    private final int altezza = 480;                                            //Dimensione altezza finestra
    private final String titolo = "Monopoli Database Manager";                  //Titolo della finestra
    protected Container contenitore;                                            //Contenitore principale della finestra
    
    //Costruttore
    public Finestra()
    {
        contenitore = getContentPane();                                         //Preleva il riferimento alla finestra principale
        setTitle(titolo);                                                       //Imposta titolo della finestra
        setSize(larghezza, altezza);                                            //Imposta dimensione della finestra
        setLocationRelativeTo(null);                                            //Imposta la finestra al centro dello schermo
        setResizable(false);                                                    //Impedisce ridimensionamento finestra
        setDefaultCloseOperation(EXIT_ON_CLOSE);                                //Imposta uscita dal programma alla chiusura della finestra
        setVisible(true);                                                       //Imposta la finestra a visibile
    }
    
    public abstract Finestra Ritorna();                                         //Metodo ritorna finestra precedente
    public abstract JTextField getCampoUser();                                  //Metodo recupera campo username
    public abstract JTextField getCampoPass();                                  //Metodo recupera campo password
    public abstract JTextField getCampoNomeGiocatore();                         //Metodo recupera campo nome giocatore nuovo
    public abstract JTextField getNomePartita();                                //Metodo recupera campo nome partita
    public abstract String getCampoGiorno();                                    //Metodo recupera campo giorno nuova partita
    public abstract String getCampoMese();                                      //Metodo recupera campo mese nuova partita
    public abstract String getCampoAnno();                                      //Metodo recupera campo anno nuova partita
    public abstract ArrayList<Giocatore> getListaGiocatori();                   //Metodo recupera lista giocatori selezionati
    public abstract JTable getTabellaPartecipanti();                            //Metodo recupera tabella elenco partecipanti
    public abstract void setElencoGiocatoriScelti();                            //Metodo di creazione elenco scelti
}
