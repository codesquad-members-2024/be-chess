package org.example.chess;

import java.util.Objects;

public class Pawn extends Piece {

    public static final String BLACK = "black";
    public static final String WHTIE = "white";

    String color;

    public Pawn(String color){
        if(!color.equals(BLACK)&&!color.equals(WHTIE)){
            throw new IllegalArgumentException("폰의 색은 하얀색과 검은색만 가능합니다.");
        }
        this.color =color;
    }

    public boolean verifyPawn(String color){
     return this.color==color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pawn pawn = (Pawn) o;
        return Objects.equals(color, pawn.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
