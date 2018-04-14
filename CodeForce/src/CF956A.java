import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF956A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int r = in.nextInt();
        int c = in.nextInt();
        boolean grid[][] = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String s = in.next();
            for (int j = 0; j < c; j++) {
                if (s.charAt(j) == '#') grid[i][j] = true;
            }
        }
        System.out.println(solve(grid) ? "Yes" : "No");
    }

    private static boolean solve(boolean[][] grid) {
        Set<Integer> rs = new HashSet<>();
        Set<Integer> cs = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]) {
                    Set<Integer> newRs = new HashSet<>();
                    Set<Integer> newCs = new HashSet<>();
                    getRC(grid, i, j, newRs, newCs);
                    if (!rs.containsAll(newRs) && !cs.containsAll(newCs)) {
                        for (Integer newR : newRs) {
                            for (Integer newC : newCs) {
                                if (grid[newR][newC]) {
                                    grid[newR][newC] = false;
                                } else {
                                    return false;
                                }
                            }
                        }
                    } else {
                        return false;
                    }

                }
            }
        }
        return true;
    }

    private static void getRC(boolean[][] grid, int i, int j, Set<Integer> newRs, Set<Integer> newCs) {
        for (int k = 0; k < grid.length; k++) {
            if (grid[k][j] && (!newRs.contains(k) || !newCs.contains(j))) {
                newRs.add(k);
                newCs.add(j);
                getRC(grid, k, j, newRs, newCs);
            }
        }
        for (int k = 0; k < grid[i].length; k++) {
            if (grid[i][k] && (!newRs.contains(i) || !newCs.contains(k))) {
                newRs.add(i);
                newCs.add(k);
                getRC(grid, i, k, newRs, newCs);
            }
        }

    }


}
