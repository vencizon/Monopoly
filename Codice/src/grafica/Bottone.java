package grafica;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

//Classe Bottone
public class Bottone extends JButton
{
    //Costruttore con testo
    public Bottone(String nome, String tip, int dimensioneX, int dimensioneY, ActionListener action)
    {
        super(nome);                                                            //Imposta titolo bottone
        this.setToolTipText(tip);                                               //Imposta suggerimento al bottone
        this.setPreferredSize(new Dimension(dimensioneX, dimensioneY));         //Imposta dimensioni bottone
        this.setBackground(Color.decode("#6AA84F"));                            //Imposta colore di sfondo del bottone
        this.setForeground(Color.decode("#FFFFFF"));                            //Imposta colore font del bottone
        this.addActionListener(action);                                         //Imposta azione del pulsante
    }
    
    //Costruttore con teste ed immagine
    public Bottone(ImageIcon immagine, String nome, String tip, int dimensioneX, int dimensioneY, ActionListener action)
    {
        super(nome, immagine);                                                  //Imposta titolo bottone
        this.setToolTipText(tip);                                               //Imposta suggerimento al bottone
        this.setPreferredSize(new Dimension(dimensioneX, dimensioneY));         //Imposta dimensioni bottone
        this.setBackground(Color.decode("#6AA84F"));                            //Imposta colore di sfondo del bottone
        this.setForeground(Color.decode("#FFFFFF"));                            //Imposta colore font del bottone
        this.addActionListener(action);                                         //Imposta azione del pulsante
    }
}
