import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jacob Ho
 */
class A1B2015Test {
    @Test
    void solve() {
        assertEquals(1, A1B2015.solve(new int[]{10, 5}, 4));
        assertEquals(3, A1B2015.solve(new int[]{7, 7, 7}, 12));
        assertEquals(1, A1B2015.solve(new int[]{4, 2, 1}, 8));
        assertEquals(2, A1B2015.solve(new int[]{1, 2, 3}, 10));
        assertEquals(5, A1B2015.solve(new int[]{25, 25, 25, 25, 25}, 1000000000));
        assertEquals(2, A1B2015.solve(new int[]{1, 1}, 2));
        assertEquals(2, A1B2015.solve(new int[]{25, 1}, 2));
        assertEquals(1, A1B2015.solve(new int[]{5, 1}, 7));
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            int[] ints = new int[100000];
            for (int j = 0; j < 100000; j++) {
                ints[j] = rand.nextInt(10000) + 1;
            }
            int n = rand.nextInt(1000) + 1;
            assertEquals(A1B2015.solve2(ints, n), A1B2015.solve(ints, n));
        }

    }
}