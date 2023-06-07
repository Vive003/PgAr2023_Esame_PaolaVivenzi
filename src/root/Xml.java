package root;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public final class Xml
{
    static XMLInputFactory xmlif = null;
    static XMLStreamReader xmlr = null;

    /**
     * @param filename path del file con cui inizializzare
     */
    public static void inizializzaXMLLettura(String filename) throws FileNotFoundException, XMLStreamException
    {
        xmlif = XMLInputFactory.newInstance();
        xmlr = xmlif.createXMLStreamReader(filename, new FileInputStream(filename));
    }


    /**
     * Legge il file xml e crea gli oggetti inserendoli nell array
     */
    public static ArrayList<Nodo> leggiMappa(String PATH_INPUT) throws XMLStreamException, FileNotFoundException {
        inizializzaXMLLettura("src/files/Mappe.xml");

        int id = 0;

        Tipo_nodo tipoNodo = null;

        ArrayList<Integer> collegamenti = new ArrayList<>();

        ArrayList<Nodo> listaNodi = new ArrayList<>();
        while (xmlr.hasNext()) // continua a leggere finché ha eventi a disposizione
        {
            switch (xmlr.getEventType()) // switch sul tipo di evento
            {
                case XMLStreamConstants.START_ELEMENT ->
                {
                    switch (xmlr.getLocalName())
                    {
                        case "NODO" ->
                        {
                            collegamenti = new ArrayList<>();
                            for (int i = 0; i < xmlr.getAttributeCount(); i++)
                            {
                                if (xmlr.getAttributeLocalName(i).equals("NODO"))
                                {
                                    id = Integer.parseInt(xmlr.getAttributeValue(i));
                                }
                            }
                        }
                        case "TIPO" ->
                        {
                            while(xmlr.hasNext() && xmlr.getEventType() != XMLStreamConstants.CHARACTERS)  //vai fino a caratteri
                                xmlr.next();
                            if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
                            {
                                switch (xmlr.getText()) {
                                    case "INIZIO" -> tipoNodo = Tipo_nodo.INIZIO;
                                    case "INTERMEDIO" -> tipoNodo = Tipo_nodo.INTERMEDIO;
                                    case "FINE" -> tipoNodo = Tipo_nodo.FINE;
                                }
                            }
                        }
                        case "COLLEGAMENTO" ->
                        {
                            while(xmlr.hasNext() && xmlr.getEventType() != XMLStreamConstants.CHARACTERS)  //vai fino a caratteri
                                xmlr.next();
                            collegamenti.add(Integer.valueOf(xmlr.getText()));

                        }
                    }
                }
                case XMLStreamConstants.END_ELEMENT ->
                {
                    if (xmlr.getLocalName().equals("COLLEGAMENTI")) {
                        listaNodi.add(new Nodo(id, tipoNodo, collegamenti));
                    }
                }
            }
            xmlr.next();
        }
        xmlr.close();
        return listaNodi;
    }
}

