import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jacob Ho
 */
class CF955ATest {
    @Test
    void solve() {
        assertEquals("25200.0000", CF955A.solve(19, 00, 255, 1, 100, 1));
        assertEquals("1365.0000", CF955A.solve(17, 41, 1000, 6, 15, 11));
    }
}