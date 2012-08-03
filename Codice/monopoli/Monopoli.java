package monopoli;

import database.Data;
import grafica.*;

//Classe principale
public class Monopoli
{   
    public static void main(String[] args)
    {
        Data data = new Data();
        Finestra entryProgramma = new FinestraLogin(data);
    }
}
