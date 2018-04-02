import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class CF938D {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] routes = new int[m][3];
        int[] prices = new int[n];
        for (int i = 0; i < m; i++) {
            routes[i][0] = in.nextInt() - 1;
            routes[i][1] = in.nextInt() - 1;
            routes[i][2] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        System.out.println(solve(routes, prices));
    }

    public static String solve(int[][] routes, int[] prices) {
        int[][] map = getMap(routes, prices.length);
        int[] lower = new int[prices.length];
        for (int i = 0; i < lower.length; i++) {
            int best = prices[i];
            for (int j = 0; j < map.length; j++) {
                if (i != j && map[i][j] != -1 && map[i][j] * 2 + prices[j] < best)
                    best = map[i][j] * 2 + prices[j];
            }
            lower[i] = best;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lower.length; i++) {
            sb.append(lower[i]);
            if (i != lower.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

    public static int[][] getMap(int[][] routes, int size) {
        int[][] map = new int[size][size];
        for (int i = 0; i < map.length; i++) {
            map[i] = new int[map.length];
            Arrays.fill(map[i], -1);
            map[i][i] = 0;
        }
        for (int i = 0; i < routes.length; i++) {
            int pointA = routes[i][0];
            int pointB = routes[i][1];
            int price = routes[i][2];
            updateMap(map, new int[]{pointA, pointB}, price);
        }
        return map;
    }

    public static void updateMap(int[][] map, int[] points, int price) {
        for (int i = 0; i < points.length; i++) {
            if (map[points[i]][points[1 - i]] > price || map[points[i]][points[1 - i]] == -1) {
                map[points[i]][points[1 - i]] = price;
                for (int j = 0; j < map.length; j++) {
                    if (map[points[1 - i]][j] != -1) {
                        if (map[points[i]][j] == -1 || map[points[i]][j] > price + map[points[1 - i]][j])
                            updateMap(map, new int[]{points[i], j}, price + map[points[1 - i]][j]);
                    }
                }
            }
        }
    }

    public static void printMap(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sb.append(map[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

}
