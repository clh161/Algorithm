import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jacob Ho
 */
class CF1095CTest {
    @Test
    void test() {
        assertEquals("[1, 2, 2, 4]", Arrays.toString(CF1095C.solve(9, 4)));
        assertEquals("[8]", Arrays.toString(CF1095C.solve(8, 1)));
        assertEquals("[]", Arrays.toString(CF1095C.solve(5, 1)));
        assertEquals("[]", Arrays.toString(CF1095C.solve(3, 7)));
    }
}