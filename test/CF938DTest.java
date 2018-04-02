import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jacob Ho
 */
class CF938DTest {
    @Test
    void solve() {
        assertEquals("6 14 1 25", CF938D.solve(
                new int[][]{
                        new int[]{0, 1, 4},
                        new int[]{1, 2, 7},
                }, new int[]{6, 20, 1, 25}
        ));
        assertEquals("12 10 12", CF938D.solve(
                new int[][]{
                        new int[]{0, 1, 1},
                        new int[]{1, 2, 1},
                        new int[]{0, 2, 1},
                }, new int[]{30, 10, 20}
        ));
    }
}