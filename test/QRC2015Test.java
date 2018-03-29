import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QRC2015Test {
    @Test
    void solve() {
        assertEquals(("NO"), QRC2015.solve("ik", 1));
        assertEquals(("YES"), QRC2015.solve("ijk", 1));
        assertEquals(("NO"), QRC2015.solve("ijkk", 1));
        assertEquals(("NO"), QRC2015.solve("kji", 1));
        assertEquals(("YES"), QRC2015.solve("ji", 6));
        assertEquals(("NO"), QRC2015.solve("i", 10000));
    }
}