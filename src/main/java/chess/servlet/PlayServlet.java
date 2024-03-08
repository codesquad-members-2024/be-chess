package chess.servlet;

import chess.board.Board;
import chess.board.Position;
import chess.game.Game;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/play")
public class PlayServlet extends HttpServlet {
    private static final String WHITE_TURN_MESSAGE = "화이트의 턴입니다.";
    private static final String BLACK_TURN_MESSAGE = "블랙의 턴입니다.";

    private final Board board = new Board();
    private final Game game = new Game(board);

    public PlayServlet() {
        board.initialize();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // GET 요청 처리
        boolean whiteTurn = game.isWhiteTurn();
        String turnMessage = getTurnMessage(whiteTurn);
        request.setAttribute("turnMessage", turnMessage);
        request.setAttribute("board", board);

        if (game.isOver()) {
            String viewPath = "/WEB-INF/views/end.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
            dispatcher.forward(request, response);
            return;
        }

        String viewPath = "/WEB-INF/views/chess.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<String> errorMessages = new ArrayList<>();
        move(request, errorMessages);

        if (!errorMessages.isEmpty()) {
            request.setAttribute("errorMessage", errorMessages.get(0));
        }

        boolean whiteTurn = game.isWhiteTurn();
        String turnMessage = getTurnMessage(whiteTurn);

        request.setAttribute("turnMessage", turnMessage);
        request.setAttribute("board", board);

        if (game.isOver()) {
            String viewPath = "/WEB-INF/views/end.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
            dispatcher.forward(request, response);
            return;
        }

        String viewPath = "/WEB-INF/views/chess.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

    }

    private String getTurnMessage(boolean whiteTurn) {
        if (whiteTurn) {
            return WHITE_TURN_MESSAGE;
        }
        return BLACK_TURN_MESSAGE;
    }

    private void move(HttpServletRequest request, List<String> errorMessages) {
        try {
            Position source = new Position(request.getParameter("source"));
            Position target = new Position(request.getParameter("target"));
            game.move(source, target);
        } catch (IllegalArgumentException e) {
            errorMessages.add(e.getMessage());
        }

    }
}
