import org.Board.*;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PieceTest {
    @Test
    public void testPiece() {
        int[][] offsets = {{0, 0}, {0, 1}, {0, 2}, {0, 3}};
        int usageCount = 3;
        Piece piece = new Piece(offsets);

        assertEquals(4, piece.getOffsets().size());
    }
    @Test
    public void testAddOffset() {
        Piece piece = new Piece(new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}});
        piece.addOffset(new Point(1,1));
        assertEquals(new Point(1,1), piece.getOffsets().get(piece.getOffsets().size() -1));
    }

    @Test
    public void testRotateRight() {
        Piece piece = new Piece(new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 1}});
        piece.rotateRight();
        assertEquals(new Point(0, 0), piece.getOffsets().get(0));
        assertEquals(new Point(-1, 1), piece.getOffsets().get(piece.getOffsets().size() -1));
    }
    @Test
    public void testRotateLeft() {
        Piece piece = new Piece(new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 1}});
        piece.rotateLeft();
        assertEquals(new Point(0, 0), piece.getOffsets().get(0));
        assertEquals(new Point(1, -1), piece.getOffsets().get(piece.getOffsets().size() -1));
    }

    @Test
    public void testFlipVertically() {
        Piece piece = new Piece(new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 1}});
        piece.flipVertically();
        assertEquals(new Point(0, 0), piece.getOffsets().get(0));
        assertEquals(new Point(0, -1), piece.getOffsets().get(1));
        assertEquals(new Point(0, -2), piece.getOffsets().get(2));
        assertEquals(new Point(1, -1), piece.getOffsets().get(piece.getOffsets().size() -1));
    }

    @Test
    public void testFlipHorizontally() {
        Piece piece = new Piece(new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 1}});
        piece.flipHorizontally();
        assertEquals(new Point(0,2), piece.getOffsets().get(2));
    }
}