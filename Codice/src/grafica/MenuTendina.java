package grafica;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

//Classe menu a tendina
public class MenuTendina extends JComboBox
{
    public static final String[] GIORNO = {"GG", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}; //Costante giorno
    public static final String[] MESE = {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}; //Costante mese
    public static final String[] ANNO = {"AAAA", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015"}; //Costante anno
    
    //Costruttore
    public MenuTendina(String[] parteData)
    {
        super(parteData);                                                       //Imposta il modello di parte data da creare
        this.setBackground(Color.white);                                        //Imposta colore di sfondo
        this.setBorder(new EtchedBorder());                                     //Crea bordi
        this.setUI(new BasicComboBoxUI());                                      //Imposta stile del menu a tendina
    }
}
