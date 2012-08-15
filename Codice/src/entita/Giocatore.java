package entita;

//Classe giocatore
public class Giocatore
{
    private final int codice;                                                   //Codice del giocatore
    private final String nome;                                                  //Nome del giocatore
    
    //Costruttore
    public Giocatore(int codice, String nome)
    {
        this.codice = codice;                                                   //Inizializza codice giocatore
        this.nome = nome;                                                       //Inizializza nome giocatore
    }
    
    //Metodo recupera codice
    public int getCodiceGiocatore()
    {
        return codice;
    }
    
    //Metodo recupera nome giocatore
    public String getNomeGiocatore()
    {
        return nome;
    }
}
