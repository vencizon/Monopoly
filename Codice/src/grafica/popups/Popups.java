package grafica.popups;

import entita.Giocatore;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.TableModel;

//Classe astratta popup
public abstract class Popups extends JDialog
{
    protected String titolo;                                                    //Titolo della finestra
    private final int altezza = 400;                                            //Altezza della finestra
    private final int larghezza = 300;                                          //Larghezza della finestra
    protected Container contenitore;                                            //Contenitore del popup
    
    public Popups(String titolo)
    {
        setTitle(titolo);                                                       //Imposta titolo popup
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);                             //Modalità di chiusura popup
        setModalityType(ModalityType.MODELESS);                                 //Modalità popup con priorità di gestione
        setLocationRelativeTo(null);                                            //Posiziona popup al centro dello schermo
        setVisible(true);                                                       //Imposta visibilità finestra
    }
    
    public abstract JTextField getNomeGiocatore();                              //Metodo recupera campo nome giocatore
    public abstract void setElencoGiocatoriTrovati(Vector<Giocatore> trovati);  //Metodo di creazione elenco giocatori trovati
    public abstract void setElencoGiocatoriSelezionati(Giocatore giocatore);    //Metodo di creazione elenco giocatori selezionati
    public abstract JTable getElencoTrovati();                                  //Metodo recupera tabella trovati
    public abstract JTable getElencoSelezionati();                              //Metodo recupera tabella selzionati
    public abstract ArrayList<Giocatore> getListaGiocatori();                   //Metodo recupera lista giocatori
    public abstract boolean LimiteGiocatori();                                  //Metodo controlla limite giocatori
    public abstract void rimuoviGiocatoreSelezionato(int index);                //Metodo rimuove giocatore nella lista selezionati
}
