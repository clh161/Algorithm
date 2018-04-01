import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CF955A {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int h = in.nextInt();
        int m = in.nextInt();
        int hunger = in.nextInt();
        int increaseRate = in.nextInt();
        int cost = in.nextInt();
        int decreaseRate = in.nextInt();
        System.out.println(solve(h, m, hunger, increaseRate, cost, decreaseRate));
    }

    public static String solve(int h, int m, int hunger, int increaseRate, int cost, int decreaseRate) {
        double cost1 = Math.ceil(((double) Math.max(1200 - h * 60 - m, 0) * increaseRate + hunger) / decreaseRate) * cost * 0.8;
        double cost2 = Math.ceil((double) hunger / decreaseRate) * cost;
        return String.format("%.4f", Math.min(cost1, cost2));
    }

}
