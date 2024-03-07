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
    /*
    Chess> 와 같은 프롬프트가 있으면 좋겠어요
    처음 시작하면 도움말을 표시해 줘도 좋겠어요.
    상태에 맞지 않는 명령을 못 내리게 하면 좋겠어요. (start- start 라던가, start 없이 move를 한다던가 하는..
    테스트 코드도 있으면 좋겠어요.
     */

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
