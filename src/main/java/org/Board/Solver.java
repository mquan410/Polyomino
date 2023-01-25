package org.Board;

import java.util.HashMap;

public class Solver {
    private final Board board;
    private boolean complete;
    private final PieceLibrary library;
    private final HashMap<Integer, String> visitedBoardState;
    // TODO: store multiple solutions
//    private Set<Map<String, Point>> solutions;

    public Solver(Board board, PieceLibrary library) {
        this.board = board;
        this.library = library;
        this.complete = false;
        this.visitedBoardState = new HashMap<>();
//        this.solutions = new HashSet<>();
    }

    // TODO: optimize the algorithm
    public boolean solve() {
        if (library.getAllPieces().isEmpty()) {
            return false;
        }
        if (isBoardCompleted()) return true;
        board.print();
        String pieceName = library.getAllPieces().iterator().next();
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                if (tryPlacePieceAt(pieceName, x, y, visitedBoardState)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean tryPlacePieceAt(String pieceName, int x, int y, HashMap<Integer, String> visited) {
        Piece piece = library.getPiece(pieceName);
        int boardHashCode = board.getBoardHashCode();
        if (board.placePiece(piece, x, y, pieceName) && !visited.containsKey(boardHashCode)) {
            extractUsedPieceFromLibrary(pieceName, visited, boardHashCode);
            if (solve()) {
                return true;
            }
            returnExtractedPieceBack(pieceName, x, y, visited, piece, boardHashCode);
        }
        return false;
    }
    private void extractUsedPieceFromLibrary(String pieceName, HashMap<Integer, String> visited, int boardHashCode) {
        visited.put(boardHashCode, pieceName);
        library.removePiece(pieceName);
    }
    private void returnExtractedPieceBack(String pieceName, int x, int y, HashMap<Integer, String> visited, Piece piece, int boardHashCode) {
        library.addPiece(pieceName, piece);
        board.removePiece(piece, x, y, pieceName);
        visited.remove(boardHashCode);
    }

    private boolean isBoardCompleted() {
        if (board.isComplete()) {
            complete = true;
            board.print();
            return true;
        }
        return false;
    }

    public boolean isSolved() {
        return complete;
    }
}
