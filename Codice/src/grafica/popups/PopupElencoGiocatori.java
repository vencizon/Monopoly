package grafica.popups;

import grafica.Bottone;
import java.awt.*;
import javax.swing.*;

//Classe popup elenco giocatori
public class PopupElencoGiocatori extends Popups
{
    private JTextField nomeGiocatore = new JTextField(10);                      //Campo di ricerca/aggiunta giocatore
    
    //Costruttore
    public PopupElencoGiocatori(String titolo)
    {
        super.titolo = titolo;                                                  //Richiama il costruttore della superclasse
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
        Bottone bottoneCercaGiocatore = new Bottone("Cerca Giocatore", "Cerca giocatori simili al nome richiesto ", 150, 25, null); //Crea bottone cerca giocatore
        pannelloBottoneCerca.add(bottoneCercaGiocatore);                        //Aggiunge bottone cerca al pannello bottone cerca
        pannelloSinistro.add(pannelloBottoneCerca);                             //Aggiunge il bottone al pannello sinistro
        
        //Sezione lista sinistra
        JPanel pannelloEtichettaTrovati = new JPanel();                         //Crea pannello etichetta giocatori trovati
        JLabel etichettaTrovati = new JLabel("Giocatori Trovati");              //Crea etichetta giocatori trovati
        pannelloEtichettaTrovati.add(etichettaTrovati);                         //Aggiunge etichetta giocatori trovati al pannello giocatori trovati
        pannelloSinistro.add(pannelloEtichettaTrovati);                         //Aggiunge pannello etichetta giocatori trovati al pannello sinistro
        JPanel pannelloElencoTrovati = new JPanel();                            //Crea il pannello per l'elenco dei giocatori trovati
        JList elencoTrovati = new JList();                                      //Crea lista dei giocatori trovati
        elencoTrovati.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    //Imposta modalità di selezione elemento nella lista
        elencoTrovati.setLayoutOrientation(JList.VERTICAL);                     //Imposta l'elenco in verticale
        elencoTrovati.setVisibleRowCount(-1);                                   //Mostra il numero massimo di elementi nella lista
        JScrollPane elencoTrovatiScroll = new JScrollPane(elencoTrovati);       //Crea barra di scorrimento per elenco
        elencoTrovatiScroll.setPreferredSize(new Dimension(150, 150));          //Imposta la dimensione dell'elenco base
        pannelloElencoTrovati.add(elencoTrovatiScroll);                         //Aggiunge elenco dei giocatori trovati al pannello elenco
        pannelloSinistro.add(pannelloElencoTrovati);                            //Aggiunge il pannello elenco giocatori trovati al pannello sinistro
        JPanel pannelloBottoneAnnulla = new JPanel();                           //Crea pannello per bottone annulla
        Bottone bottoneAnnulla = new Bottone("Annulla", "Annulla scelta giocatori", 100, 25, null); //Crea bottone annulla
        pannelloBottoneAnnulla.add(bottoneAnnulla);                             //Aggiunge bottone annulla al pannello bottone annulla
        pannelloSinistro.add(pannelloBottoneAnnulla);                           //Aggiunge pannello bottone annulla al pannello sinistro
        
        //Pannello destro
        JPanel pannelloDestro = new JPanel();                                   //Crea pannello destro
        pannelloDestro.setLayout(new BoxLayout(pannelloDestro, BoxLayout.Y_AXIS)); //Imposta layout per pannello destro
        JPanel pannelloBottoneAggiungi = new JPanel();                          //Crea pannello per bottone aggiungi
        Bottone bottoneAggiungiGiocatore = new Bottone("Aggiungi Giocatore", "Aggiunge giocatore nel database ed alla partita", 150, 25, null); //Crea bottone aggiungi giocatore
        pannelloBottoneAggiungi.add(bottoneAggiungiGiocatore);                  //Aggiunge bottone aggiungi al pannello bottone aggiungi
        pannelloDestro.add(pannelloBottoneAggiungi);                            //Aggiunge il bottone al pannello destro
        
        //Sezione lista destra
        JPanel pannelloEtichettaSelezionati = new JPanel();                     //Crea pannello etichetta giocatori selezionati
        JLabel etichettaSelezionati = new JLabel("Giocatori Selezionati");      //Crea etichetta giocatori selezionati
        pannelloEtichettaSelezionati.add(etichettaSelezionati);                 //Aggiunge etichetta giocatori selezionati al pannello giocatori selezionati
        pannelloDestro.add(pannelloEtichettaSelezionati);                       //Aggiunge pannello etichetta giocatori selezionati al pannello sinistro
        JPanel pannelloElencoSelezionati = new JPanel();                        //Crea pannello per elenco giocatori selezionati
        JList elencoSelezionati = new JList();                                  //Crea elenco giocatori selezionati
        elencoSelezionati.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Imposta modalità di selezione giocatori
        elencoSelezionati.setLayoutOrientation(JList.VERTICAL);                 //Imposta elenco verticale
        elencoSelezionati.setVisibleRowCount(-1);                               //Imposta numero massimo possibile di giocatori da mostrare
        JScrollPane elencoSelezionatiScroll = new JScrollPane(elencoSelezionati); //Crea lo scorrimento per la lista
        elencoSelezionatiScroll.setPreferredSize(new Dimension(150, 150));      //Imposta dimensione dell'elenco base
        pannelloElencoSelezionati.add(elencoSelezionatiScroll);                 //Aggiunge elenco selezionati al pannello elenco selezionati
        pannelloDestro.add(pannelloElencoSelezionati);                          //Aggiunge elenco pannello elenco selezionati al pannello destro
        JPanel pannelloBottoneContinua = new JPanel();                          //Crea pannello per il bottone continua
        Bottone bottoneContinua = new Bottone("Continua", "Conferma giocatori scelti", 100, 25, null); //Crea il bottone continua
        pannelloBottoneContinua.add(bottoneContinua);                           //Aggiunge il bottone continua al pannello bottone continua
        pannelloDestro.add(pannelloBottoneContinua);                            //Aggiunge il pannello bottone continua al pannello destro
        pannelloGestione.add(pannelloSinistro);                                 //Aggiunge il pannello sinistro al pannello gestione
        pannelloGestione.add(pannelloDestro);                                   //Aggiunge il pannello destro al pannello gestione
        contenitore.add(pannelloGestione);                                      //Aggiunge il pannello gestione al contenitore
        
        pack();                                                                 //Ridimensiona il popup
        DisegnaPopup();                                                         //Chiama metodo di disegno popup
    }
    
    //Metodo di recupero campo ricerca
    @Override
    public JTextField getNomeGiocatore()
    {
        return nomeGiocatore;
    }
}
