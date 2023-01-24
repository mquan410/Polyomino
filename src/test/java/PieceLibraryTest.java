import org.Board.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PieceLibraryTest {
    @Test
    public void testAddPiece() {
        PieceLibrary library = new PieceLibrary();
        Piece piece = new Piece(new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}});
        library.addPiece("p0", piece);
        assertEquals(piece, library.getPiece("p0"));
        assertEquals(1, library.getAllPieces().size());
    }

    @Test
    public void testRemovePiece() {
        PieceLibrary library = new PieceLibrary();
        Piece piece = new Piece(new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}});
        library.addPiece("p0", piece);
        library.removePiece("p0");
        assertNull(library.getPiece("p0"));
        assertEquals(0, library.getAllPieces().size());
    }
}

