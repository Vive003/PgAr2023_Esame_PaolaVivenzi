package root;

import java.util.*;


public class Dijkistra {

    public static String suggerisciNodo(Mondo mondo, int pos) {
        Queue<Integer> coda = new LinkedList<>();
        Set<Integer> nodiVisitati = new HashSet<>();
        Map<Integer, Integer> predecessori = new HashMap<>();
        int nodoFinale = mondo.getListaNodi().get(mondo.getListaNodi().size() - 1).getId();
        int nodoIniziale = mondo.getListaNodi().get(pos).getId();

        coda.offer(nodoIniziale);
        nodiVisitati.add(nodoIniziale);
        List<Integer> nodiAdiacenti;

        while (!coda.isEmpty()) {
            int nodoCorrente = coda.poll();

            if (nodoCorrente == nodoFinale) {
                break;
            }

            // Trova la lista di nodi adiacenti al nodo corrente
            for (int i = 0; i < mondo.getListaNodi().size(); i++) {
                if (nodoCorrente == mondo.getListaNodi().get(i).getId()) {
                    nodiAdiacenti = mondo.getListaNodi().get(i).getListaCollegamenti();

                    // Itera sui nodi adiacenti
                    for (int nodo : nodiAdiacenti) {
                        if (!nodiVisitati.contains(nodo)) {
                            coda.offer(nodo);
                            nodiVisitati.add(nodo);
                            predecessori.put(nodo, nodoCorrente);
                        }
                    }
                    break; // Esci dal ciclo for
                }
            }
        }

        if (!predecessori.containsKey(nodoFinale)) {
            return "Nodo finale non raggiungibile.";
        }

        // Costruzione del percorso ottimale dal nodo iniziale al nodo finale
        List<Integer> percorso = new ArrayList<>();
        int nodo = nodoFinale;
        percorso.add(nodo);

        while (nodo != nodoIniziale) {
            nodo = predecessori.get(nodo);
            percorso.add(nodo);
        }

        Collections.reverse(percorso);

        // Suggerimento del nodo successivo da scegliere
        int nodoSuggerito = percorso.get(0);
        return "Suggerimento: Sposta al nodo " + nodoSuggerito;
    }
}