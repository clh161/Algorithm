import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class QRD2015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            System.out.println("Case #" + i + ": " + solve(x, r, c));
        }
    }

    public static String solve(int x, int xLen, int yLen) {
        int area = xLen * yLen;
        //not divisible
        if (area / x <= 1 || area % x != 0)
            return "RICHARD";
        getFirstMove(x, xLen, yLen);

        return "GABRIEL";
    }

    public static int[] getFirstMove(int len, int xLen, int yLen) {
        int[] path = new int[len - 1];
//        for (int i = 0; i < len - 1; i++)
//            path[i] = i % 2 == 0 ? 0 : 1;


        return path;
    }

    public static boolean placeOminos(boolean[][] grid, int[] path, int x, int y) {
        grid[x][y] = true;
        for (int i = 0; i < path.length; i++) {
            if (path[i] == 0) y--;
            if (path[i] == 1) x++;
            if (path[i] == 2) y++;
            if (path[i] == 3) x--;
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y])
                return false;
            grid[x][y] = true;
        }
        return true;
    }

    public static boolean isSpillover(boolean[][] grid, int pathLen) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int area = getEmptyArea(copy(grid), i, j);
                if (area == 0) continue;
                if (grid.length * grid[0].length - pathLen != area)
                    return true;
            }
        }
        return false;
    }

    public static int getEmptyArea(boolean[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y]) return 0;
        grid[x][y] = true;
        return getEmptyArea(grid, x + 1, y)
                + getEmptyArea(grid, x - 1, y)
                + getEmptyArea(grid, x, y + 1)
                + getEmptyArea(grid, x, y - 1)
                + 1;
    }

    public static boolean[][] copy(boolean[][] grid) {
        boolean[][] newGrid = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                newGrid[i][j] = grid[i][j];
            }
        }
        return newGrid;
    }

}
