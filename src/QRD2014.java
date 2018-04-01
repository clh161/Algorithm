//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class QRD2014 {
    public static void main(String[] var0) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            double[][] weights = new double[2][n];
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < n; k++) {
                    weights[j][k] = in.nextDouble();
                }
            }
            System.out.println("Case #" + i + ": " + solve(weights));
        }

    }

    public static String solve(double[][] weights) {
        int score1 = getDeceitfulWarScore(new WeightQueue(weights[0]), new WeightQueue(weights[1]));
        int score2 = getWarScore(new WeightQueue(weights[0]), new WeightQueue(weights[1]));
        return score1 + " " + score2;
    }

    public static int getDeceitfulWarScore(WeightQueue weight1, WeightQueue weight2) {
        int count = 0;
        while (weight1.size() != 0) {
            if (weight1.peek() <= weight2.peek()) {
                weight1.poll();
                weight2.pollLast();
            } else {
                if ((double) weight1.peek() != weight2.peek())
                    count++;
                weight1.poll();
                weight2.poll();
            }

        }
        return count;
    }

    public static int getWarScore(WeightQueue weight1, WeightQueue weight2) {
        int count = 0;
        while (weight1.size() != 0) {
            double smallest = weight1.poll();
            if (smallest > weight2.pollBiggerThanOrEqualOrTheSmallest(smallest))
                count++;
        }
        return count;
    }

    public static class WeightQueue extends PriorityQueue<Double> {


        public WeightQueue() {

        }

        public WeightQueue(double[] weight) {
            for (double w : weight) {
                add(w);
            }
        }


        public double pollLast() {
            WeightQueue newQueue = new WeightQueue();
            double last = 0;
            while (size() > 1)
                newQueue.add(poll());
            last = poll();
            addAll(newQueue);
            return last;
        }

        public double pollBiggerThanOrEqualOrTheSmallest(double weight) {
            WeightQueue newQueue = new WeightQueue();
            Double target = null;
            while (size() > 0 && target == null) {
                if (peek() >= weight) {
                    target = poll();
                } else {
                    newQueue.add(poll());
                }
            }
            addAll(newQueue);
            return target == null ? poll() : target;
        }
    }


}
