package org.Board;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class PieceLibrary {
    private final HashMap<String, Piece> pieces;

    public PieceLibrary() {
        pieces = new HashMap<>();
    }

    public void addPiece(String name, Piece piece) {
        pieces.put(name, piece);
    }

    public Piece getPiece(String name) {
        return pieces.get(name);
    }

    public void removePiece(String name) {
        pieces.remove(name);
    }

    public Set<String> getAllPieces() {
        return pieces.keySet();
    }

    public void generateRandomPieces(int n, int size) {
        // fix random generator, each block of piece is connected to other
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            Piece p = new Piece();
            for (int j = 0; j < size; j++) {
                int x = rand.nextInt(size);
                int y = rand.nextInt(size);
                p.addOffset(new Point(x, y));
            }
            String name = "Piece" + i;
            addPiece(name, p);
        }
    }

}
