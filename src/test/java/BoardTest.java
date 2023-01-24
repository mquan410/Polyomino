import org.Board.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {
    @Test
    public void testPlacePiece() {
        Board board = new Board(5, 5);
        Piece piece = new Piece(new int[][]{{0, 0}, {0, 1}, {1, 1}});
        board.placePiece(piece, 0, 0, "p0");
        assertTrue(board.getData().testBit(0 * board.getWidth() + 0));
        assertTrue(board.getData().testBit(1 * board.getWidth() + 0));
        assertTrue(board.getData().testBit(1 * board.getWidth() + 1));
    }

    @Test
    public void testRemovePiece() {
        Board board = new Board(5, 5);
        Piece piece = new Piece(new int[][]{{0, 0}, {0, 1}, {1, 1}});
        board.placePiece(piece, 0, 0, "p0");
        board.removePiece(piece, 0, 0, "p0");
        assertFalse(board.getData().testBit(0 * board.getWidth() + 0));
        assertFalse(board.getData().testBit(1 * board.getWidth() + 0));
        assertFalse(board.getData().testBit(1 * board.getWidth() + 1));
    }
}


