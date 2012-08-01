/*
 * La classe funziona che è una bomba...
 * Ciò che manca sono solo i metodi per le interrogazioni
 * Feci già una prova per collegare e creare delle tabelle.
 * Il metodo di creazione poi l'ho cancellato perchè non ci serve
 * Comunque se vuoi provarlo fate pure. Ricordatevi che vi serve inserire la libreria
 * che ci ha dato il prof.
 */

package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.pool.OracleDataSource;

//Classe database
public class DB
{
    private final int port = 1521;
    private final String databaseName = "xe";
    private final String url = "jdbc:oracle:thin:@//localhost/xe";
    private final String username = "MONOPOLI";
    private final String pass = "codeoracle";
    private final String drive = "thin";
    private final String serverName = "localhost";
    private OracleDataSource ods;
    private Connection conn = null;
    private Statement command;
    
    private void createConnection()
    {
        try
        {
            ods = new OracleDataSource();
            ods.setDriverType(drive);
            ods.setServerName(serverName);
            ods.setPortNumber(port);
            ods.setDatabaseName(databaseName);
            ods.setUser(username);
            ods.setPassword(pass);
            conn = ods.getConnection();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
