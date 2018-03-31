import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class A1B2015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int b = in.nextInt();
            int n = in.nextInt();
            int[] time = new int[b];
            for (int j = 0; j < b; j++) {
                time[j] = in.nextInt();
            }
            System.out.println("Case #" + i + ": " + solve(time, n));
        }
    }

    public static int solve(int[] time, int n) {
        if (n <= time.length)
            return n;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < time.length; i++) {
            if (time[i] < min)
                min = time[i];
        }
        long toRun = (long) n / time.length * min - (long) time.length * min;
        int[] timeLeft = new int[time.length];
        for (int i = 0; i < time.length; i++) {
            int served = (int) (toRun / time[i] + 1);
            n -= served;
            timeLeft[i] = (int) (served * time[i] - toRun);
        }
        while (n > 0) {
            for (int i = 0; i < time.length; i++) {
                if (timeLeft[i] == 0) {
                    if (n == 1) {
                        return i + 1;
                    } else {
                        timeLeft[i] += time[i];
                        n--;
                    }
                }
                timeLeft[i]--;
            }


        }
        throw new RuntimeException("Should not reach here");
    }

    public static int solve2(int[] time, int n) {
        if (n <= time.length)
            return n;
        int[] timeLeft = new int[time.length];
        while (n > 0) {
            for (int i = 0; i < time.length; i++) {
                if (timeLeft[i] == 0) {
                    if (n == 1) {
                        return i + 1;
                    } else {
                        timeLeft[i] += time[i];
                        n--;
                    }
                }
                timeLeft[i]--;
            }


        }
        throw new RuntimeException("Should not reach here");
    }
}
