package org.example;

public class Pawn {

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
}
