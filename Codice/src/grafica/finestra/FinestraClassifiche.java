package grafica.finestra;

import entita.Giocatore;
import grafica.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import logica.Controllore;

//Classe classifiche
public class FinestraClassifiche extends Finestra
{
    //Costruttore
    public FinestraClassifiche()
    {
        Disegna();
    }
    
    //Metodo di disegno finestra
    private void Disegna()
    {
        contenitore.setLayout(new GridBagLayout());                             //Imposta il lo schema della schermata
        
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
        
        //Sezione bottoni
        ImpostazioniComponente componenteBottoni = new ImpostazioniComponente(0, 2, GridBagConstraints.NONE, 0.0, 4, 1); //Crea impostazioni per sezione bottoni
        JPanel pannelloBottoni = new JPanel(new GridLayout(1, 3, 10, 0));       //Crea pannello per sezione bottoni
        pannelloBottoni.setBorder(new EmptyBorder(25, 0, 10, 0));               //Imposta bordi pannello sezione bottoni
        JPanel pannelloVittorie = new JPanel();                                 //Crea pannello per bottone vittorie
        Bottone bottoneVittorie = new Bottone("Vittorie Giocatori", "Mostra la classifica per vittorie", 150, 25, new Controllore.BottoneVittorie()); //Crea bottone classifica vincitori
        pannelloVittorie.add(bottoneVittorie);                                  //Aggiunge bottone classifica vincitori al pannello     
        JPanel pannelloGuadagni = new JPanel();                                 //Crea pannello per bottone guadagni
        Bottone bottoneGuadagni = new Bottone("Guadagni Giocatori", "Mostra la classifica per guadagno", 150, 25, new Controllore.BottoneGuadagni()); //Crea bottone classifica guadagni
        pannelloGuadagni.add(bottoneGuadagni);                                  //Aggiunge bottone classifica guadagni al pannello     
        JPanel pannelloFuorilegge = new JPanel();                               //Crea pannello per bottone fuorilegge
        Bottone bottoneFuorilegge = new Bottone("Giocatori Fuorilegge", "Mostra la classifica per arrestati", 150, 25, new Controllore.BottoneFuorilegge()); //Crea bottone classifica fuorilegge
        pannelloFuorilegge.add(bottoneFuorilegge);                              //Aggiunge bottone classifica fuorilegge al pannello     
        pannelloBottoni.add(pannelloVittorie);                                  //Aggiunge pannello bottone vittorie al pannello bottoni
        pannelloBottoni.add(pannelloGuadagni);                                  //Aggiunge pannello bottone guadagni al pannello bottoni
        pannelloBottoni.add(pannelloFuorilegge);                                //Aggiunge pannello bottone fuorilegge al pannello bottoni
        contenitore.add(pannelloBottoni, componenteBottoni);                    //Aggiunge sezione bottoni al contenitore
        
        //Sezione area dati
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
