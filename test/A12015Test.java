import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jacob Ho
 */
class A12015Test {
    @Test
    void solve() {
        assertEquals("15 25", A12015.solve(new int[]{10, 5, 15, 5}));
        assertEquals("0 0", A12015.solve(new int[]{100, 100}));
        assertEquals("81 567", A12015.solve(new int[]{81, 81, 81, 81, 81, 81, 81, 0}));
        assertEquals("181 244", A12015.solve(new int[]{23, 90, 40, 0, 100, 9}));
    }
}