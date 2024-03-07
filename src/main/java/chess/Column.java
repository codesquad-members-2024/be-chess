package chess;

public enum Column {

    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8);

    private final int column;

    Column(int column) {
        this.column = column;
    }

    public int getColumn() {
        return column;
    }
}
