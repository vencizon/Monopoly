package grafica.finestra;

import entita.Giocatore;
import grafica.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import logica.Controllore;

//Classe schermata partite
public class FinestraPartite extends Finestra
{
    private JFormattedTextField campoDataDalGiorno = new JFormattedTextField(); //Giorno Data dal
    private JFormattedTextField campoDataDalMese = new JFormattedTextField();   //Mese Data dal
    private JFormattedTextField campoDataDalAnno = new JFormattedTextField();   //Anno Data dal
    private JFormattedTextField campoDataAlGiorno = new JFormattedTextField();  //Giorno Data al
    private JFormattedTextField campoDataAlMese = new JFormattedTextField();    //Mese Data al
    private JFormattedTextField campoDataAlAnno = new JFormattedTextField();    //Anno Data al
    
    //Costruttore
    public FinestraPartite()
    {
        campoDataDalGiorno.setValue("GG");                                      //Imposta testo Giorno Data dal
        campoDataDalMese.setValue("MM");                                        //Imposta testo Mese Data dal
        campoDataDalAnno.setValue("AAAA");                                      //Imposta testo Anno Data dal
        campoDataAlGiorno.setValue("GG");                                       //Imposta testo Giorno Data al
        campoDataAlMese.setValue("MM");                                         //Imposta testo Mese Data al
        campoDataAlAnno.setValue("AAAA");                                       //Imposta testo Anno Data al
        Disegna();        
    }
    
    //Metodo di disegno schermata
    private void Disegna()
    {
        contenitore.setLayout(new GridBagLayout());                             //Imposta tipo layout della finestra
        
        //Bottone indietro
        ImpostazioniComponente componenteBottoneIndietro = new ImpostazioniComponente(0, 0, GridBagConstraints.BOTH, 0.0, 1, 1); //Crea impostazioni bottone indietro
        Bottone bottoneIndietro = new Bottone(new ImageIcon("Immagini/Freccetta.png"), "Indietro", "Torna alla home", 100, 20, new Controllore.BottoneIndietro()); //Crea il bottone indietro
        contenitore.add(bottoneIndietro, componenteBottoneIndietro);            //Aggiunge il bottone indietro al contenitore
        
        //Bottone home
        ImpostazioniComponente componenteBottoneHome = new ImpostazioniComponente(1, 0, GridBagConstraints.BOTH, 0.0, 1, 1); //Crea impostazioni per bottone home
        Bottone bottoneHome = new Bottone("Home", "Torna alla schermata principale", 100, 20, new Controllore.BottoneHome()); //Crea il bottone home
        contenitore.add(bottoneHome, componenteBottoneHome);                    //Aggiunge bottone home al contenitore
        
        //Barra vuota
        ImpostazioniComponente componenteBarraVuota = new ImpostazioniComponente(2, 0, GridBagConstraints.BOTH, 1.0, 1, 1); //Crea impostazioni per barra principale
        JPanel barraVuota = new JPanel();                                       //Crea pannello per barra vuota
        barraVuota.setBackground(Color.decode("#6AA84F"));                      //Imposta colore di sfondo della barra
        contenitore.add(barraVuota, componenteBarraVuota);                      //Aggiunge barra vuota al contenitore
        
        //Barra esci
        ImpostazioniComponente componenteBottoneEsci = new ImpostazioniComponente(3, 0, GridBagConstraints.BOTH, 0.0, 1, 1); //Crea impostazioni per il bottone esci sulla barra
        Bottone bottoneEsci = new Bottone("Esci", "Esci dal programma", 100, 20, new Controllore.BottoneEsci()); //Crea bottone esci
        contenitore.add(bottoneEsci, componenteBottoneEsci);                    //Aggiunge bottone esci al contenitore
        
        //Logo del programma
        ImpostazioniComponente componenteLogo = new ImpostazioniComponente(0, 1, GridBagConstraints.NONE, 0.0, 4, 1); //Crea impostazioni per logo programma
        JLabel logo = new JLabel(new ImageIcon("Immagini/Monopoly_logo.png"));  //Crea immagine del logo
        contenitore.add(logo, componenteLogo);                                  //Aggiunge logo al contenitore
        
        //Sezione bottone partite in corso
        ImpostazioniComponente componenteInput = new ImpostazioniComponente(0, 2, GridBagConstraints.NONE, 0.0, 4, 1); //Crea impostazioni sezione di input
        JPanel sezioneInput = new JPanel(new GridLayout(1, 2));          //Crea pannello per la sezione input
        sezioneInput.setBorder(new EmptyBorder(50, 0, 0, 0));
        JPanel pannelloPartiteInCorso = new JPanel();                           //Crea pannello per bottone parite in corso
        Bottone bottonePartiteInCorso = new Bottone("Partite in corso", "Mostra le partite attualmente in corso", 125, 25, new Controllore.BottonePartiteInCorso()); //Crea bottone partite in corso
        pannelloPartiteInCorso.add(bottonePartiteInCorso);                      //Aggiunge il bottone partite in corso al pannello di partite in corso
        sezioneInput.add(pannelloPartiteInCorso);                               //Aggiunge il pannello partite in corso alla sezione input
        JPanel sezioneRicerca = new JPanel(new GridLayout(1, 2));               //Crea la sezione di ricerca partite
        JPanel pannelloCerca = new JPanel(new GridLayout(2, 4));                //Crea pannello della sezione ricerca
        JLabel etichettaDal = new JLabel("Dal");                                //Crea etichetta dal
        JLabel etichettaAl = new JLabel("Al");                                  //Crea etichetta al
        pannelloCerca.add(etichettaDal);                                        //Aggiunge etichetta dal nel pannello
        pannelloCerca.add(campoDataDalGiorno);                                  //Aggiunge campo giorno data dal nel pannello
        pannelloCerca.add(campoDataDalMese);                                    //Aggiunge campo mese data dal nel pannello
        pannelloCerca.add(campoDataDalAnno);                                    //Aggiunge campo anno data dal nel pannello
        pannelloCerca.add(etichettaAl);                                         //Aggiunge etichetta al nel pannello
        pannelloCerca.add(campoDataAlGiorno);                                   //Aggiunge campo giorno data al nel pannello
        pannelloCerca.add(campoDataAlMese);                                     //Aggiunge campo mese al nel pannello
        pannelloCerca.add(campoDataAlAnno);                                     //Aggiunge campo anno al nel pannello
        sezioneRicerca.add(pannelloCerca);                                      //Aggiunge il pannello di ricerca alla sezione di ricerca
        JPanel pannelloCercaPartite = new JPanel();                             //Crea il pannello per il bottone cerca partite
        Bottone bottoneCercaPartite = new Bottone("Cerca Partite", "Avvia la ricerca delle partite", 125, 25, new Controllore.BottoneCercaPartite()); //Crea bottone di cerca partite
        pannelloCercaPartite.add(bottoneCercaPartite);                          //Aggiunge il bottone cerca partite al pannello cerca partite
        sezioneRicerca.add(pannelloCercaPartite);                               //Aggiunge alla sezione ricerca il pannello del bottone cerca partite
        sezioneInput.add(sezioneRicerca);                                       //Aggiunge alla sezione di input la sezione di ricerca
        contenitore.add(sezioneInput, componenteInput);                         //Aggiunge la sezione input al contenitore
               
        //Sezione area di testo
        ImpostazioniComponente componenteAreaTesto = new ImpostazioniComponente(0, 3, GridBagConstraints.NONE, 0.0, 4, 1); //Crea impostazioni per area dei dati
        JPanel pannelloArea = new JPanel();                                     //Crea pannello per area dei dati
        pannelloArea.setBorder(new EmptyBorder(5, 0, 10, 0));                   //Imposta i bordi del pannello
        JTextArea areaDati = new JTextArea(15, 50);                             //Crea sezione area dati
        areaDati.setBorder(BorderFactory.createEtchedBorder());                 //Crea bordi per area dei dati
        areaDati.setLineWrap(true);                                             //Imposta lo scorrimento lineare
        areaDati.setWrapStyleWord(true);                                        //Imposta stile dello scorrimento
        JScrollPane areaScroll = new JScrollPane();                             //Crea la barra di scorrimento
        areaScroll.getViewport().add(areaDati);                                 //Aggiunge l'area dei dati alla barra di scorrimento
        pannelloArea.add(areaScroll);                                           //Aggiunge al pannello l'area dei dati con barra di scorrimento
        contenitore.add(pannelloArea, componenteAreaTesto);                     //Aggiunge il pannello area dati al contenitore
        
        pack();
    }
    
