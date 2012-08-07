package grafica.popups;

import java.awt.*;
import javax.swing.*;

//Classe astratta popup
public abstract class Popups extends JDialog
{
    protected String titolo;                                                    //Titolo della finestra
    private final int altezza = 400;                                            //Altezza della finestra
    private final int larghezza = 300;                                          //Larghezza della finestra
    protected Container contenitore;                                            //Contenitore del popup
    
    //Metodo di disegno popup
    public void DisegnaPopup()
    {
        setModalityType(ModalityType.APPLICATION_MODAL);                        //Modalità popup con priorità di gestione
        setTitle(titolo);                                                       //Imposta titolo popup
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);                             //Modalità di chiusura popup
        setLocationRelativeTo(null);                                            //Posiziona popup al centro dello schermo
        setVisible(true);                                                       //Imposta visibilità finestra
    }
    
    public abstract JTextField getNomeGiocatore();                              //Metodo recupera campo nome giocatore
}
