package root;

import java.util.*;

public class Mondo {
    private String nome;
    private boolean sconfitto = false;
    private ArrayList<Nodo> listaNodi = new ArrayList<>();

    private ArrayList<Integer> listaControllati = new ArrayList<>();


    public Mondo(String nome, ArrayList<Nodo> listaNodi) {
        this.nome = nome;
        if(nome.equalsIgnoreCase("mappa_base"))   {
            mappa_base();
        }
        else    {
            this.listaNodi = listaNodi;
        }
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isSconfitto() {
        return sconfitto;
    }

    public void setSconfitto(boolean sconfitto) {
        this.sconfitto = sconfitto;
    }


    public ArrayList<Nodo> getListaNodi() {
        return listaNodi;
    }

    public void setListaNodi(ArrayList<Nodo> lisaNodi) {
        this.listaNodi = lisaNodi;
    }

    public void mappa_base()   {
        for (int i = 0; i < 6; i++) {
            listaNodi.add(new Nodo(i+1));
            listaNodi.get(i).setTipoNodo(Tipo_nodo.INTERMEDIO);
        }
        listaNodi.get(0).setTipoNodo(Tipo_nodo.INTERMEDIO);
        listaNodi.get(0).listaCollegamenti.add(listaNodi.get(1).getId());
        listaNodi.get(1).listaCollegamenti.add(listaNodi.get(0).getId());
        listaNodi.get(1).listaCollegamenti.add(listaNodi.get(2).getId());
        listaNodi.get(1).listaCollegamenti.add(listaNodi.get(3).getId());
        listaNodi.get(2).listaCollegamenti.add(listaNodi.get(1).getId());
        listaNodi.get(2).listaCollegamenti.add(listaNodi.get(4).getId());
        listaNodi.get(3).listaCollegamenti.add(listaNodi.get(1).getId());
        listaNodi.get(3).listaCollegamenti.add(listaNodi.get(4).getId());
        listaNodi.get(4).listaCollegamenti.add(listaNodi.get(2).getId());
        listaNodi.get(4).listaCollegamenti.add(listaNodi.get(3).getId());
        listaNodi.get(4).listaCollegamenti.add(listaNodi.get(5).getId());
        listaNodi.get(5).listaCollegamenti.add(listaNodi.get(4).getId());

    }

    public int contaCollegamenti(int pos)  {

        int conta=0;
        for (int i = 0; i < listaNodi.size(); i++) {
            listaControllati= new ArrayList<>();
            if(!listaNodi.get(i).isPassato() && listaNodi.get(pos).listaCollegamenti.contains(listaNodi.get(i).getId()))    {
                conta++;
                }
            }
        return conta;
    }

    public String[] getIdCollegamento(int pos, int collegamenti) {
        String[] entries = new String[collegamenti];
        int j=0;
        for (int i = 0; i < listaNodi.size(); i++) {
            listaControllati= new ArrayList<>();
            if(listaNodi.get(pos).isCollegato(listaNodi.get(i).getId()) && !listaNodi.get(i).isPassato())     {

                entries[j]= String.valueOf(i);

                j++;
                if(j==collegamenti) return entries;
            }
        }
        return entries;
    }


    public boolean vaBene(Nodo nodoAttuale)     {
        Queue<Integer> coda = new LinkedList<>();
        List<Integer> nodiAdiacenti;
        Set<Integer> nodiVisitati = new HashSet<>();
        Map<Integer, Integer> predecessori = new HashMap<>();
        for (int i = 0; i < getListaNodi().size(); i++) {
            if (nodoAttuale.getId() == getListaNodi().get(i).getId()) {
                nodiAdiacenti = getListaNodi().get(i).getListaCollegamenti();

                // Itera sui nodi adiacenti
                for (int nodo : nodiAdiacenti) {
                    if (!nodiVisitati.contains(nodo)) {
                        coda.offer(nodo);
                        nodiVisitati.add(nodo);
                        predecessori.put(nodo, nodoAttuale.getId());
                    }
                }
                break; // Esci dal ciclo for
            }
        }
        return false;
    }
}
