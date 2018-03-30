import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A12015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[] mushrooms = new int[n];
            for (int j = 0; j < n; j++) {
                mushrooms[j] = in.nextInt();
            }
            System.out.println("Case #" + i + ": " + solve(mushrooms));
        }
    }

    public static String solve(int[] mushrooms) {
        int a = 0;
        int b = 0;
        int maxRate = 0;
        for (int i = 1; i < mushrooms.length; i++) {
            int diff = mushrooms[i - 1] - mushrooms[i];
            maxRate = Math.max(diff, maxRate);
        }
        for (int i = 1; i < mushrooms.length; i++) {
            int diff = mushrooms[i - 1] - mushrooms[i];
            if (diff > 0)
                a += diff;
            b += Math.min(mushrooms[i - 1], maxRate);
        }
        return a + " " + b;
    }
}
