package root;

import UnibsLib.AnsiColors;
import UnibsLib.InputData;
import UnibsLib.RandomDraws;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Personaggio extends Entita{
    private int punti=0;
    private int num_tentativo=0;
    private ArrayList<Tamagolem> tamaGolem = new ArrayList<>();

    public Personaggio() {
        super(20, 5);
        for (int i = 0; i < Costanti.NUMERO_TAMAGOLEM; i++) {
            tamaGolem.add(new Tamagolem(Costanti.VITA_MASSIMA, 0));
        }
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti() {
        this.punti +=10;
    }

    public int getNum_tentativo() {
        return num_tentativo;
    }

    public void setNum_tentativo(int num_tentativo) {
        this.num_tentativo = num_tentativo;
    }
    public void setNum_tentativo() {
        this.num_tentativo++;
    }
    public void modificaStatistica() {
        this.setVita(this.getVita()+RandomDraws.drawInteger(-5,10));
        this.setAttacco(this.getAttacco()+RandomDraws.drawInteger(-3,3));
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public ArrayList<Tamagolem> getTamaGolem() {
        return tamaGolem;
    }

    public void setVitaTamaGolem(int pos) {
        tamaGolem.get(pos).setVita(Costanti.VITA_MASSIMA);
    }

    public void reset() {
        this.setVita(20);
    }

    public void rimuoviTamaGolem(int pos)  {
        tamaGolem.remove(tamaGolem.get(pos));
    }
}
