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

    public static char combine(char a, char b) {
        if (a == b)
            return 0;
        for (int i = 'i'; i <= 'k'; i++) {
            if (a != i && b != i)
                return (char) i;
        }
        throw new IllegalArgumentException("Invalid: " + a + " " + b);
    }


    public static boolean isPositive(char a, char b) {
        if (a == b)
            return false;
        if (a == 'i' && b == 'j') return false;
        if (a == 'i' && b == 'k') return true;
        if (a == 'j' && b == 'i') return true;
        if (a == 'j' && b == 'k') return false;
        if (a == 'k' && b == 'i') return false;
        if (a == 'k' && b == 'j') return true;
        throw new IllegalArgumentException("Invalid: " + a + " " + b);
    }

    public static String solve(String str, long repeat) {
        boolean isPositive = true;
        String queue = str;
        repeat--;
        Queue<Character> toForm = new LinkedList<>();
        toForm.add('i');
        toForm.add('j');
        toForm.add('k');
        int added = 0;
        while (!queue.isEmpty()) {
            if (queue.length() <= str.length() && repeat-- > 0) {
                if (added < -3)
                    return "NO";
                added--;
                queue = queue + str;
            }
            char n = queue.charAt(0);
            queue = queue.substring(1, queue.length());
            if (!toForm.isEmpty() && n == toForm.peek()) {
                toForm.poll();
                added = 1;
            } else {
                if (!queue.isEmpty()) {
                    char m = queue.charAt(0);
                    queue = queue.substring(1, queue.length());
                    if (n == m) {
                        isPositive = !isPositive;
                    } else {
                        if (isPositive(n, m))
                            isPositive = !isPositive;
                        char newInt = combine(n, m);
                        if (newInt != 0)
                            queue = newInt + queue;
                    }
                } else if (repeat <= 0)
                    return "NO";
            }
            if (toForm.isEmpty() && repeat > 4) {
                repeat %= 4;
            }


        }
        return isPositive && toForm.isEmpty() ? "YES" : "NO";
    }

}
