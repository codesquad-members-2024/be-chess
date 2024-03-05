package org.codeSquad;

public class Pawn {
    private ChessPieceColor color;

    public Pawn(String color){
        this.color = ChessPieceColor.findMatchingColor(color);
    }

    public String getColor() {
        return color.getColorName();
    }
}
