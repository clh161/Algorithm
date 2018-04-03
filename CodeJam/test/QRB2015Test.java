import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QRB2015Test {
    PriorityQueue<Integer> pancakes;

    @BeforeEach
    void setUp() {
        pancakes = new PriorityQueue<>(1, (a, b) -> b - a);

    }

    @Test
    void solve1() {
        pancakes.add(3);
        assertEquals(3, QRB2015.solve(pancakes));
    }

    @Test
    void solve2() {
        pancakes.add(1);
        pancakes.add(2);
        pancakes.add(1);
        pancakes.add(2);
        assertEquals(2, QRB2015.solve(pancakes));
    }

    @Test
    void solve3() {
        pancakes.add(4);
        assertEquals(3, QRB2015.solve(pancakes));
    }

    @Test
    void solve4() {
        pancakes.add(9);
        assertEquals(5, QRB2015.solve(pancakes));
    }
}