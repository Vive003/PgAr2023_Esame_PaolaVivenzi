package root;

import UnibsLib.AnsiColors;

import java.util.HashMap;

public class Costanti {

    public static final String BENVENUTO = AnsiColors.YELLOW+"Benvenuto giovane! Questo è l’Arnaldo-verse, dove l’unica sicurezza è che la bocciatura è dietro ogni angolo \n Se siete giunto qui è solo per affrontare l’ultima prova del progetto Arnaldo. \n Per farlo vi aspettano diverse prove in modo da salvare questa landa desolate, e infine, sconfiggere il terribile e antico stregone dell’ordine del K-Pop: Cammo; come prova di essere degni e meritevoli della sufficienza all’esame"+ AnsiColors.RESET;
    public static final String NOME_MONDO = "Siamo nel mondo %s \n";
    public static final String SCELTA_NODO = "Ora devi scegliere da che parte andare per raggiungere Cammo";
    public static final String VITTORIA = AnsiColors.GREEN+"Complimenti hai battuto Cimmo \n"+AnsiColors.RESET;
    public static final String RIPROVA_GIOCARE = AnsiColors.RED+"Riprova a giocare hai ancora %d tentativi \n"+AnsiColors.RESET;
    public static final String FINE =AnsiColors.RED+"Hai finito le tue chance \n"+AnsiColors.RESET;
    public static final String INIZIO_BATTAGLIA = "Ha inizio la battaglia";
    public static final String STATISTICHE_MODIFICATE = "Le tue statistiche sono modificate";
    public static final String VITA = "La tua "+AnsiColors.BLUE+"vita"+AnsiColors.RESET+" è di %d \n";
    public static final String ATTACCO = "Il tuo "+AnsiColors.CYAN+"attacco"+AnsiColors.RESET+" è di %d \n";
    public static final String VITA_MOSTRO = "La "+AnsiColors.BLUE+"vita"+AnsiColors.RESET+" del tuo avversario è di %d \n";
    public static final String ATTACCO_MOSTRO = "L'"+AnsiColors.CYAN+"attacco"+AnsiColors.RESET+" del tuo avversario è di %d \n";
    public static final String AVVERSARIO_CAMMO = "Sei contro Cammo";
    public static final String MOSTRO_MORTO = AnsiColors.RED+"Hai sconfitto il mostro"+AnsiColors.RESET;
    public static final String VITA_MOSTRO_SCONTRO = "Bel colpo! Il mostro ha ancora "+AnsiColors.RED+"%d"+AnsiColors.RESET+ " di "+AnsiColors.BLUE+"vita"+AnsiColors.RESET+" \n";
    public static final String SCONFITTO = "Il mostro ti ha sconfitto";
    public static final String VITA_SCONTRO = "Il mostro ti ha colpito, hai ancora "+AnsiColors.RED+"%d"+AnsiColors.RESET+ " di "+AnsiColors.BLUE+"vita"+AnsiColors.RESET+" \n";
    public static final String ERRORE_SLEEP = "Errore nella funzione time.sleep";
    public static final int VITA_MOSTRO_INIZ = 12;
    public static final int ATTACCO_MOSTRO_INIZ = 3;
    public static final int VITA_CAMMO = 18;
    public static final int ATTACCO_CAMMO = 4;
    public static final int NUMERO_ELEMENTI = 6;
    public static final int VITA_MASSIMA = 100;
    public static final int CONTATORE_MASSIMO = 200;


    public static final String SWITCH_SCELTA_MONDO = "Scegli il mondo" ;
    public static final String SCELTA_MONDO = "HAI SCELTO ";
    public static final String MAPPA_BASE = "mappa_base";
    public static final String LETTURA_FILE = "lettura_file";
    public static final String NOME_FILE = "/files/Mappe.xml";
    public static final String PUNTI = "Ora hai "+AnsiColors.RED+"%d"+AnsiColors.RESET+" punti! \n";
    public static final String SEP = "------------------------------------------------------------------------";
    public static final String TAMAGOLEM = "Tamagolem";
    public static final String VITA_RIPRISTINATA = "La vita del tamagolem numero %d è stata ripristinata \n";
    public static final String TAMAGOLEM_MORTO = "Il tamagolem è morto \n";
    public static final String TERRA = "TERRA";
    public static final String FUOCO = "FUOCO";
    public static final String GHIACCIO = "GHIACCIO";
    public static final String ACQUA = "ACQUA";
    public static final String BUIO = "BUIO";
    public static final String VELENO = "VELENO";
    public static final int NUMERO_PIETRE = ((NUMERO_ELEMENTI+1)/3)+1;  //⎡(N + 1) / 3⎤ + 1.
    public static final int NUMERO_TAMAGOLEM = ((NUMERO_ELEMENTI-1)*(NUMERO_ELEMENTI-2)/(2*NUMERO_PIETRE));  ////⎡(N - 1)(N - 2) / (2 * P)⎤
    public static final int NUMERO_SCORTA_COMUNE = ((2*NUMERO_TAMAGOLEM*NUMERO_PIETRE)/NUMERO_ELEMENTI)*NUMERO_ELEMENTI;  //⎡(2 * G * P) / N⎤ * N

    public static HashMap<String, Integer> SCORTA_COMUNE = new HashMap<>();

    public static void inizializzaScortaComune()
    {
        SCORTA_COMUNE.put(TERRA,NUMERO_SCORTA_COMUNE/NUMERO_ELEMENTI);
        SCORTA_COMUNE.put(FUOCO,NUMERO_SCORTA_COMUNE/NUMERO_ELEMENTI);
        SCORTA_COMUNE.put(GHIACCIO,NUMERO_SCORTA_COMUNE/NUMERO_ELEMENTI);
        SCORTA_COMUNE.put(ACQUA,NUMERO_SCORTA_COMUNE/NUMERO_ELEMENTI);
        SCORTA_COMUNE.put(BUIO,NUMERO_SCORTA_COMUNE/NUMERO_ELEMENTI);
        SCORTA_COMUNE.put(VELENO,NUMERO_SCORTA_COMUNE/NUMERO_ELEMENTI);
    }

}

