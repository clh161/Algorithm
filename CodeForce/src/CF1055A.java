import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CF1055A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int stop = in.nextInt();
        int[][] tracks = new int[2][n];
        for (int i = 0; i < tracks.length; i++) {
            for (int j = 0; j < n; j++) {
                tracks[i][j] = in.nextInt();
            }
        }
        System.out.println(solve(n, stop, tracks) ? "YES" : "NO");
    }

    public static boolean solve(int n, int stop, int[][] tracks) {
        if (tracks[0][0] == 0) return false;
        if (tracks[0][stop - 1] == 1) return true;
        if (tracks[1][stop - 1] == 1) {
            for (int i = stop; i < n; i++) {
                if (tracks[0][i] == 1 && tracks[1][i] == 1) return true;
            }
        }
        return false;
    }

}
