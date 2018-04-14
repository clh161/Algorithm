import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A1A20182 {
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
        if (total % ((h + 1) * (v + 1)) != 0) {
            return "IMPOSSIBLE";
        }
        if (total % ((v + 1)) != 0) {
            return "IMPOSSIBLE";
        }
        if (total % ((h + 1)) != 0) {
            return "IMPOSSIBLE";
        }
        int x = total / (h + 1) / (v + 1);
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                int count1 = 0;
                int count2 = 0;
                int count3 = 0;
                int count4 = 0;
                for (int k = 0; k < i; k++) {
                    for (int l = 0; l < j; l++) {
                        if (grid[k][l]) count1++;
                    }
                }
                for (int k = i; k < r; k++) {
                    for (int l = 0; l < j; l++) {
                        if (grid[k][l]) count2++;
                    }
                }
                for (int k = 0; k < i; k++) {
                    for (int l = j; l < c; l++) {
                        if (grid[k][l]) count3++;
                    }
                }
                for (int k = i; k < r; k++) {
                    for (int l = j; l < c; l++) {
                        if (grid[k][l]) count4++;
                    }
                }
                if (count1 == x && count2 == x && count3 == x && count4 == x)
                    return "POSSIBLE";

            }
        }


        return "IMPOSSIBLE";
    }

}
