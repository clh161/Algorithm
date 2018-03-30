import org.junit.jupiter.api.Test;

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
    void getEmptyArea() {
        boolean[][] grid = new boolean[100][100];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < 50; j++) {
                grid[i][j] = true;
            }
        }
        assertEquals(0, QRD2015.getEmptyArea(QRD2015.copy(grid), 0, 0));
        assertEquals(0, QRD2015.getEmptyArea(QRD2015.copy(grid), 3, 3));
        assertEquals(5000, QRD2015.getEmptyArea(QRD2015.copy(grid), 99, 99));
        assertEquals(5000, QRD2015.getEmptyArea(QRD2015.copy(grid), 0, 50));
    }

    @Test
    void isSpillover() {
        boolean[][] grid = new boolean[100][100];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < 50; j++) {
                grid[i][j] = true;
            }
        }
        assertEquals(false, QRD2015.isSpillover(QRD2015.copy(grid), 5000));
    }

    @Test
    void isSpillover2() {
        boolean[][] grid = new boolean[100][100];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 20; j < 50; j++) {
                grid[i][j] = true;
            }
        }
        assertEquals(true, QRD2015.isSpillover(QRD2015.copy(grid), 1000));
    }

    @Test
    void placeOminos() {
        assertEquals(false, QRD2015.placeOminos(new boolean[10][10], new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 0, 0));
        assertEquals(true, QRD2015.placeOminos(new boolean[10][10], new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}, 0, 0));
        assertEquals(true, QRD2015.placeOminos(new boolean[10][10], new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, 0, 0));
        assertEquals(false, QRD2015.placeOminos(new boolean[4][4], new int[]{1, 2, 3, 0}, 0, 0));

    }
}