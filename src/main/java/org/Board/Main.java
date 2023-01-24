package org.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(6, 6);
        PieceLibrary library = new PieceLibrary();

        library.addPiece("p1", new Piece(new int[][]{{0, 0}, {0, 1}, {1, 1}}));
        library.addPiece("p2", new Piece(new int[][]{{0, 0}, {1, 0}, {1, 1}}));
        library.addPiece("p3", new Piece(new int[][]{{0, 0}, {0, 1}, {1, 1}}));
        library.addPiece("p4", new Piece(new int[][]{{0, 0}, {1, 0}, {1, 1}}));
        library.addPiece("p5", new Piece(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}));
        library.addPiece("p6", new Piece(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}));
        library.addPiece("p7", new Piece(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}));
        library.addPiece("p8", new Piece(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}}));
        library.addPiece("p9", new Piece(new int[][]{{0, 0}, {0, 1}}));
        library.addPiece("p10", new Piece(new int[][]{{0, 0}, {0, 1}}));
        library.addPiece("p11", new Piece(new int[][]{{0, 0}, {0, 1}}));
        library.addPiece("p12", new Piece(new int[][]{{0, 0}, {0, 1}}));
        library.addPiece("p13", new Piece(new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}}));
        library.addPiece("p14", new Piece(new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}}));
        library.addPiece("p15", new Piece(new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 2}}));
        library.addPiece("p16", new Piece(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}, {1, 2}}));
        library.addPiece("p17", new Piece(new int[][]{{0, 0}, {1, 0}}));
        library.addPiece("p18", new Piece(new int[][]{{0, 0}, {1, 0}}));
        library.addPiece("p19", new Piece(new int[][]{{0, 0}, {1, 0}}));
        library.addPiece("p20", new Piece(new int[][]{{0, 0}, {1, 0}}));

        Solver gameSolver = new Solver(board, library);
        long startTime = System.nanoTime();
        gameSolver.solve();
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println(gameSolver.isSolved());

        System.out.println("Elapsed time: " + elapsedTime/1000 + " us");
    }
}