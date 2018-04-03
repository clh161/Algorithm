import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jacob Ho
 */
class QRB2014Test {
    @Test
    void solve() {
//        assertEquals("1.0000000", QRB2014.solve(30, 1, 2));
        assertEquals("39.1666667", QRB2014.solve(30, 2, 100));
        assertEquals("63.9680013", QRB2014.solve(30.50000, 3.14159, 1999.19990));
        assertEquals("526.1904762", QRB2014.solve(500.0, 4.0, 2000.0));
        assertEquals("0.6518189", QRB2014.solve(1.03397, 99.87614, 99999.03277));
    }
}