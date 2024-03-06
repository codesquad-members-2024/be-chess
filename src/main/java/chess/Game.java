package chess;

import chess.board.Board;
import chess.board.Position;
import chess.utils.ErrorMessage;
import chess.utils.MainCommand;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private static final String ASK_MAIN_COMMAND = "> 메인 명령어를 입력해주세요.";
    private static final String ASK_MOVE_COMMAND = "> 이동 명령어를 입력해주세요.";
    private static final Pattern MOVE_COMMAND_PATTERN = Pattern.compile(
            "^move\\s+([a-zA-Z][0-9])\\s+([a-zA-Z][0-9])\\s*$", Pattern.CASE_INSENSITIVE);

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Board board = new Board();
        board.initialize();
        MainCommand mainCommand = getOrRetry(() -> MainCommand.of(readMenuCommand()));

        while (mainCommand != MainCommand.END) {
            print(board);
            runOrRetry(() -> move(board));
        }
    }

    private static String readMenuCommand() {
        System.out.println(ASK_MAIN_COMMAND);
        return sc.nextLine();
    }

    private static void print(Board board) {
        String showBoard = board.showBoard();
        System.out.println(showBoard);
    }

    private static void move(Board board) {
        System.out.println(ASK_MOVE_COMMAND);
        String moveCommand = sc.nextLine();
        Matcher matcher = MOVE_COMMAND_PATTERN.matcher(moveCommand);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_COMMAND.getValue());
        }
        Position source = new Position(matcher.group(1));
        Position target = new Position(matcher.group(2));

        board.move(source, target);
    }

    private static <T> T getOrRetry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void runOrRetry(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
