package org.Board;

import lombok.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Piece {
    private List<Point> offsets;

    public Piece(int[][] coordinates) {
        offsets = new ArrayList<>();
        for (int[] coord : coordinates) {
            offsets.add(new Point(coord[0], coord[1]));
        }
    }

    public Piece() {
        offsets = new ArrayList<>();
    }

    public void addOffset(Point offset) {
        offsets.add(offset);
    }

    public List<Point> getOffsets() {
        return offsets;
    }

    public void rotateRight() {
        for (Point offset : offsets) {
            int x = offset.x;
            offset.x = -offset.y;
            offset.y = x;
        }
    }

    public void rotateLeft() {
        for (Point offset : offsets) {
            int y = offset.y;
            offset.y = -offset.x;
            offset.x = y;
        }
    }

    public void flipVertically(){
        for(Point offset:offsets){
            offset.y = -offset.y;
        }
    }
    public void flipHorizontally(){
        for(Point offset:offsets){
            offset.x = -offset.x;
        }
    }
}
