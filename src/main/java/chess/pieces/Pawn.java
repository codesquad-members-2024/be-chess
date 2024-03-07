package chess.pieces;

import java.util.HashMap;
import java.util.Map;

public class Pawn {

    private final Map<Color, Representation> type;
    private final Color color;
    private final String representation;

    public Pawn() {
        type = new HashMap<>();
        setType();
        this.color = Color.WHITE;
        this.representation = setRepresentation(color);
    }

    public Pawn(Color color) {
        validate(color);
        type = new HashMap<>();
        setType();
        this.color = color;
        this.representation = setRepresentation(color);
    }

    private void validate(Color color) {
        if (color == null) {
            throw new IllegalArgumentException();
        }
    }

    private void setType() {
        type.put(Color.WHITE, Representation.WHITE_PAWN);
        type.put(Color.BLACK, Representation.BLACK_PAWN);
    }

    private String setRepresentation(Color color) {
        return type.get(color).getRepresentation();
    }

    public boolean verifyPawnColor(final Color color) {
        return this.color.equals(color);
    }

    public boolean verifyPawnRepresentation(final String representation) {
        return this.representation.equals(representation);
    }
}
