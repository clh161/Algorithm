import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Jacob Ho
 */
class QRD2014Test {
    @Test
    void getDeceitfulWarScore() {
        assertEquals("0 0", QRD2014.solve(
                new double[][]{
                        new double[]{0.5},
                        new double[]{0.6}}));
        assertEquals("1 0", QRD2014.solve(
                new double[][]{
                        new double[]{0.7, 0.2},
                        new double[]{0.8, 0.3}}));
        assertEquals("2 1", QRD2014.solve(
                new double[][]{
                        new double[]{0.5, 0.1, 0.9},
                        new double[]{0.6, 0.4, 0.3}}));
        assertEquals("8 4", QRD2014.solve(
                new double[][]{
                        new double[]{0.186, 0.389, 0.907, 0.832, 0.959, 0.557, 0.300, 0.992, 0.899},
                        new double[]{0.916, 0.728, 0.271, 0.520, 0.700, 0.521, 0.215, 0.341, 0.458}}));

        assertEquals("0 0", QRD2014.solve(
                new double[][]{
                        new double[]{0.5, 0.5},
                        new double[]{0.5, 0.5}}));
        assertEquals("1 0", QRD2014.solve(
                new double[][]{
                        new double[]{0.5, 0.6},
                        new double[]{0.5, 0.99999}}));
        assertEquals("1 0", QRD2014.solve(
                new double[][]{
                        new double[]{0.00001, 0.6},
                        new double[]{0.5, 0.99999}}));
        assertEquals("0 0", QRD2014.solve(
                new double[][]{
                        new double[]{0.99999, 0.99999, 0.99999},
                        new double[]{0.99999, 0.99999, 0.99999}}));
        assertEquals("0 0", QRD2014.solve(
                new double[][]{
                        new double[]{0.00001, 0.00001, 0.00001},
                        new double[]{0.00001, 0.00001, 0.00001}}));

    }
}