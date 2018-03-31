import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jacob Ho
 */
class P22018Test {
    @Test
    void solve() {
        assertEquals("AA AB CA BC", P22018.solve(new int[]{4, 2, 2}));
        assertEquals("AA BC", P22018.solve(new int[]{2, 1, 1}));
        assertEquals("A BC", P22018.solve(new int[]{1, 1, 1}));
        assertEquals("AB CD EF", P22018.solve(new int[]{1, 1, 1, 1, 1, 1}));
        assertEquals("AB C DE", P22018.solve(new int[]{1, 1, 1, 1, 1}));
        assertEquals("AA AA AA BC AB CA BC AB CA BC", P22018.solve(new int[]{10, 5, 5}));
        assertEquals("CB CA BC", P22018.solve(new int[]{1, 2, 3}));
    }
}