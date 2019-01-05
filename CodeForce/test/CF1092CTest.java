import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jacob Ho
 */
class CF1092CTest {
    @Test
    void solve() {
        assertEquals("SPPSPSPS", CF1092C.solve(new String[]{
                "ba",
                "a",
                "abab",
                "a",
                "aba",
                "baba",
                "ab",
                "aba"}, 5));
        assertEquals("PPPP", CF1092C.solve(new String[]{"a",
                "aa",
                "aa",
                "a",}, 3));

    }
}