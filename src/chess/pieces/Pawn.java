package src.chess.pieces;

public class Pawn {
    private Colors color;
    private Representation representation;

    public Pawn(Colors color) {
        this.color = color;
        setRepresentation();
    }

    public Pawn() {
        this.color = Colors.WHITE;
        setRepresentation();
    }

    // 색에 따라서 Representation 설정해준다
    private void setRepresentation() {
        if (color.equals(Colors.WHITE)) {
            representation = Representation.WHITE_PAWN;
        } else {
            representation = Representation.BLACK_PAWN;
        }
    }

    public String getColor() {
        return color.getColorName();
    }

    @Override
    public String toString() {
        return representation.getMark();
    }
}
