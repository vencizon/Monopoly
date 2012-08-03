package grafica;

import java.awt.Container;
import javax.swing.JFrame;

public abstract class Finestra extends JFrame
{
    private final int larghezza = 640;                                          //Dimensione larghezza finestra
    private final int altezza = 480;                                            //Dimensione altezza finestra
    private final String titolo = "Monopoli Database Manager";                  //Titolo della finestra
    protected static Container contenitore;                                     //Contenitore principale della finestra
    
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
    
    public abstract Finestra Ritorna();
}
