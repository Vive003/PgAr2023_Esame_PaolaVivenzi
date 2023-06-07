package root;

import java.util.ArrayDeque;
import java.util.Deque;

public class Tamagolem extends Entita{
    private final Deque<Elemento> pietre = new ArrayDeque<>();

    public Tamagolem(int vita, int attacco) {
        super(vita, attacco);
    }

    public Deque<Elemento> getPietre()
    {
        return pietre;
    }


}
