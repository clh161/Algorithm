import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class QRB2015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int pancakeCount = in.nextInt();
            PriorityQueue<Integer> pancakes = new PriorityQueue<>(pancakeCount, (a, b) -> b - a);
            for (int j = 0; j < pancakeCount; j++) {
                int pancake = in.nextInt();
                pancakes.add(pancake);
            }

            System.out.println("Case #" + i + ": " + solve(pancakes));
        }
    }

    public static int solve(PriorityQueue<Integer> pancakes) {
        int min = pancakes.peek();
        for (int j = pancakes.peek(); j >= 2; j--) {
            PriorityQueue<Integer> newPancakes = new PriorityQueue<>(pancakes.size(), (a, b) -> b - a);
            newPancakes.addAll(pancakes);
            int count = 0;
            while (newPancakes.peek() > j) {
                int poll = newPancakes.poll();
                newPancakes.add(j);
                newPancakes.add(poll - j);
                count++;
            }
            int newMin = newPancakes.peek() + count;
            if (newMin < min)
                min = newMin;
        }
        return min;
    }
}
