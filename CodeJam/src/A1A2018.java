import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A1A2018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt();
            int c = in.nextInt();
            int h = in.nextInt();
            int v = in.nextInt();
            boolean[][] grid = new boolean[r][c];
            int total = 0;
            for (int j = 0; j < r; j++) {
                String s = in.next();
                for (int k = 0; k < c; k++) {
                    grid[j][k] = s.charAt(k) != '.';
                    if (grid[j][k]) total++;
                }
            }
            System.out.println("Case #" + i + ": " + solve(r, c, h, v, grid, total));
        }
    }

    public static String solve(int r, int c, int h, int v, boolean[][] grid, int total) {
        if (total == 0) return "POSSIBLE";
        int[] rowEnd = new int[h + 1];
        int[] colEnd = new int[v + 1];
        if (total % ((h + 1) * (v + 1)) != 0) {
            return "IMPOSSIBLE";
        }
        if (total % ((v + 1)) != 0) {
            return "IMPOSSIBLE";
        }
        if (total % ((h + 1)) != 0) {
            return "IMPOSSIBLE";
        }

        int count = 0;
        int p = 0;
        int x = total / (h + 1);
        for (int j = 0; j < r; j++) {
            for (int k = 0; k < c; k++) {
                if (grid[j][k])
                    count++;
            }
            if (count == x) {
                if (p < h + 1) {
                    count = 0;
                    rowEnd[p++] = j + 1;
                }
            } else if (count > x) {
                return "IMPOSSIBLE";
            }
        }
        if (count != 0 || rowEnd[rowEnd.length - 1] != r) {
            return "IMPOSSIBLE";
        }

        count = 0;
        p = 0;
        x = total / (v + 1);
        for (int j = 0; j < c; j++) {
            for (int k = 0; k < r; k++) {
                if (grid[k][j])
                    count++;
            }
            if (count == x) {
                if (p < v + 1) {
                    count = 0;
                    colEnd[p++] = j + 1;
                }
            } else if (count > x) {
                return "IMPOSSIBLE";
            }
        }
        if (count != 0 || colEnd[colEnd.length - 1] != c) {
            return "IMPOSSIBLE";
        }
        x = total / (h + 1) / (v + 1);
        int lastR = 0;
        for (int i = 0; i < rowEnd.length; i++) {
            int lastL = 0;
            for (int j = 0; j < colEnd.length; j++) {
                count = 0;
                for (int k = lastR; k < rowEnd[i]; k++) {
                    for (int l = lastL; l < colEnd[j]; l++) {
                        if (grid[k][l]) count++;
                    }
                }
                if (x != count)
                    return "IMPOSSIBLE";
                lastL = colEnd[j];
            }
            lastR = rowEnd[i];
        }


        return "POSSIBLE";
    }

}
