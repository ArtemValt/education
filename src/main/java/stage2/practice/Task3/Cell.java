package stage2.practice.Task3;

public enum Cell {

    EMPTY(" "),
    BLOCKED("▓"),
    START("S"),
    GOAL("G"),
    PATH("□");
    private final String symbol;

    private Cell(String c) {
        symbol = c;
    }

    @Override
    public String toString() {
        return symbol;
    }
}


