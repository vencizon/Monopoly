package grafica.popups;

import entita.Giocatore;
import grafica.Bottone;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;
import logica.Controllore;

//Classe popup elenco giocatori
public class PopupElencoGiocatori extends Popups
{
    private JTextField nomeGiocatore = new JTextField(10);                      //Campo di ricerca/aggiunta giocatore
    private JTable elencoTrovatiJTable = new JTable();                          //Tabella trovati da mostrare
    private JTable elencoSelezionatiJTable = new JTable();                      //Tabella selezionati da mostrare
    private TableModel tabellaTrovati;                                          //Modello tabella trovati
    private TableModel tabellaSelezionati = new DefaultTableModel(0, 2);        //Modello tabella selezionati
    private ArrayList<Giocatore> giocatoriScelti = new ArrayList<Giocatore>();  //Array di giocatori scelti
    
    //Costruttore
    public PopupElencoGiocatori(String titolo)
    {
        super(titolo);                                                          //Richiama il costruttore della superclasse
        Disegna();                                                              //Chiama metodo disegno popup
    }
    
    //Metodo di disegno popup
    private void Disegna()
    {
        
        contenitore = getContentPane();                                         //Recupera riferimento a contenitore attuale
        contenitore.setLayout(new BoxLayout(contenitore, BoxLayout.Y_AXIS));    //Imposta layout verticale per contenitore
        
        //Sezione cerca giocatore
        JPanel pannelloEtichettaNome = new JPanel();                            //Crea pannello etichetta nome giocatore
        JLabel etichettaNomeGiocatore = new JLabel("Nome Giocatore");           //Crea etichetta nome giocatore
        pannelloEtichettaNome.add(etichettaNomeGiocatore);                      //Aggiunge etichetta al pannello etichetta nome giocatore
        contenitore.add(pannelloEtichettaNome);                                 //Aggiunge pannello nome giocatore al contenitore
        JPanel pannelloRicerca = new JPanel();                                  //Crea pannello ricerca
        pannelloRicerca.add(nomeGiocatore);                                     //Aggiunge campo nome giocatore al pannello ricerca
        contenitore.add(pannelloRicerca);                                       //Aggiunge pannello ricerca al contenitore
        
        //Sezione gestione
        JPanel pannelloGestione = new JPanel(new GridLayout(1, 2, 30, 0));      //Crea pannello di gestione
        
        //Pannello sinistro
        JPanel pannelloSinistro = new JPanel();                                 //Crea pannello sinistro
        pannelloSinistro.setLayout(new BoxLayout(pannelloSinistro, BoxLayout.Y_AXIS)); //Imposta layout per pannello sinistro
        JPanel pannelloBottoneCerca = new JPanel();                             //Crea pannello per bottone cerca
        Bottone bottoneCercaGiocatore = new Bottone("Cerca Giocatore", "Cerca giocatori simili al nome richiesto ", 150, 25, new Controllore.BottoneCercaGiocatori()); //Crea bottone cerca giocatore
        pannelloBottoneCerca.add(bottoneCercaGiocatore);                        //Aggiunge bottone cerca al pannello bottone cerca
        pannelloSinistro.add(pannelloBottoneCerca);                             //Aggiunge il bottone al pannello sinistro
        
        //Sezione lista sinistra
        JPanel pannelloEtichettaTrovati = new JPanel();                         //Crea pannello etichetta giocatori trovati
        JLabel etichettaTrovati = new JLabel("Giocatori Trovati");              //Crea etichetta giocatori trovati
        pannelloEtichettaTrovati.add(etichettaTrovati);                         //Aggiunge etichetta giocatori trovati al pannello giocatori trovati
        pannelloSinistro.add(pannelloEtichettaTrovati);                         //Aggiunge pannello etichetta giocatori trovati al pannello sinistro
        JPanel pannelloElencoTrovati = new JPanel();                            //Crea il pannello per l'elenco dei giocatori trovati        
        elencoTrovatiJTable.setFillsViewportHeight(true);                       //Imposta la dimensione massima possibile per la tabella 
        elencoTrovatiJTable.setTableHeader(null);                               //Imposta header null per l'elenco
        elencoTrovatiJTable.setShowVerticalLines(false);                        //Nasconde le linee verticali della griglia
        elencoTrovatiJTable.setToolTipText("Clicca un nome sull'elenco per aggiungerlo alla partita"); //Assegna messaggio
        elencoTrovatiJTable.addMouseListener(new Controllore.ClickElencoTrovati()); //Aggiunge il tipo di evento al click del mouse
        JScrollPane elencoTrovatiScroll = new JScrollPane(elencoTrovatiJTable); //Crea barra di scorrimento per elenco
        elencoTrovatiScroll.setPreferredSize(new Dimension(150, 150));          //Imposta la dimensione dell'elenco base        
        pannelloElencoTrovati.add(elencoTrovatiScroll);                         //Aggiunge elenco dei giocatori trovati al pannello elenco
        pannelloSinistro.add(pannelloElencoTrovati);                            //Aggiunge il pannello elenco giocatori trovati al pannello sinistro
        JPanel pannelloBottoneAnnulla = new JPanel();                           //Crea pannello per bottone annulla
        Bottone bottoneAnnulla = new Bottone("Annulla", "Annulla scelta giocatori", 100, 25, new Controllore.BottoneAnnulla()); //Crea bottone annulla
        pannelloBottoneAnnulla.add(bottoneAnnulla);                             //Aggiunge bottone annulla al pannello bottone annulla
        pannelloSinistro.add(pannelloBottoneAnnulla);                           //Aggiunge pannello bottone annulla al pannello sinistro
        
        //Pannello destro
        JPanel pannelloDestro = new JPanel();                                   //Crea pannello destro
        pannelloDestro.setLayout(new BoxLayout(pannelloDestro, BoxLayout.Y_AXIS)); //Imposta layout per pannello destro
        JPanel pannelloBottoneAggiungi = new JPanel();                          //Crea pannello per bottone aggiungi
        Bottone bottoneAggiungiGiocatore = new Bottone("Aggiungi Giocatore", "Aggiunge giocatore nel database ed alla partita", 150, 25, new Controllore.BottoneCreaGiocatoreInPartita()); //Crea bottone aggiungi giocatore
        pannelloBottoneAggiungi.add(bottoneAggiungiGiocatore);                  //Aggiunge bottone aggiungi al pannello bottone aggiungi
        pannelloDestro.add(pannelloBottoneAggiungi);                            //Aggiunge il bottone al pannello destro
        
        //Sezione lista destra
        JPanel pannelloEtichettaSelezionati = new JPanel();                     //Crea pannello etichetta giocatori selezionati
        JLabel etichettaSelezionati = new JLabel("Giocatori Selezionati");      //Crea etichetta giocatori selezionati
        pannelloEtichettaSelezionati.add(etichettaSelezionati);                 //Aggiunge etichetta giocatori selezionati al pannello giocatori selezionati
        pannelloDestro.add(pannelloEtichettaSelezionati);                       //Aggiunge pannello etichetta giocatori selezionati al pannello sinistro
        JPanel pannelloElencoSelezionati = new JPanel();                        //Crea pannello per elenco giocatori selezionati
        elencoSelezionatiJTable.setFillsViewportHeight(true);                   //Imposta la dimensione massima possibile per la tabella 
        elencoSelezionatiJTable.setTableHeader(null);                           //Imposta header null per l'elenco
        elencoSelezionatiJTable.setShowVerticalLines(false);                    //Nasconde le linee verticali della griglia
        elencoSelezionatiJTable.setToolTipText("Clicca un nome sull'elenco per rimuoverlo dalla partita"); //Assegna messaggio
        elencoSelezionatiJTable.addMouseListener(new Controllore.ClickElencoSelezionati()); //Assegna evento click del mouse sui selezionati
        JScrollPane elencoSelezionatiScroll = new JScrollPane(elencoSelezionatiJTable); //Crea lo scorrimento per la lista
        elencoSelezionatiScroll.setPreferredSize(new Dimension(150, 150));      //Imposta dimensione dell'elenco base
        pannelloElencoSelezionati.add(elencoSelezionatiScroll);                 //Aggiunge elenco selezionati al pannello elenco selezionati
        pannelloDestro.add(pannelloElencoSelezionati);                          //Aggiunge elenco pannello elenco selezionati al pannello destro
        JPanel pannelloBottoneContinua = new JPanel();                          //Crea pannello per il bottone continua
        Bottone bottoneContinua = new Bottone("Continua", "Conferma giocatori scelti", 100, 25, new Controllore.BottoneContinuaCreaPartita()); //Crea il bottone continua
        pannelloBottoneContinua.add(bottoneContinua);                           //Aggiunge il bottone continua al pannello bottone continua
        pannelloDestro.add(pannelloBottoneContinua);                            //Aggiunge il pannello bottone continua al pannello destro
        pannelloGestione.add(pannelloSinistro);                                 //Aggiunge il pannello sinistro al pannello gestione
        pannelloGestione.add(pannelloDestro);                                   //Aggiunge il pannello destro al pannello gestione
        contenitore.add(pannelloGestione);                                      //Aggiunge il pannello gestione al contenitore
        
        pack();                                                                 //Ridimensiona il popup
    }
    
