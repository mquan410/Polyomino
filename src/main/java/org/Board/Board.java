package org.Board;

import lombok.*;

import java.awt.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Board {
    private final int width;
    private final int height;
    private BigInteger data;
    private final Map<String, Point> pieceOffsets;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.data = BigInteger.ZERO.shiftLeft(width * height).subtract(BigInteger.ZERO);
        this.pieceOffsets = new HashMap<>();
    }

    public boolean placePiece(Piece piece, int x, int y, String pieceName) {
        if (!isValidPlacement(piece, x, y)){
            return false;
        }
        setBitInBoard(piece, x, y, pieceName);
        return true;
    }

    private void setBitInBoard(Piece piece, int x, int y, String pieceName) {
        for (Point offset : piece.getOffsets()) {
            Point piecePosition = calculatePiecePosition(x, y, offset);
            data = data.setBit(calculateIndex(piecePosition));
            pieceOffsets.put(pieceName, piecePosition);
        }
    }

    private int calculateIndex(Point piecePosition) {
        return piecePosition.y * width + piecePosition.x;
    }

    private Point calculatePiecePosition(int x, int y, Point offset) {
        int pieceXPositionInBoard = x + offset.x;
        int pieceYPositionInBoard = y + offset.y;
        return new Point(pieceXPositionInBoard, pieceYPositionInBoard);
    }

    private boolean isValidPlacement(Piece piece, int x, int y) {
        for (Point offset : piece.getOffsets()) {
            Point piecePosition = calculatePiecePosition(x, y, offset);
            if (IsInBound(piecePosition.x, piecePosition.y)){
                return false;
            }
            if (IsCollided(calculateIndex(piecePosition))){
                return false;
            }
        }
        return true;
    }

    private boolean IsInBound(int posX, int posY) {
        return posX < 0 || posX >= width || posY < 0 || posY >= height;
    }

    private boolean IsCollided(int index) {
        // testBit returns the state of the bit if it is occupied by other piece
        return data.testBit(index);
    }

    public void removePiece(Piece piece, int x, int y, String pieceName) {
        clearBitInBoard(piece, x, y);
        pieceOffsets.remove(pieceName);
    }

    private void clearBitInBoard(Piece piece, int x, int y) {
        for (Point offset : piece.getOffsets()) {
            data = data.clearBit(calculateIndex(calculatePiecePosition(x, y, offset)));
        }
    }

//    public Point getPieceOffset(String pieceName) {
//        return pieceOffsets.get(pieceName);
//    }
//
//    public void printBinary() {
//        String formattedBoard = String.format("%" + width * height + "s", data.toString(2)).replace(' ', '0').replaceAll(
//                "(.{" + width + "})", "$1\n");
//        System.out.println(new StringBuilder(formattedBoard).reverse());
//
//    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int index = y * width + x;
                sb.append(data.testBit(index) ? '#' : '_');
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    public boolean isComplete() {
        BigInteger completeBoard = BigInteger.ONE.shiftLeft(width * height).subtract(BigInteger.ONE);
        return data.equals(completeBoard);
    }

    public int getBoardHashCode() {
        byte[] bytes = data.toByteArray();
        return Arrays.hashCode(bytes);
    }

    public static void main(String[] args) {
        Board board = new Board(5, 5);
        Piece piece = new Piece(new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 0}});
        piece.rotateLeft();
        board.placePiece(piece, 0, 1, "p");
        board.print();
    }
}
