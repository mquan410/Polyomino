package org.Board;

public class Solver {
    private final Board board;
    private boolean complete;
    private final PieceLibrary library;
    // TODO: store multiple solutions
//    private Set<Map<String, Point>> solutions;

    public Solver(Board board, PieceLibrary library) {
        this.board = board;
        this.library = library;
        this.complete = false;
//        this.solutions = new HashSet<>();
    }

    // TODO: optimize the algorithm
    public boolean solve() {
        if (library.getAllPieces().isEmpty()) {
            return false;
        }
        if (board.isComplete()) {
            complete = true;
            board.print();
            return true;
        }
        board.print();
        Trie trie = new Trie();
        String pieceName = library.getAllPieces().iterator().next();
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                if (tryPlacePieceAt(pieceName, x, y, trie)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean tryPlacePieceAt(String pieceName, int x, int y, Trie trie) {
        Piece piece = library.getPiece(pieceName);

        if (board.placePiece(piece, x, y, pieceName) && !trie.search(pieceName)) {
            trie.insert(pieceName);
            library.removePiece(pieceName);

            if (solve()) {
                return true;
            }
            library.addPiece(pieceName, piece);
            board.removePiece(piece, x, y, pieceName);
        }
        return false;
    }

    public boolean isSolved() {
        return complete;
    }

    //    public boolean solve() {
//        if (board.isComplete()){
//            complete = true;
//            board.print();
//            return true;
//        }
//        if (library.getAllPieces().isEmpty()) {
//            return false;
//        }
//        bitboardManager.printBoard(boardID);
//        String pieceName = library.getPieceNames().iterator().next();
//        Piece piece = library.getPiece(pieceName);
//
//        for (int x = 0; x < bitboardManager.getBitboardList().get(boardID).getWidth(); x++) {
//            for (int y = 0; y < bitboardManager.getBitboardList().get(boardID).getHeight(); y++) {
//                if (bitboardManager.placePiece(piece,boardID, x, y)) {
//                    library.removePiece(pieceName);
//                    if (solve()) {
//                        return true;
//                    }
//                    library.addPiece(pieceName, piece);
//                    bitboardManager.removePiece(piece, boardID, x, y);
//                }
//            }
//        }
//        return false;
//    }
}