    //Metodo di ritorno della finestra
    @Override
    public Finestra Ritorna()
    {
        return new FinestraVisualizza();
    }
    
    //Metodo recupera giorno data dal
    public JTextField getDataDalGiorno()
    {
        return campoDataDalGiorno;
    }
    
    //Metodo recupera mese data dal
    public JTextField getDataDalMese()
    {
        return campoDataDalMese;
    }
    
    //Metodo recupera anno data dal
    public JTextField getDataDalAnno()
    {
        return campoDataDalAnno;
    }
    
    //Metodo recupera giorno data al 
    public JTextField getDataAlGiorno()
    {
        return campoDataAlGiorno;
    }
    
    //Metodo recupera mese data al 
    public JTextField getDataAlMese()
    {
        return campoDataAlMese;
    }
    
    //Metodo recupera anno data al 
    public JTextField getDataAlAnno()
    {
        return campoDataAlAnno;
    }

    //Metodi da implementare
    @Override
    public JTextField getCampoUser()
    {
        return null;
    }

    @Override
    public JTextField getCampoPass()
    {
        return null;
    }

    @Override
    public JTextField getCampoNomeGiocatore()
    {
        return null;
    }

    @Override
    public JTextField getNomePartita()
    {
        return null;
    }

    @Override
    public String getCampoGiorno()
    {
        return null;
    }

    @Override
    public String getCampoMese()
    {
        return null;
    }

    @Override
    public String getCampoAnno()
    {
        return null;
    }

    @Override
    public ArrayList<Giocatore> getListaGiocatori()
    {
        return null;
    }

    @Override
    public void setElencoGiocatoriScelti()
    {
    }

    @Override
    public JTable getTabellaPartecipanti()
    {
        return null;
    }
}
