import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

import static java.lang.Math.max;

public class A1B2018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int[][] pro = new int[c][3];
            for (int j = 0; j < c; j++) {
                pro[j][0] = in.nextInt();
                pro[j][1] = in.nextInt();
                pro[j][2] = in.nextInt();
            }


            System.out.println("Case #" + i + ": " + solve(r, b, c, pro));
        }
    }

    private static int solve(int r, int b, int c, int[][] pro) {
        int t = 0;
        while (getBit(pro, t, r) < b) {
            t++;
        }
        b -= getBit(pro, t, r);
        int t2 = 0;
        while ()
            while (getBit(pro, t2, r) <= b) {
                t2++;
            }
        return t;
    }

    private static int getBit(int[][] pro, int t, int max) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < pro.length; i++) {
            q.add(max(0, (t - pro[i][2]) / pro[i][1] * pro[i][0]));
        }
        int sum = 0;
        for (int i = 0; i < max && i < q.size(); i++) {
            sum += q.poll();
        }

        return sum;
    }


}
