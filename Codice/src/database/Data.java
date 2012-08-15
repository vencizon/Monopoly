package database;

import entita.Giocatore;
import java.sql.*;
import java.util.*;
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
    
    //Metodo cerca giocatori
    public Vector<Giocatore> CercaGiocatori(String nome) throws SQLException
    {
        Vector<Giocatore> elenco = new Vector<Giocatore>();                     //Array di giocatori trovati
        
        //Query di selezione giocatori
        String querySelect = "SELECT * "
                           + "FROM giocatori "
                           + "WHERE NomeGiocatore LIKE '" + nome + "%'";
        
        Connessione(username, password);                                        //Chiama metodo di connessione
        command = conn.createStatement();                                       //Crea riga di comando query
        risultato = command.executeQuery(querySelect);                          //Recupera il risultato della query
        
        //Inserimento dati risultato nell'array
        while (risultato.next())
        {
            elenco.add(new Giocatore(risultato.getInt(1), risultato.getString(2))); //Inserisce giocatore nell'elenco
        }
        
        risultato.close();                                                      //Chiude collegamento con il risultato
        command.close();                                                        //Chiude collegamento con il comando
        ChiudiConnessione();                                                    //Chiude connessione al database
        
        return elenco;                                                          //Ritorna elenco di giocatori
    }
    
    //Metodo cerca partita
    public boolean CercaPartita(String nome) throws SQLException
    {
        //Query di ricerca partita
        String querySelect = "SELECT NomePartita "
                           + "FROM Partite "
                           + "WHERE NomePartita = '" + nome + "'";
        
        Connessione(username, password);                                        //Chiama metodo di connessione
        command = conn.createStatement();                                       //Crea riga di comando query
        risultato = command.executeQuery(querySelect);                          //Recupera il risultato della query
        
        //Verifica se esiste una partita con lo stesso nome
        if (risultato.next())
        {
            risultato.close();                                                  //Chiude collegamento risultato
            command.close();                                                    //Chiude collegamento comando
            ChiudiConnessione();                                                //Chiude connessione
            return true;                                                        //Ritorna vero se ha trovato risultati
        }
        
        risultato.close();                                                      //Chiude collegamento risultato
        command.close();                                                        //Chiude collegamento comando
        ChiudiConnessione();                                                    //Chiude connessione
        return false;                                                           //Ritorna falso se non ha trovato nulla
    }
    
    //Metodo inserisci partita
    public void InsertPartita(String nome, String dataInizio, ArrayList<Giocatore> partecipanti) throws SQLException
    {
        String query;                                                           //Stringa per le interrogazioni al database
        int codicePartita;                                                      //Codice della partita da associare al giocatore
        int codiceGiocatore;                                                    //Codice del giocatore da associare alla partita
        
        Connessione(username, password);                                        //Chiama metodo di connessione
        command = conn.createStatement();                                       //Crea riga di comando query
        
        //Query di inserimento partita
        query = "INSERT INTO Partite (NomePartita, DataInizio) "
              + "VALUES "
              + "('" + nome + "', to_date('" + dataInizio + "','DD/MM/YYYY'))";
        
        command.executeQuery(query);                                            //Effettua la query
        
        //Query prelievo codice partita appena inserito
        query = "SELECT CodicePartita "
              + "FROM Partite "
              + "WHERE NomePartita = '" + nome + "'";
        
        risultato = command.executeQuery(query);                                //Recupera risultato della query
        risultato.next();                                                       //Puntatore alla prima riga di risultati
        codicePartita = risultato.getInt(1);                                    //Preleva codice della partita
        risultato.close();                                                      //Chiude collegamento risultato
        
        //Per ogni partecipante alla partita
        for (int i = 0; i < partecipanti.size(); i++)
        {
            codiceGiocatore = partecipanti.get(i).getCodiceGiocatore();         //Preleva codice giocatore
            
            //Query di inserimento giocatori in partita
            query = "INSERT INTO PartiteGiocatori (CodicePartita, CodiceGiocatore) "
                  + "VALUES "
                  + "('" + codicePartita + "', '" + codiceGiocatore + "')";
            
            command.executeQuery(query);                                        //Inserisce giocatore in partita
        }
        
        command.close();                                                        //Chiude collegamento comandi
        ChiudiConnessione();                                                    //Chiude la connessione
    }
    
    //Metodo chiusura connessione
    public void ChiudiConnessione() throws SQLException
    {
        conn.close();
    }
}
