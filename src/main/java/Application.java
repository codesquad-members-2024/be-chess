import static chess.ChessGame.SOURCE_POS_INDEX;

import chess.Board;
import chess.ChessGame;
import java.util.Scanner;
import java.util.regex.Pattern;
import pieces.Piece.Color;
import utils.Position;
import view.ChessView;

public class Application {
    private static final String START = "start";
    private static final String END = "end";
    private static final Pattern MOVE_PATTERN = Pattern.compile("^\\s?move\\s+[a-h][1-8]\\s+[a-h][1-8]\\s?$");
    private static final String OTHER_SIDE_PIECE_ERROR_MESSAGE = "상대편 기물은 이동할 수 없습니다.";
    private static final String MOVE_PATTERN_ERROR_MESSAGE = "등록되지 않은 명령입니다.";

    public static void main(String[] args) {
        Board board = new Board();
        ChessGame chessGame = new ChessGame(board);
        ChessView chessView = new ChessView(board);
        matchCommand(board, chessGame, chessView);
    }

    private static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void matchCommand(Board board, ChessGame chessGame, ChessView chessView) {
        String userInput = getUserInput();
        Color startColor = Color.WHITE;
        while (!userInput.equals(END)) {
            if (userInput.equals(START)) {
                board.initialize();
                chessView.showBoard();
            } else if (MOVE_PATTERN.matcher(userInput).matches()) {
                Position pos = new Position(chessGame.convertToPos(userInput)[SOURCE_POS_INDEX]);
                if (startColor.equals(board.findPiece(pos).getColor())) {
                    chessGame.moveBoard(userInput);
                    chessView.showBoard();
                    startColor = changeColor(startColor);
                } else {
                    System.out.println(OTHER_SIDE_PIECE_ERROR_MESSAGE);
                }
            } else {
                System.out.println(MOVE_PATTERN_ERROR_MESSAGE);
            }
            userInput = getUserInput();
        }
    }

    private static Color changeColor(Color color) {
        if (color.equals(Color.WHITE)) {
            return Color.BLACK;
        }
        return Color.WHITE;
    }
}
