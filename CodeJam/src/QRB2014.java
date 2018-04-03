import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class QRB2014 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            double cost = in.nextDouble();
            double rate = in.nextDouble();
            double goal = in.nextDouble();
            System.out.println("Case #" + i + ": " + solve(cost, rate, goal));
        }
    }

    public static String solve(double cost, double rate, double goal) {
        double accuRate = 2;
        double accuTime = 0;
        double bestTime = Double.MAX_VALUE;
        double nextTime = goal / accuRate;
        while (bestTime > nextTime) {
            bestTime = nextTime;
            accuTime += cost / accuRate;
            accuRate += rate;
            nextTime = goal / accuRate + accuTime;
        }
        return String.format("%.7f", bestTime);
    }

    public static double solve(double cost, double rate, double goal, double accuTime, double accuRate) {
        double time = goal / accuRate + accuTime;
        double nextTime = goal / (accuRate + rate) + (cost / accuRate) + accuTime;
        if (time <= nextTime)
            return time;
        return solve(cost, rate, goal, accuTime + cost / accuRate, accuRate + rate);
    }
}
