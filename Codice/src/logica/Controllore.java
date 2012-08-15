package logica;

import grafica.popups.*;
import grafica.finestra.*;
import database.*;
import entita.Giocatore;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;

//Classe controllo
public class Controllore
{
    private static Finestra finestraAttuale;                                    //Finestra attualmente visibile
    private static Finestra finestraPrecedente;                                 //Finestra temporanea di appoggio
    private static Data data;                                                   //Database
    private static Popups popup;                                                //Popup aperta
    
    //Costruttore
    public Controllore(Data d, Finestra f)
    {
        finestraAttuale = f;                                                    //Crea la finestra
        data = d;                                                               //Crea il database
    }
    
    //Metodo di controllo popup aperto
    private static boolean PopupAperto()
    {
        if (popup != null)
        {
            return true;
        }
        else
        {
            return false;
        }
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
                JOptionPane.showMessageDialog(null, "Username o password errata", "Errore", JOptionPane.ERROR_MESSAGE); //Mostra messaggio di errore
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
            
            if (nome.isEmpty())                                                 //Se campo nome vuoto
            {
                JOptionPane.showMessageDialog(null, "Non hai digitato il nome da inserire", "Nessun Nome", JOptionPane.INFORMATION_MESSAGE); //Mostra avvertimento
            }
            else
            {
                try
                {
                    data.AggiungiNuovoGiocatore(nome);                          //Richiama metodo di inserimento giocatore
                    JOptionPane.showMessageDialog(null, "Giocatore inserito correttamente", "Inserimento riuscito", JOptionPane.INFORMATION_MESSAGE); //Mostra popup di inserimento riuscito
                    finestraAttuale.getCampoNomeGiocatore().setText("");        //Svuota il campo nome giocatore
                }
                catch (SQLException ex1)
                {
                    JOptionPane.showMessageDialog(null, "Inserimento non riuscito", "Errore", JOptionPane.ERROR_MESSAGE); //Mostra messaggio di errore
                }
                catch (Exception ex2)
                {
                    risposta = JOptionPane.showConfirmDialog(null, "Giocatore già presente nel database\nContinuare?", "Aggiungi giocatore", JOptionPane.OK_OPTION); //Mostra popup di conferma
                    if (risposta == JOptionPane.YES_OPTION)                     //Se utente preme si allora inserisce nome
                    {
                        try
                        {
                            data.InsertGiocatore(nome);                         //Chiama metodo inserimento nome giocatore
                            JOptionPane.showMessageDialog(null, "Giocatore inserito correttamente", "Inserimento riuscito", JOptionPane.INFORMATION_MESSAGE); //Mostra popup di inserimento riuscito
                            finestraAttuale.getCampoNomeGiocatore().setText(""); //Svuota il campo nome giocatore
                        }
                        catch (SQLException ex3)
                        {
                            JOptionPane.showMessageDialog(null, "Inserimento non riuscito", "Errore", JOptionPane.ERROR_MESSAGE); //Mostra messaggio di errore
                        }
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
    
    //Classe bottone apri lista giocatore
    public static class BottoneGiocatore implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (PopupAperto())                                                  //Controlla che il popup sia già aperto
            {
                popup.dispose();                                                //Chiude popup per poterne aprire uno nuovo
            }
            popup = new PopupElencoGiocatori("Elenco Giocatori");               //Crea finestra popup
        }
    }
    
    //Classe bottone cerca giocatori
    public static class BottoneCercaGiocatori implements ActionListener
    {
        private String nome;                                                    //Parte o completo nome da cercare
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Vector<Giocatore> elenco = new Vector<Giocatore>();                 //Elenco dei giocatori trovati
            nome = popup.getNomeGiocatore().getText();                          //Preleva il nome giocatore dal campo nome
            
            if (nome.isEmpty())                                                 //Se il campo è vuoto
            {
                JOptionPane.showMessageDialog(null, "Non hai digitato il nome da cercare/inserire", "Nessun Nome", JOptionPane.INFORMATION_MESSAGE); //Mostra avvertimento
            }
            else
            {
                try
                {
                    elenco = data.CercaGiocatori(nome);                         //Chiama metodo di ricerca giocatori
                    popup.setElencoGiocatoriTrovati(elenco);                    //Imposta l'elenco dei giocatori trovati
                }
                catch (SQLException ex)
                {
                    popup.dispose();
                    JOptionPane.showMessageDialog(null, "Impossibile effettuare ricerche", "Errore", JOptionPane.ERROR_MESSAGE); //Mostra messaggio di errore
                }
            }
        }
    }
    
    //Classe click del mouse elenco trovati
    public static class ClickElencoTrovati extends MouseAdapter
    {
        private int indexScelto;                                                //Indice di riga selezionata
        private Giocatore giocatore;                                            //Giocatore da inserire
        private int codiceGiocatore;                                            //Codice del giocatore
        private String nomeGiocatore;                                           //Nome del giocatore

        @Override
        public void mouseClicked(MouseEvent e)
        {
            int i = 0;                                                          //Indice di scorrimento lista giocatori
            indexScelto = popup.getElencoTrovati().getSelectedRow();            //Recupera la riga selezionata
            codiceGiocatore = (Integer)popup.getElencoTrovati().getValueAt(indexScelto, 0); //Preleva codice del giocatore selezionato
            nomeGiocatore = (String)popup.getElencoTrovati().getValueAt(indexScelto, 1); //Preleva codice del giocatore selezionato         
            
            //Controlla codice con i codici dei giocatori scelti
            while ((i < popup.getListaGiocatori().size()) && (popup.getListaGiocatori().get(i).getCodiceGiocatore() != codiceGiocatore))
            {
                i++;
            }
            
            if (i >= popup.getListaGiocatori().size())                          //Controlla se è stato trovato lo stesso codice di un giocatore scelto
            {
                if (!popup.LimiteGiocatori())                                   //Controlla limite massimo di giocatori scelti
                {
                    giocatore = new Giocatore(codiceGiocatore, nomeGiocatore);  //Crea nuovo giocatore
                    popup.setElencoGiocatoriSelezionati(giocatore);             //Chiama metodo di creazione tabella giocatori scelti
                }
                else                                                            //Limite raggiunto
                {
                    JOptionPane.showMessageDialog(null, "Numero massimo di giocatori scelti", "Limite Raggiunto", JOptionPane.INFORMATION_MESSAGE); //Messaggio di limite raggiunto
                }
            }
            else                                                                //Giocatore presente
            {
                JOptionPane.showMessageDialog(null, "Giocatore presente nella lista scelti", "Giocatore Presente", JOptionPane.INFORMATION_MESSAGE); //Messaggio di giocatore già presente
            }
        }
    }
    
    //Classe click del mouse elenco selezionati
    public static class ClickElencoSelezionati extends MouseAdapter
    {
        private int indexScelto;                                                //Indice di riga selezionata
        
        @Override
        public void mouseClicked(MouseEvent e)
        {            
            if (!popup.getListaGiocatori().isEmpty())                           //Se lista non vuota
            {
                indexScelto = popup.getElencoSelezionati().getSelectedRow();    //Preleva indice di riga scelta
                popup.rimuoviGiocatoreSelezionato(indexScelto);                 //Chiama metodo di rimozione giocatore scelto
            }
        }
    }
    
    //Classe bottone annulla
    public static class BottoneAnnulla implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            popup.dispose();                                                    //Chiude popup
        }
        
    }
    
    //Classe bottone aggiungi nuovo giocatore in partita
    public static class BottoneCreaGiocatoreInPartita implements ActionListener
    {
        private String nome;                                                    //Nome giocatore da aggiungere
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Vector<Giocatore> elenco = new Vector<Giocatore>();                 //Elenco giocatori trovati
            Giocatore giocatore;                                                //Nuovo giocatore da inserire
            nome = popup.getNomeGiocatore().getText();                          //Preleva nome del giocatore da inserire
            
            if (nome.isEmpty())                                                 //Se campo nome vuoto
            {
                JOptionPane.showMessageDialog(null, "Non hai digitato il nome da inserire", "Nessun Nome", JOptionPane.INFORMATION_MESSAGE); //Mostra avvertimento
            }
            else
            {
                try
                {
                    data.AggiungiNuovoGiocatore(nome);                          //Richiama metodo di inserimento giocatore
                    JOptionPane.showMessageDialog(null, "Giocatore inserito correttamente", "Inserimento riuscito", JOptionPane.INFORMATION_MESSAGE); //Mostra popup di inserimento riuscito
                    popup.getNomeGiocatore().setText("");                       //Svuota il campo nome giocatore
                    elenco = data.CercaGiocatori(nome);                         //Preleva giocatore appena inserito
                    giocatore = new Giocatore(elenco.get(0).getCodiceGiocatore(), elenco.get(0).getNomeGiocatore()); //Creo nuovo giocatore
                    popup.setElencoGiocatoriTrovati(elenco);                    //Chiama metodo di creazione tabella trovati
                    popup.setElencoGiocatoriSelezionati(giocatore);             //Chiama metodo di creazione tabella selezionati
                }
                catch (SQLException ex1)
                {
                    JOptionPane.showMessageDialog(null, "Impossibile effettuare operazioni", "Errore", JOptionPane.ERROR_MESSAGE); //Mostra messaggio di errore
                }
                catch (Exception ex2)
                {
                    try
                    {
                        elenco = data.CercaGiocatori(nome);                     //Preleva giocatore appena inserito
                        giocatore = new Giocatore(elenco.get(0).getCodiceGiocatore(), elenco.get(0).getNomeGiocatore()); //Creo nuovo giocatore
                        popup.setElencoGiocatoriSelezionati(giocatore);         //Chiama metodo di creazione tabella selezionati
                    }
                    catch (SQLException ex3)
                    {
                        JOptionPane.showMessageDialog(null, "Impossibile effettuare operazioni", "Errore", JOptionPane.ERROR_MESSAGE); //Mostra messaggio di errore
                    }
                }
            }
        }   
    }
    
    //Classe bottone continua creazione partita
    public static class BottoneContinuaCreaPartita implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.getListaGiocatori().clear();                        //Svuota lista dei giocatori precedenti
            finestraAttuale.getListaGiocatori().addAll(popup.getListaGiocatori()); //Copia lista dei giocatori scelti
            finestraAttuale.setElencoGiocatoriScelti();                         //Crea la tabella giocatori partecipanti
            popup.dispose();                                                    //Chiude popup
        }
    }
    
    //Classe click del mouse elenco partecipanti
    public static class ClickElencoPartecipanti extends MouseAdapter
    {
        private int index;                                                      //Indice della riga scelta
        
        @Override
        public void mouseClicked(MouseEvent e)
        {
            index = finestraAttuale.getTabellaPartecipanti().getSelectedRow();  //Recupera indice di riga selezionata
            try
            {
                finestraAttuale.getListaGiocatori().remove(index);              //Rimuove giocatore scelto
                finestraAttuale.setElencoGiocatoriScelti();                     //Crea la tabella giocatori partecipanti
            }
            catch (ArrayIndexOutOfBoundsException ex)
            {
            }
        }
    }
    
    //Classe bottone crea partita
    public static class BottoneCreaPartita implements ActionListener
    {
        private ArrayList<Giocatore> partecipanti = new ArrayList<Giocatore>(); //Elenco giocatori partecipanti alla partita
        private String calendario;                                              //Data da memorizzare
        private int giorno;                                                     //Giorno della data
        private int mese;                                                       //Mese della data
        private int anno;                                                       //Anno della data
        private String nomePartita;                                             //Nome della partita
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            nomePartita = finestraAttuale.getNomePartita().getText();           //Recupera il nome della partita
            
            if (nomePartita.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Non hai digitato il nome partita", "Nessun Nome", JOptionPane.INFORMATION_MESSAGE); //Mostra avvertimento
            }
            else
            {
                try
                {
                    giorno = Integer.parseInt(finestraAttuale.getCampoGiorno()); //Recupera giorno inserito
                    mese = Integer.parseInt(finestraAttuale.getCampoMese());    //Recupera mese inserito
                    anno = Integer.parseInt(finestraAttuale.getCampoAnno());    //Recupera anno inserito
                }
                catch (NumberFormatException n)
                {
                    JOptionPane.showMessageDialog(null, "Devi scegliere una data di inizio corretta", "Errore data", JOptionPane.INFORMATION_MESSAGE); //Mostra avvertimento
                }
            
                partecipanti = finestraAttuale.getListaGiocatori();             //Recupera partecipanti della partita
                
                if (partecipanti.size() < 3)                                    //Verifica se sono stati inseriti un numero sufficente di giocatori
                {
                    JOptionPane.showMessageDialog(null, "Devi inserire minimo 3 giocatori", "Giocatori insufficenti", JOptionPane.INFORMATION_MESSAGE); //Mostra avvertimento
                }
                else                                                            //Se numero di partecipanti sufficente
                {
                    //Verifica se nella data c'è il mese di febbraio
                    if ((mese == 2) && (giorno > 28))
                    {
                        if ((anno % 4) == 0)                                    //Verifica anno bisestile
                        {
                            giorno = 29;                                        //Se anno bisestile febbraio finisce 29
                        }
                        else                                                    //Altrimenti
                        {
                            giorno = 28;                                        //Febbraio finisce il 28
                        }
                    }
                    calendario = giorno + "/" + mese + "/" + anno;              //Recupera data
            
                    try
                    {
                        //Verifica se il nome partita è già presente nel database
                        if (data.CercaPartita(nomePartita))                     //Se nome partita presente
                        {
                            JOptionPane.showMessageDialog(null, "Nome partita già presente nel database", "Nome presente", JOptionPane.ERROR_MESSAGE); //Mostra messaggio di avviso
                        }
                        else                                                    //Se nome partita non presente
                        {
                            data.InsertPartita(nomePartita, calendario, partecipanti); //Inserisce partita nel database
                            JOptionPane.showMessageDialog(null, "Partita inserita correttamente", "Inserimento riuscito", JOptionPane.INFORMATION_MESSAGE); //Mostra popup di inserimento riuscito
                            finestraAttuale.getNomePartita().setText("");       //Azzera il campo nome
                            finestraAttuale.getListaGiocatori().clear();        //Azzera lista giocatori scelti
                            finestraAttuale.setElencoGiocatoriScelti();         //Svuota la tabella
                        }
                    }
                    catch (SQLException ex)
                    {
                        JOptionPane.showMessageDialog(null, "Impossibile effettuare operazioni", "Errore", JOptionPane.ERROR_MESSAGE); //Mostra messaggio di errore
                    }
                }
            }
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
