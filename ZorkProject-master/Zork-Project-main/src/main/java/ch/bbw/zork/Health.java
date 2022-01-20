package ch.bbw.zork;

public class Health {
    private final HungerBar h;

    public Health() {
        h = new HungerBar();
    }

    public HungerBar getHungerBar() {
        return h;
    }

    public boolean decrease() {
        h.decrease();
        return h.decrease();
    }

}