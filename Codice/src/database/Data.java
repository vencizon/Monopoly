package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.pool.OracleDataSource;

//Classe database
public class Data
{
    private final int port = 1521;                                              //Porta di connessione
    private final String databaseName = "xe";                                   //Nome database
    //private final String username = "MONOPOLI";
    //private final String pass = "monopoli";
    private String username;                                                    //Username database
    private String password;                                                    //Password database
    private final String drive = "thin";                                        //Tipo di driver usato
    private final String serverName = "localhost";                              //Indirizzo del server
    private OracleDataSource ods;                                               //Istanza database
    private Connection conn = null;                                             //Connessione
    private Statement command;                                                  //Comando di query
    private ResultSet risultato;                                                //Risultato query
    
    //Metodo di memorizzazione username e password
    public void setUserEPass(String username, String password)
    {
        this.username = username;                                               //Memorizza username
        this.password = password;                                               //Memorizza password
    }
    
    //Metodo di connesione
    public void Connessione(String username, String password) throws SQLException
    {
        ods = new OracleDataSource();                                           //Crea una nuova istanza di database
        ods.setDriverType(drive);                                               //Imposta il driver da utilizzare
        ods.setServerName(serverName);                                          //Imposta l'indirizzo di connessione
        ods.setPortNumber(port);                                                //Imposta la porta
        ods.setDatabaseName(databaseName);                                      //Imposta il nome del database
        ods.setUser(username);                                                  //Imposta l'username di connessione
        ods.setPassword(password);                                              //Imposta la password
        conn = ods.getConnection();                                             //Crea la connessione al database
    }
    
    //Metodo aggiungi nuovo giocatore
    public void AggiungiNuovoGiocatore(String nome) throws SQLException, Exception
    {        
        //Query di selezione giocatore
        String querySelect = "SELECT NomeGiocatore"
                           + " FROM giocatori"
                           + " WHERE NomeGiocatore = '" + nome + "' ";
        
        Connessione(username, password);                                        //Richiama metodo di connessione
        command = conn.createStatement();                                       //Crea riga di comando query
        risultato = command.executeQuery(querySelect);                          //Preleva risultato della query
        
        //Verifica se esiste già il nome giocatore che si sta inserendo
        if (!risultato.next())                                                  //Se il nome da inserire non è presente nel database
        {
            risultato.close();                                                  //Chiudi connessione risultato query
            command.close();                                                    //Chiudi connessione con il comando query
            ChiudiConnessione();                                                //Chiama metodo di chiusura connessione
            InsertGiocatore(nome);                                              //Chiama matedo di inserimento nome giocatore
        }
        else                                                                    //Se il nome è già presente
        {
            risultato.close();                                                  //Chiudi connessione risultato query
            command.close();                                                    //Chiudi connessione con il comando query
            ChiudiConnessione();                                                //Chiama metodo di chiusura connessione
            throw new Exception();                                              //Lancia eccezione per nome già presente
        }        
    }
    
    //Metodo inserimento giocatore
    public void InsertGiocatore(String nome) throws SQLException
    {
        //Query di inserimento giocatore
        String queryInsert = "INSERT INTO giocatori"
                           + " (NomeGiocatore)"
                           + " VALUES"
                           + " ('" + nome + "')";
        
        Connessione(username, password);                                        //Richiama metodo di connessione
        command = conn.createStatement();                                       //Crea riga di comando query
        command.executeQuery(queryInsert);                                      //Esegue query di inserimento nome giocatore
        command.close();                                                        //Chiude connessione con i comandi
        ChiudiConnessione();                                                    //Chiama metodo di chiusura connessione
    }
    
    //Metodo chiusura connessione
    public void ChiudiConnessione() throws SQLException
    {
        conn.close();
    }
}
