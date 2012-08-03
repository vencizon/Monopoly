package grafica;

import java.awt.GridBagConstraints;

//Classe imposta celle
public class ImpostazioniComponente extends GridBagConstraints
{
    //Costruttore
    protected ImpostazioniComponente(int posX, int posY, int riempimento, double estensioneX, int numeroCelleX)
    {
        this.gridx = posX;                                                      //Assegna la posizione di colonna della cella
        this.gridy = posY;                                                      //Assegna la posizione della riga della cella
        this.fill = riempimento;                                                //Imposta il riempimento della cella
        this.weightx = estensioneX;                                             //Imposta l'estensione della cella
        this.gridwidth = numeroCelleX;                                          //Imposta il numero di celle occupate dalla cella
    }
}
