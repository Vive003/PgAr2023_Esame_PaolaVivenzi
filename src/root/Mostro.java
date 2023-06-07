package root;

import UnibsLib.RandomDraws;

public class Mostro extends Entita{
    public Mostro(int vita, int attacco) {
        super(vita, attacco);
        this.setVita(this.getVita()+RandomDraws.drawInteger(-5,5));
        this.setAttacco(this.getAttacco()+RandomDraws.drawInteger(-2,2));
    }
}
