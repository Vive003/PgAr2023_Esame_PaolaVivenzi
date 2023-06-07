package root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Battaglia {
    public static final int TIMEOUT = 100;

    public static void scontraMostro(Personaggio personaggio, int pos, ArrayList<Nodo> listaNodi)  {

        int vita;
        int attacco;

        if(pos!= listaNodi.size())  {
            vita = Costanti.VITA_MOSTRO_INIZ;
            attacco = Costanti.ATTACCO_MOSTRO_INIZ;

        }
        else    {
            System.out.println(Costanti.AVVERSARIO_CAMMO);
            vita = Costanti.VITA_CAMMO;
            attacco = Costanti.ATTACCO_CAMMO;
        }
        Mostro mostro = new Mostro(vita,attacco);


        System.out.printf(Costanti.VITA, personaggio.getVita());
        System.out.printf(Costanti.ATTACCO, personaggio.getAttacco());

        System.out.printf(Costanti.VITA_MOSTRO, mostro.getVita());
        System.out.printf(Costanti.ATTACCO_MOSTRO, mostro.getAttacco());


        boolean vittoriaMostro;
        boolean vittoriaPersonaggio;

        do  {
          vittoriaPersonaggio = personaggio.attacca(mostro);

          if(vittoriaPersonaggio)   {
              System.out.println(Costanti.MOSTRO_MORTO);
              break;
          }
          else  {
              System.out.printf(Costanti.VITA_MOSTRO_SCONTRO, mostro.getVita());
          }
          vittoriaMostro = mostro.attacca(personaggio);

            try {
                TimeUnit.MILLISECONDS.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                System.out.println(Costanti.ERRORE_SLEEP);
            }

            if(vittoriaMostro)   {
                System.out.println(Costanti.SCONFITTO);
            }
            else  {
                System.out.printf(Costanti.VITA_SCONTRO, personaggio.getVita());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                System.out.println(Costanti.ERRORE_SLEEP);
            }

        }while(!vittoriaMostro);
    }

    public static void scontroTamagolem(Personaggio personaggio) {

    }

}
