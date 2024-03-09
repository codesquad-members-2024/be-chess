package chess;

import static utils.Position.FIRST_COLUMN_LETTER;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import pieces.Bishop;
import pieces.Blank;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Piece.Color;
import pieces.Piece.PieceSymbol;
import pieces.Queen;
import pieces.Rook;
import utils.Position;

public class Board {
    public static final int FIRST_ROW = 0;
    public static final int LAST_ROW = 7;
    public static final int FIRST_COLUMN = 0;
    public static final int LAST_COLUMN = 7;
    public static final int BLACK_PAWN_ROW = 1;
    public static final int WHITE_PAWN_ROW = 6;
    public static final int EMPTY_CAPACITY = 0;
    public static final int BLANK_CAPACITY = 4;
    public static final int RANK_CAPACITY = 8;
    public static final String LIST_TO_STRING_DELIMITER = "";

    private final List<Piece> whitePieces;
    private final List<Piece> blackPieces;
    private final List<Rank> board;

    public Board() {
        whitePieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        board = new ArrayList<>(RANK_CAPACITY);
    }

    private void addPieces(Color color, List<Piece> piece) {
        if (color.equals(Color.WHITE)) {
            whitePieces.addAll(piece);
            return;
        }
        blackPieces.addAll(piece);
    }

    public void initialize() {
        initializeExceptPawns(Color.BLACK);
        initializePawns(Color.BLACK);
        IntStream.range(EMPTY_CAPACITY, BLANK_CAPACITY).forEach(this::initializeBlank);
        initializePawns(Color.WHITE);
        initializeExceptPawns(Color.WHITE);
    }

    private void initializeBlank(int row) {
        List<Piece> blanks = IntStream.range(EMPTY_CAPACITY, RANK_CAPACITY)
                .mapToObj(col -> new Position(convert2String(row, col)))
                .map(Blank::create)
                .collect(Collectors.toList());

        board.add(new Rank(blanks));
    }

    private String convert2String(int row, int col) {
        return (char) (FIRST_COLUMN_LETTER + col) + String.valueOf(RANK_CAPACITY - row);
    }

    private void initializePawns(Color color) {
        List<Piece> pawns = new ArrayList<>();
        if (color.equals(Color.BLACK)) {
            pawns = initializePawnsWithRow(color, BLACK_PAWN_ROW);
        }
        if (color.equals(Color.WHITE)) {
            pawns = initializePawnsWithRow(color, WHITE_PAWN_ROW);
        }
        addPieces(color, pawns);
        board.add(new Rank(pawns));

    }

    private List<Piece> initializePawnsWithRow(Color color, int row) {
        return IntStream.range(EMPTY_CAPACITY, RANK_CAPACITY)
                .mapToObj(col -> new Position(convert2String(row, col)))
                .map(position -> generatePawn(color, position))
                .collect(Collectors.toList());
    }

    private Piece generatePawn(Color color, Position position) {
        return Pawn.create(color, position);
    }

    private void initializeExceptPawns(Color color) {
        List<Piece> piecesExceptPawns = generatePiecesExceptPawns(color);
        addPieces(color, piecesExceptPawns);
        board.add(new Rank(piecesExceptPawns));
    }

    private ArrayList<Piece> generatePiecesExceptPawns(Color color) {
        int row = determineRow(color);
        int column = FIRST_COLUMN;
        ArrayList<Piece> pieces = new ArrayList<>();
        pieces.add(Rook.create(color, new Position(convert2String(row, column++))));
        pieces.add(Knight.create(color, new Position(convert2String(row, column++))));
        pieces.add(Bishop.create(color, new Position(convert2String(row, column++))));
        pieces.add(Queen.create(color, new Position(convert2String(row, column++))));
        pieces.add(King.create(color, new Position(convert2String(row, column++))));
        pieces.add(Bishop.create(color, new Position(convert2String(row, column++))));
        pieces.add(Knight.create(color, new Position(convert2String(row, column++))));
        pieces.add(Rook.create(color, new Position(convert2String(row, column))));
        return pieces;
    }

    private int determineRow(Color color) {
        if (color.equals(Color.BLACK)) {
            return FIRST_ROW;
        }
        return LAST_ROW;
    }

    public void initializeEmpty() {
        whitePieces.clear();
        blackPieces.clear();
        board.clear();
        IntStream.range(EMPTY_CAPACITY, RANK_CAPACITY).forEach(this::initializeBlank);
    }

    public int pieceCount() {
        return whitePieces.size() + blackPieces.size();
    }

    public int getPieceCount(Color color, PieceSymbol pieceSymbol) {
        return board.stream()
                .mapToInt(rank -> rank.findSameColorAndSymbolPieces(color, pieceSymbol).size())
                .sum();
    }

    public Piece findPiece(Position position) {
        return board.get(position.getRow()).getPiece(position.getCol());
    }

    public void move(Piece piece, Position sourcePos, Position targetPos) {
        setPiece(sourcePos, Blank.create(sourcePos));
        setPiece(targetPos, piece);
    }

    public void setPiece(Position position, Piece piece) {
        board.get(position.getRow()).getPieces().set(position.getCol(), piece);
    }

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

    public List<Rank> getBoard() {
        return board;
    }
}