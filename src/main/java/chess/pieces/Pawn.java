package chess.pieces;

public class Pawn {

    private static final String COLOR_ERROR_MESSAGE = "[ERROR] 색상은 white 혹은 black만 가능합니다.";

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
        if (!color.equals(Color.WHITE) && !color.equals(Color.BLACK)) {
            throw new IllegalArgumentException(COLOR_ERROR_MESSAGE);
        }
    }

    public boolean verifyPawn(final Color color) {
        return this.color.equals(color);
    }

    public boolean verifyRepresentation(final String representation) {
        return this.representation.equals(representation);
    }
}
