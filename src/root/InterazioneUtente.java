package root;

import UnibsLib.AnsiColors;
import UnibsLib.InputData;
import UnibsLib.Menu;
import UnibsLib.RandomDraws;

import java.util.ArrayList;
import java.util.HashMap;


public class InterazioneUtente {

    public static void benvenuto()  {
        System.out.println(Costanti.BENVENUTO);
    }
    public static boolean scegli_nodo(Personaggio personaggio, Mondo mondo, HashMap<String, Integer> mappaEquilibrio)    {

        int pos;

        pos=0;

        System.out.printf(AnsiColors.RED+ Costanti.NOME_MONDO + AnsiColors.RESET,mondo.getNome());

        do {
            System.out.println(Dijkistra.suggerisciNodo(mondo,pos));
            int numCollegamenti = mondo.contaCollegamenti(pos);

            String[] entries =  mondo.getIdCollegamento(pos,numCollegamenti);

            Menu menuNodo = new Menu(Costanti.SCELTA_NODO, entries);
            int scelta = menuNodo.choose()-1;


            mondo.getListaNodi().get(pos).setPassato(true);


            pos = Integer.parseInt(entries[scelta]);


            azione_nodo(personaggio, pos, mondo.getListaNodi(), mondo, mappaEquilibrio);


        }while (pos!=5 && personaggio.getVita()>0);

        if(personaggio.getVita()>0)    {
            System.out.println(Costanti.VITTORIA);
            if(!mondo.isSconfitto())
            {
                personaggio.setPunti();
                System.out.printf(Costanti.PUNTI, personaggio.getPunti());
                mondo.setSconfitto(true);
            }
        }
        else if(personaggio.getNum_tentativo()<10){
            personaggio.setNum_tentativo();
            System.out.printf(Costanti.RIPROVA_GIOCARE, (10-personaggio.getNum_tentativo()));
        }
        else    {
            System.out.println(Costanti.FINE);
            return true;
        }
        return false;
    }

    private static void azione_nodo(Personaggio personaggio, int pos, ArrayList<Nodo> listaNodi, Mondo mondo, HashMap<String, Integer> mappaEquilibrio) {
        int azione = RandomDraws.drawInteger(0,1);
        if(azione==0 || pos == 5)   {
            System.out.println(Costanti.INIZIO_BATTAGLIA);
            if(mondo.getNome().equalsIgnoreCase("Tamagolem"))   {
                Battaglia.scontroTamagolem(personaggio);
            }else   {
                Battaglia.scontraMostro(personaggio, pos, listaNodi);
            }

        }
        else    {
            if(mondo.getNome().equalsIgnoreCase("Tamagolem"))   {
                int modificatore = RandomDraws.drawInteger(1,2);
                switch(modificatore)    {
                    case 1: int vita = RandomDraws.drawInteger(1,2);
                        switch (vita) {
                            case 1 ->{
                                int random = RandomDraws.drawInteger(0,personaggio.getTamaGolem().size()-1);
                                personaggio.setVitaTamaGolem(random);
                                System.out.printf(Costanti.VITA_RIPRISTINATA, random);
                            }
                            case 2 ->{
                                int random = RandomDraws.drawInteger(0,personaggio.getTamaGolem().size()-1);
                                personaggio.rimuoviTamaGolem(random);
                                System.out.printf(Costanti.TAMAGOLEM_MORTO, random);
                            }
                        }
                    case 2: int scelta = RandomDraws.drawInteger(1,3);
                        switch (scelta){
                            case 1:{
                                String x = InputData.readNonEmptyString("Scegli un elemento");
                                String y = InputData.readNonEmptyString("Scegli un elemento");
                                Equilibrio.cambiaEquilibrio(x,y, mappaEquilibrio);
                            }
                            case 2:
                            case 3:
                        }
                 }

            }else   {
                System.out.println(Costanti.STATISTICHE_MODIFICATE);
                personaggio.modificaStatistica();
                System.out.printf(Costanti.VITA, personaggio.getVita());
                System.out.printf(Costanti.ATTACCO,personaggio.getAttacco());
            }

        }
    }

    public static Mondo scegli_mondo(ArrayList<Nodo> listaNodi) {
        String[] entries =  {Costanti.MAPPA_BASE, Costanti.LETTURA_FILE, Costanti.TAMAGOLEM};

        Menu menuNodo = new Menu(Costanti.SWITCH_SCELTA_MONDO, entries);
        int scelta = menuNodo.choose()-1;
        System.out.println(Costanti.SCELTA_MONDO + entries[scelta]);
        return new Mondo(entries[scelta], listaNodi);


    }
}
