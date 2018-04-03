import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jacob Ho
 */
class A1A2016Test {
    @Test
    void solve() {
        assertEquals("CAB", A1A2016.solve("CAB"));
        assertEquals("MJA", A1A2016.solve("JAM"));
        assertEquals("OCDE", A1A2016.solve("CODE"));
        assertEquals("OCDE", A1A2016.solve("CODE"));
        assertEquals("BBAAA", A1A2016.solve("ABAAB"));
        assertEquals("CCCABBBAB", A1A2016.solve("CABCBBABC"));
        assertEquals("CCCBAABAB", A1A2016.solve("ABCABCABC"));
        assertEquals("ZXCASDQWE", A1A2016.solve("ZXCASDQWE"));
    }
}