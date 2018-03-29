import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QRC2015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            long n = in.nextLong();
            long repeat = in.nextLong();
            String str = in.next();
            System.out.println("Case #" + i + ": " + solve(str, repeat));
        }
    }

    public static void addToQueue(Queue<Integer> queue, String str) {
        for (int k = 0; k < str.length(); k++) {
            queue.add(str.charAt(k) - 'i' + 1);
        }
    }

    public static int combine(int a, int b) {
        if (a == b)
            return 0;
        for (int i = 1; i <= 3; i++) {
            if (a != i && b != i)
                return i;
        }
        throw new IllegalArgumentException("Invalid: " + a + " " + b);
    }


    public static boolean isPositive(int a, int b) {
        if (a == b)
            return false;
        if (a == 1 && b == 2) return false;
        if (a == 1 && b == 3) return true;
        if (a == 2 && b == 1) return true;
        if (a == 2 && b == 3) return false;
        if (a == 3 && b == 1) return false;
        if (a == 3 && b == 2) return true;
        throw new IllegalArgumentException("Invalid: " + a + " " + b);
    }

    public static String solve(String str, long repeat) {
        boolean isPositive = true;
        Queue<Integer> queue = new LinkedList<>();
        addToQueue(queue, str);
        repeat--;
        Queue<Integer> toForm = new LinkedList<>();
        toForm.add(1);
        toForm.add(2);
        toForm.add(3);
        while (!queue.isEmpty()) {
            if (queue.size() <= str.length() && repeat-- > 0)
                addToQueue(queue, str);
            int n = queue.poll();
            if (!toForm.isEmpty() && n == toForm.peek()) {
                toForm.poll();
            } else {
                if (!queue.isEmpty()) {
                    int m = queue.poll();
                    if (n == m) {
                        isPositive = !isPositive;
                    } else {
                        if (isPositive(n, m))
                            isPositive = !isPositive;
                        int newInt = combine(n, m);
                        if (newInt != 0) {
                            int k = queue.size();
                            queue.add(newInt);
                            for (long i = 0; i < k; i++) {
                                queue.add(queue.poll());
                            }
                        }
                    }
                } else if (repeat <= 0)
                    return "NO";
            }
            if (toForm.isEmpty() && repeat > 4) {
                repeat %= 4;
            }


        }
        return isPositive && toForm.isEmpty() && queue.isEmpty() ? "YES" : "NO";
    }

}
