package root;

import java.util.ArrayList;

public class Nodo {
    private int id;
    private boolean passato = false;
    private int collegamento;
    private Tipo_nodo tipoNodo;
    ArrayList<Integer> listaCollegamenti = new ArrayList<>();

    public Nodo(int id) {
        this.id = id;
    }

    public Nodo(int id, Tipo_nodo tipoNodo, ArrayList<Integer> listaCollegamenti) {
        this.id = id;
        this.tipoNodo = tipoNodo;
        this.listaCollegamenti = listaCollegamenti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPassato() {
        return passato;
    }

    public void setPassato(boolean passato) {
        this.passato = passato;
    }

    public int getCollegamento() {
        return collegamento;
    }

    public void setCollegamento(int collegamento) {
        this.collegamento = collegamento;
    }

    public Tipo_nodo getTipoNodo() {
        return tipoNodo;
    }

    public void setTipoNodo(Tipo_nodo tipoNodo) {
        this.tipoNodo = tipoNodo;
    }

    public ArrayList<Integer> getListaCollegamenti() {
        return listaCollegamenti;
    }

    public void setListaCollegamenti(ArrayList<Integer> listaCollegamenti) {
        this.listaCollegamenti = listaCollegamenti;
    }

    public boolean isCollegato(int id)  {
        for (int i = 0; i < listaCollegamenti.size(); i++) {
            if(listaCollegamenti.get(i).equals(id)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "id=" + id +
                ", passato=" + passato +
                ", collegamento=" + collegamento +
                ", tipoNodo=" + tipoNodo +
                ", listaCollegamenti=" + listaCollegamenti +
                '}';
    }
}
