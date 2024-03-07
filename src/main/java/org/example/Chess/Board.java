    package org.example.Chess;

    import org.example.Pieces.Color;
    import org.example.Pieces.Piece;

    import static org.example.Pieces.PieceFactory.*;
    import static org.example.Utils.StringUtils.appendNewLine;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.stream.Collectors;
    import java.util.stream.IntStream;

    public class Board {
        private static final int BOARD_SIZE = 8;
        private List<Piece> whitePiece;
        private List<Piece> blackPiece;
        private List<List<Piece>> board;

        public Board() {
            whitePiece = new ArrayList<>();
            blackPiece = new ArrayList<>();
            board = new ArrayList<>();
            IntStream.range(0, BOARD_SIZE).forEach(i -> board.add(new ArrayList<>()));
        }

        public void initialize() {
            initBlackPieces();
            initWhitePieces();
            fillEmptySpaces();
        }
        void initBlackPieces() {
            IntStream.range(0, BOARD_SIZE).forEach(i -> {
                Piece blackPawn = createBlackPawn();
                addPiece(blackPawn);
                board.get(1).add(blackPawn);
            });
            addPiece(createBlackRook());
            addPiece(createBlackKnight());
            addPiece(createBlackBishop());
            addPiece(createBlackQueen());
            addPiece(createBlackKing());
            addPiece(createBlackBishop());
            addPiece(createBlackKnight());
            addPiece(createBlackRook());
            board.get(0).addAll(blackPiece.subList(BOARD_SIZE, blackPiece.size()));
        }
        void initWhitePieces() {
            IntStream.range(0, BOARD_SIZE).forEach(i -> {
                Piece whitePawn = createWhitePawn();
                addPiece(whitePawn);
                board.get(6).add(whitePawn);
            });
            addPiece(createWhiteRook());
            addPiece(createWhiteKnight());
            addPiece(createWhiteBishop());
            addPiece(createWhiteQueen());
            addPiece(createWhiteKing());
            addPiece(createWhiteBishop());
            addPiece(createWhiteKnight());
            addPiece(createWhiteRook());
            board.get(7).addAll(whitePiece.subList(BOARD_SIZE, whitePiece.size()));
        }


        private void fillEmptySpaces() {
            IntStream.range(0, BOARD_SIZE).forEach(i -> {
                if (i != 1 && i != 6) {
                    IntStream.range(0, BOARD_SIZE).forEach(j -> {
                        if (board.get(i).size() <= j) {
                            board.get(i).add(null);
                        } else if (board.get(i).get(j) == null) {
                            board.get(i).set(j, null);
                        }
                    });
                }
            });
        }

        public void addPiece(Piece piece) {
            if (piece.getColor().equals(Color.WHITE)) {
                whitePiece.add(piece);
            } else {
                blackPiece.add(piece);
            }
        }

        public int pieceCount() {
            return whitePiece.size() + blackPiece.size();
        }

        public String showBoard() {
            return board.stream()
                    .map(this::getRowPrint)
                    .collect(Collectors.joining(appendNewLine("")));
        }

        private String getRowPrint(List<Piece> row) {
            return row.stream()
                    .map(this::getPiecePrint)
                    .collect(Collectors.joining(""));
        }
        private String getPiecePrint(Piece piece) {
            return piece == null ? "." : Character.toString(piece.getRepresentation());
        }

        public String getWhitePiecesResult() {
            return getPiecesResult(whitePiece);
        }

        public String getBlackPiecesResult() {
            return getPiecesResult(blackPiece);
        }

        private String getPiecesResult(List<Piece> pieces) {
            return pieces.stream()
                    .map(piece -> Character.toString(piece.getRepresentation()))
                    .collect(Collectors.joining());
        }
    }