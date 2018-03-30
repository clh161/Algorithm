import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jacob Ho
 */
class A1B2015Test {
    @Test
    void solve() {
        assertEquals(1, A1B2015.solve(new int[]{10, 5}, 4));
        assertEquals(3, A1B2015.solve(new int[]{7, 7, 7}, 12));
        assertEquals(1, A1B2015.solve(new int[]{4, 2, 1}, 8));
        assertEquals(2, A1B2015.solve(new int[]{1, 2, 3}, 10));
        assertEquals(5, A1B2015.solve(new int[]{25, 25, 25, 25, 25}, 1000000000));
        assertEquals(2, A1B2015.solve(new int[]{1, 1}, 2));
        assertEquals(2, A1B2015.solve(new int[]{25, 1}, 2));
        assertEquals(1, A1B2015.solve(new int[]{5, 1}, 7));
    }
}