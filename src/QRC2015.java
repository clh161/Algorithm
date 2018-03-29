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
                        if (n < m) {
                            isPositive = !isPositive;
                        }

                        int k = queue.size();
                        queue.add((m - n + 4) % 4);
                        for (long i = 0; i < k; i++) {
                            queue.add(queue.poll());
                        }
                        int x = 0;
                    }
                } else if (repeat <= 0)
                    return "NO";

            }


        }
        return isPositive && toForm.isEmpty() && queue.isEmpty() ? "YES" : "NO";
    }

}
