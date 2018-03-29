import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QRA2015Test {
    @Test
    void solve() {
        assertEquals(0, QRA2015.solve(new int[]{1, 1, 1, 1, 1}));
        assertEquals(1, QRA2015.solve(new int[]{0, 9}));
        assertEquals(2, QRA2015.solve(new int[]{1, 1, 0, 0, 1, 1}));
        assertEquals(0, QRA2015.solve(new int[]{1}));
        assertEquals(10, QRA2015.solve(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}));
        assertEquals(0, QRA2015.solve(new int[]{8, 8}));
    }
}