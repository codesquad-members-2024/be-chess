package chess.pieces;

public class Pawn {

    private final Color color;
    private final String representation;

    public Pawn() {
        this.color = Color.WHITE;
        this.representation = setRepresentation(color);
    }

    public Pawn(Color color) {
        validate(color);
        this.color = color;
        this.representation = setRepresentation(color);
    }

    private String setRepresentation(Color color) {
        for (Representation representation : Representation.values()) {
            if (representation.getColor().equals(color)) {
                return representation.getRepresentation();
            }
        }
        // 이미 validate에서 검증했기 때문에 null이 반환되는 상황은 없습니다.
        return null;
    }

    private void validate(Color color) {
        if (color == null) {
            throw new IllegalArgumentException();
        }
    }

    public boolean verifyPawnColor(final Color color) {
        return this.color.equals(color);
    }

    public boolean verifyPawnRepresentation(final String representation) {
        return this.representation.equals(representation);
    }
}
