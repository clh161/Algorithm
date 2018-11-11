import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jacob Ho
 */
class CF1055ATest {
    @Test
    void test() {
        assertEquals(CF1055A.solve(5, 3, new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}}), true);
        assertEquals(CF1055A.solve(5, 4, new int[][]{{1, 0, 0, 0, 1}, {0, 1, 1, 1, 1}}), true);
        assertEquals(CF1055A.solve(5, 2, new int[][]{{0, 1, 1, 1, 1}, {1, 1, 1, 1, 1}}), false);
    }
}