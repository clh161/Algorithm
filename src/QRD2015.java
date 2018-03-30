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

    public static String solve(int pathLen, int xLen, int yLen) {
        if (pathLen > xLen && pathLen > yLen)
            return "RICHARD";
        if ((xLen * yLen) % pathLen != 0)
            return "RICHARD";
        for (long i = 0; i < Math.pow(4, pathLen - 1); i++) {
            int[] p = getPath(i, pathLen - 1);
            if (placeOminos(new boolean[xLen][yLen], p, 0, 0)) {
                boolean hasPossiblePath = false;
                for (int[] path : getPathVariations(p)) {
                    for (int[] size : new int[][]{{xLen, yLen}, {yLen, xLen}}) {
                        for (int n = 0; n < size[0]; n++) {
                            for (int o = 0; o < size[1]; o++) {
                                boolean[][] grid = new boolean[size[0]][size[1]];
                                if (placeOminos(grid, path, n, o)) {
                                    for (int j = 0; j < grid.length; j++) {
                                        for (int k = 0; k < grid[j].length; k++) {
                                            if (getEmptyArea(copy(grid), j, k) % pathLen == 0)
                                                hasPossiblePath = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (!hasPossiblePath)
                    return "RICHARD";
            }
        }
        return "GABRIEL";
    }

    public static int[] getPath(long n, int pathLen) {
        int[] path = new int[pathLen];
        int i = 0;
        while (n > 0) {
            path[i] = (int) (n % 4);
            n /= 4;
            i++;
        }
        return path;
    }

    public static int indexOf(int[] path, int direction) {
        for (int i = 0; i < path.length; i++)
            if (path[i] == direction) return i;
        return -1;
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

    public static int[][] getPathVariations(int[] path) {
        int[][] paths = new int[4][path.length];
        for (int i = 0; i < path.length; i++)
            paths[0][i] = path[i];
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < path.length; i++) {
                if (j == 2) {
                    paths[j + 1][i] = (path[i] + 2) % 4;
                } else {
                    if (path[i] % 2 == j) {
                        paths[j + 1][i] = (path[i] + 2) % 4;
                    } else {
                        paths[j + 1][i] = path[i];
                    }
                }
            }
        }
        return paths;
    }

}
