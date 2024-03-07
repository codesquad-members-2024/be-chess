package chess;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Board board = new Board();
        if (s.equals("start")) {
            board.start();
        } else if (s.equals("end")) {
            board.end();
        }
    }
}