import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.lang.Math.max;

public class CF956B {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int u = in.nextInt();
        int[] e = new int[n];
        for (int i = 0; i < n; i++) {
            e[i] = in.nextInt();
        }

        System.out.println(solve(e, u));
    }

    private static double solve(int[] e, int u) {
        double max = -1;
        int k = 2;
        for (int i = 0; i < e.length - 2; i++) {
            k = max(k, i + 2);
            int j = i + 1;
            while (k + 1 < e.length && e[k + 1] - u <= e[i]) k++;
            if (e[k] - u <= e[i]) {
                double eff = ((double) (e[k] - e[j])) / (e[k] - e[i]);
                if (eff > max) max = eff;
            }

        }

        return max;
    }


}