    //Metodo di recupero campo ricerca
    @Override
    public JTextField getNomeGiocatore()
    {
        return nomeGiocatore;
    }
    
    //Metodo preleva tabella trovati
    @Override
    public JTable getElencoTrovati()
    {
        return elencoTrovatiJTable;
    }
    
    //Metodo preleva tabella selezionati
    @Override
    public JTable getElencoSelezionati()
    {
        return elencoSelezionatiJTable;
    }
    
    //Metodo recupera lista di giocatori
    @Override
    public ArrayList<Giocatore> getListaGiocatori()
    {
        return giocatoriScelti;
    }
    
    //Metodo controlla limite giocatori
    @Override
    public boolean LimiteGiocatori()
    {
        if (giocatoriScelti.size() < 6)                                         //Se limite massimo di giocatori non raggiunto
        {
            return false;                                                       //Ritorna falso
        }
        else                                                                    //Altrimenti
        {
            return true;                                                        //Ritorna vero
        }
    }
    
    //Metodo crea elenco giocatori trovati
    @Override
    public void setElencoGiocatoriTrovati(Vector<Giocatore> trovati)
    {
        tabellaTrovati = new DefaultTableModel(trovati.size(), 2);              //Crea il modello della tabella trovati
        
        //Per ogni riga
        for (int i = 0; i < tabellaTrovati.getRowCount(); i++)
        {
            tabellaTrovati.setValueAt(trovati.get(i).getCodiceGiocatore(), i, 0); //Inserisce nome giocatore
            tabellaTrovati.setValueAt(trovati.get(i).getNomeGiocatore(), i, 1); //Inserisce codice
        }
        elencoTrovatiJTable.setModel(tabellaTrovati);                           //Inserisce il modello con i dati nella tabella trovati
    }
    
