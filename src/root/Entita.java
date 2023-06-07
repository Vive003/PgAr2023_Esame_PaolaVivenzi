package root;

public class Entita {
    private int vita;
    private int attacco;

    public Entita(int vita, int attacco) {
        this.vita = vita;
        this.attacco = attacco;
    }

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public int getAttacco() {
        return attacco;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    @Override
    public String toString() {
        return "Entita{" +
                "vita=" + vita +
                ", attacco=" + attacco +
                '}';
    }

    public boolean attacca(Entita entita) {
        entita.vita = entita.vita - this.attacco;

        if(entita.vita<=0)  {
            return true;
        }
        return false;
    }
}
