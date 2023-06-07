package root;

import javax.print.DocPrintJob;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
       ArrayList<Nodo> listaNodi = Xml.leggiMappa(Costanti.NOME_FILE);

        HashMap<String, Integer> mappaEquilibrio = Equilibrio.creaMappaEquilibrio();

        InterazioneUtente.benvenuto();
        boolean uscita;
        Personaggio personaggio = new Personaggio();
        do  {
            Mondo mondo= InterazioneUtente.scegli_mondo(listaNodi);
            uscita = InterazioneUtente.scegli_nodo(personaggio,mondo,mappaEquilibrio);
            personaggio.reset();

        }while(!uscita);

    }
}
