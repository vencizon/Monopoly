package logica;

import grafica.*;
import database.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controllore
{
    private static Finestra finestraAttuale;
    private static Finestra finestraPrecedente;
    private Data data;
    
    public Controllore(Data d, Finestra f)
    {
        finestraAttuale = f;
        data = d;
    }
    
    public static class BottoneEsci implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
    
    public static class BottoneIndietro implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraPrecedente = finestraAttuale;
            finestraAttuale.dispose();
            finestraAttuale = finestraPrecedente.Ritorna();
            finestraPrecedente.dispose();
        }
    }
    
    public static class BottoneAccedi implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();
            finestraAttuale = new FinestraHome();
        }
    }
    
    public static class BottoneVisualizzaDati implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();
            finestraAttuale = new FinestraVisualizza();
        }
    }
    
    public static class BottoneAggiornaData implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();
            finestraAttuale = new FinestraAggiorna();
        }
    }
    
    public static class BottoneClassifica implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();
            //finestra = new FinestraHome();
        }
    }
    
    public static class BottonePartite implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();
            //finestra = new FinestraHome();
        }
    }
    
    public static class BottoneAggiungiGiocatore implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();
        }   
    }
    
    public static class BottoneIniziaPartita implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();
        }   
    }
    
    public static class BottoneContinuaPartita implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            finestraAttuale.dispose();
        }   
    }
}
