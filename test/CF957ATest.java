import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jacob Ho
 */
class CF957ATest {
    @Test
    void solve() {
        assertEquals("YES", CF957A.solve("CY??Y"));
        assertEquals("YES", CF957A.solve("C?C?Y"));
        assertEquals("YES", CF957A.solve("?CYC?"));
        assertEquals("NO", CF957A.solve("C??MM"));
        assertEquals("NO", CF957A.solve("MMY"));
        assertEquals("YES", CF957A.solve("C?C"));
        assertEquals("YES", CF957A.solve("C??M"));
        assertEquals("YES", CF957A.solve("??CM"));
        assertEquals("YES", CF957A.solve("?CM"));
        assertEquals("YES", CF957A.solve("CM?"));
        assertEquals("YES", CF957A.solve("CM??"));
        assertEquals("YES", CF957A.solve("CM???"));
        assertEquals("YES", CF957A.solve("?CM"));
        assertEquals("YES", CF957A.solve("??CM"));
        assertEquals("YES", CF957A.solve("???CM"));
        assertEquals("YES", CF957A.solve("CM??C"));
        assertEquals("YES", CF957A.solve("M??M"));
        assertEquals("NO", CF957A.solve("MMMM"));
        assertEquals("NO", CF957A.solve("M?MM"));
        assertEquals("YES", CF957A.solve("M????????M"));
        assertEquals("YES", CF957A.solve("M????????C"));
        assertEquals("NO", CF957A.solve("MCM"));
        assertEquals("NO", CF957A.solve("MCY"));
        assertEquals("YES", CF957A.solve("M?M?M"));
        assertEquals("YES", CF957A.solve("M??C?M"));
        assertEquals("YES", CF957A.solve("M?C????M"));
        assertEquals("YES", CF957A.solve("MC??"));
        assertEquals("YES", CF957A.solve("C??MC??"));
        assertEquals("YES", CF957A.solve("C??MC??"));
        assertEquals("NO", CF957A.solve("YCY?CMCMCYMYMYC?YMYMYMY?CMC?MCMYCMYMYCM?CMCM?CMYMYCYCMCMCMCMCMYM?CYCYCMCM?CY?MYCYCMYM?CYCYCYMY?CYCYC\n"));
    }
}