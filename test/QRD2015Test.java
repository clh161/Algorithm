import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jacob Ho
 */
class QRD2015Test {
    @Test
    void getAnswer() {
        assertEquals("GABRIEL", QRD2015.solve(2, 2, 2));
        assertEquals("RICHARD", QRD2015.solve(2, 1, 3));
        assertEquals("RICHARD", QRD2015.solve(4, 4, 1));
        assertEquals("GABRIEL", QRD2015.solve(3, 2, 3));
    }

    @Test
    void getFirstMove() {
        assertArrayEquals(new boolean[]{true}, QRD2015.getFirstMove(2, 2, 2));
        assertArrayEquals(new boolean[]{true}, QRD2015.getFirstMove(2, 4, 2));
        assertArrayEquals(new boolean[]{true, true, true}, QRD2015.getFirstMove(4, 4, 2));
        assertArrayEquals(new boolean[]{false}, QRD2015.getFirstMove(2, 1, 4));
        assertArrayEquals(new boolean[]{true, false, true, false, true, false, true, true, true}, QRD2015.getFirstMove(10, 10, 5));
        assertArrayEquals(new boolean[]{true, false, true, false, true, false, false, false, false}, QRD2015.getFirstMove(10, 5, 10));
    }
}