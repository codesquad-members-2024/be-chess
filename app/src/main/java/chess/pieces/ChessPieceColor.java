package chess.pieces;

import java.util.Arrays;

public enum ChessPieceColor {
    WHITE("white"),
    BLACK("black");

    private final String colorName;

    ChessPieceColor(String colorName){
        this.colorName = colorName;
    }

    public static ChessPieceColor findMatchingColor(String candidate){
        return Arrays.stream(values())
                .filter(v -> candidate.equals(v.colorName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 색상입니다"));
    }

    public String getColorName() {
        return colorName;
    }
}
