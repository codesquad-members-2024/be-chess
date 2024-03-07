import chess.Board;
import chess.ChessGame;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class GameLauncher {
    static ChessGame game;
    static Pattern moveRegex = Pattern.compile("move( [a-h][1-8]){2}");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            String input = sc.nextLine();

            if(input.equals("start")) runGame();
            else if(moveRegex.matcher(input).matches() && game!=null) tryMove(input);
            else if(input.equals("end")) return;
            else System.out.println("잘못된 명령입니다.");
        }
    }

    private static void runGame() {
        Board board = new Board();
        board.init();

        game = new ChessGame(board);
        board.print();
    }
    private static void tryMove(String positions) {
        StringTokenizer st = new StringTokenizer(positions, " ");
        st.nextToken();
        try {
            game.movePieceAt(st.nextToken(), st.nextToken());
        }catch (IllegalArgumentException failMove){
            System.out.println("이동할 수 없는 위치입니다.");
        }
    }
}