    //Metodo crea elenco giocatori selezionati
    @Override
    public void setElencoGiocatoriSelezionati(Giocatore giocatore)
    {
        int totaleRighe = getElencoSelezionati().getRowCount() + 1;             //Calcola il numero totale di righe della tabella selezionati

        giocatoriScelti.add(giocatore);                                         //Aggiunge giocatore alla lista
        tabellaSelezionati = new DefaultTableModel(totaleRighe, 2);             //Crea nuovo modello per la tabella selezionati
          
        //Per ogni giocatore nella lista
        for (int i = 0; i < giocatoriScelti.size(); i++)
        {
            tabellaSelezionati.setValueAt(giocatoriScelti.get(i).getCodiceGiocatore(), i, 0); //Inserisce codice nella tabella
            tabellaSelezionati.setValueAt(giocatoriScelti.get(i).getNomeGiocatore(), i, 1); //Inserisce nome nella tabella
        }
        tabellaSelezionati.setValueAt(giocatore.getCodiceGiocatore(), totaleRighe - 1, 0); //Inserisce nuovo codice scelto nella taballe selezionati
        tabellaSelezionati.setValueAt(giocatore.getNomeGiocatore(), totaleRighe - 1, 1); //Inserisce nuovo codice scelto nella tabella selezionati
        elencoSelezionatiJTable.setModel(tabellaSelezionati);                   //Inserisce il modello con i dati nella tabella selezionati
    }
    
    //Metodo rimuovi giocatore selezionato
    @Override
    public void rimuoviGiocatoreSelezionato(int index)
    {
        try
        {
            giocatoriScelti.remove(index);                                      //Rimuove giocatore di posizione indice
            tabellaSelezionati = new DefaultTableModel(giocatoriScelti.size(), 2); //Crea nuovo modello per la tabella selezionati
        
            //Per ogni giocatore nella lista
            for (int i = 0; i < giocatoriScelti.size(); i++)
            {
                tabellaSelezionati.setValueAt(giocatoriScelti.get(i).getCodiceGiocatore(), i, 0); //Inserisce codice nella tabella
                tabellaSelezionati.setValueAt(giocatoriScelti.get(i).getNomeGiocatore(), i, 1); //Inserisce nome nella tabella
            }
            elencoSelezionatiJTable.setModel(tabellaSelezionati);               //Inserisce il modello con i dati nella tabella selezionati
        }
        catch (ArrayIndexOutOfBoundsException ex)
        {
        }
    }
}
