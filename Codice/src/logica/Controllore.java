package logica;

import grafica.popups.PopupElencoGiocatori;
import grafica.popups.Popups;
import grafica.finestra.FinestraPartite;
import grafica.finestra.FinestraVisualizza;
import grafica.finestra.FinestraHome;
import grafica.finestra.FinestraClassifiche;
import grafica.finestra.FinestraNuovaPartita;
import grafica.finestra.FinestraAggiorna;
import grafica.finestra.FinestraGiocatore;
import grafica.finestra.FinestraContinuaPartita;
import grafica.finestra.Finestra;
import grafica.*;
import database.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

//Classe controllo
public class Controllore
{
    private static Finestra finestraAttuale;                                    //Finestra attualmente visibile
    private static Finestra finestraPrecedente;                                 //Finestra temporanea di appoggio
    private static Data data;                                                   //Database
    private static JPanel pop;                                                  //Pannello per popup
    private static Popups popup;                                                 //
    
    //Costruttore
    public Controllore(Data d, Finestra f)
    {
        finestraAttuale = f;                                                    //Crea la finestra
        data = d;                                                               //Crea il database
    }
    
    //Classe bottone di uscita
    public static class BottoneEsci implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);                                                     //Chiude il programma
        }
    }
    
    //Classe bottone indietro
    public static class BottoneIndietro implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraPrecedente = finestraAttuale;                               //Memorizza la finestra attuale nella finestra precedente
            finestraAttuale.dispose();                                          //Chiude la finestra attuale
            finestraAttuale = finestraPrecedente.Ritorna();                     //Rende attuale la finestra precedente
            finestraPrecedente.dispose();                                       //Chiude la finestra precedente
        }
    }
    
    //Classe bottone home
    public static class BottoneHome implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();                                          //Chiude la finestra attuale
            finestraAttuale = new FinestraHome();                               //Apre la finestra home
        }
    }
    
    //Classe bottone accedi
    public static class BottoneAccedi implements ActionListener
    {
        private String username;                                                //Campo username
        private String password;                                                //campo password
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            username = finestraAttuale.getCampoUser().getText();                //Recupera contenuto campo username
            password = finestraAttuale.getCampoPass().getText();                //Recupera contenuto campo password
            
            try
            {
                data.Connessione(username, password);                           //Chiama il metodo di connessione al database
                data.setUserEPass(username, password);                          //Memorizza username e password corretti
                data.ChiudiConnessione();                                       //Chiama il metodo di chiusura connessione
                finestraAttuale.dispose();                                      //Chiude la finestra attuale
                finestraAttuale = new FinestraHome();                           //Apre la finestra home
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(pop, "Username o password errata", "Errore", JOptionPane.ERROR_MESSAGE); //Mostra messaggio di errore
            }
        }
    }

    //Classe bottone visualizza
    public static class BottoneVisualizzaDati implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();                                          //Chiude la finestra attuale
            finestraAttuale = new FinestraVisualizza();                         //Apre la finestra visualizza
        }
    }
    
    //Classe bottone aggiorna database
    public static class BottoneAggiornaData implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();                                          //Chiude la finestra attuale
            finestraAttuale = new FinestraAggiorna();                           //Apre la finestra aggiorna database
        }
    }
    
    //Classe bottone classifica
    public static class BottoneClassifica implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();                                          //Chiude la finestra attuale
            finestraAttuale = new FinestraClassifiche();                        //Apre la finestra delle classifiche
        }
    }
    
    //Classe bottone vittorie
    public static class BottoneVittorie implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
        }   
    }
    
    //Classe bottone guadagni
    public static class BottoneGuadagni implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
        }   
    }
    
    //Classe bottone fuorilegge
    public static class BottoneFuorilegge implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
        }   
    }
    
    //Classe bottone partite
    public static class BottonePartite implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();                                          //Chiude la finestra attuale
            finestraAttuale = new FinestraPartite();                            //Apre la finestra partite
        }
    }
    
    //Classe bottone partite in corso
    public static class BottonePartiteInCorso implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
        }   
    }
    
    //Classe bottone cerca partite
    public static class BottoneCercaPartite implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
        }   
    }
    
    //Classe bottone aggiungi giocatore
    public static class BottoneAggiungiGiocatore implements ActionListener
    {        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();                                          //Chiude la finestra attuale
            finestraAttuale = new FinestraGiocatore();                          //Apre la finestra aggiungi giocatore
        }   
    }
    
    //Classe bottone aggiungi
    public static class BottoneAggiungi implements ActionListener
    {
        private String nome;                                                    //Nome giocatore da aggiungere
        private int risposta;                                                   //Conferma di aggiunta giocatore
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            nome = finestraAttuale.getCampoNomeGiocatore().getText();           //Preleva nome del giocatore da inserire
            
            try
            {
                if (nome.isEmpty())
                {
                    throw new SQLException();
                }
                data.AggiungiNuovoGiocatore(nome);                              //Richiama metodo di inserimento giocatore
                JOptionPane.showMessageDialog(pop, "Giocatore inserito correttamente", "Inserimento riuscito", JOptionPane.INFORMATION_MESSAGE); //Mostra popup di inserimento riuscito
                finestraAttuale.getCampoNomeGiocatore().setText("");            //Svuota il campo nome giocatore
            }
            catch (SQLException ex1)
            {
                JOptionPane.showMessageDialog(pop, "Inserimento non riuscito", "Errore", JOptionPane.ERROR_MESSAGE); //Mostra messaggio di errore
            }
            catch (Exception ex2)
            {
                risposta = JOptionPane.showConfirmDialog(pop, "Giocatore già presente nel database\nContinuare?", "Aggiungi giocatore", JOptionPane.OK_OPTION); //Mostra popup di conferma
                if (risposta == JOptionPane.YES_OPTION)                         //Se utente preme si allora inserisce nome
                {
                    try
                    {
                        data.InsertGiocatore(nome);                             //Chiama metodo inserimento nome giocatore
                        JOptionPane.showMessageDialog(pop, "Giocatore inserito correttamente", "Inserimento riuscito", JOptionPane.INFORMATION_MESSAGE); //Mostra popup di inserimento riuscito
                        finestraAttuale.getCampoNomeGiocatore().setText("");    //Svuota il campo nome giocatore
                    }
                    catch (SQLException ex3)
                    {
                        JOptionPane.showMessageDialog(pop, "Inserimento non riuscito", "Errore", JOptionPane.ERROR_MESSAGE); //Mostra messaggio di errore
                    }
                }
            }
        }   
    }
    
    //Classe bottone inizia partita
    public static class BottoneIniziaPartita implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();                                          //Chiude la finestra attuale
            finestraAttuale = new FinestraNuovaPartita();                       //Apre la finestra nuova partita
        }   
    }
    
    //Classe bottone lista giocatore
    public static class BottoneGiocatore implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            popup = new PopupElencoGiocatori("Elenco Giocatori");               //Crea finestra popup
        }
    }
    
    //Classe bottone crea partita
    public static class BottoneCreaPartita implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
        }
    }
    
    //Classe bottone continua partita
    public static class BottoneContinuaPartita implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();                                          //Chiude la finestra attuale
            finestraAttuale = new FinestraContinuaPartita();                    //Apre finestra continua partita
        }   
    }
    
    //Classe bottone aggiungi mossa
    public static class BottoneAggiungiMossa implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
        }
    }
}
