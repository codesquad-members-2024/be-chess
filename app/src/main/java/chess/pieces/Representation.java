package chess.pieces;

import java.util.Map;

public enum Representation {
    PAWN(Map.ofEntries(
            Map.entry(Color.WHITE, "♙"),
            Map.entry(Color.BLACK, "♟")));

    private final Map<Color, String> representationByColors;

    Representation(Map<Color, String> representationByColors){
        this.representationByColors = representationByColors;
    }

    public String inColor(Color color) {
        return getRepresentationByColors().get(color);
    }

    private Map<Color, String> getRepresentationByColors() {
        return representationByColors;
    }
}
