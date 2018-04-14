import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B1B2017 {
    public static final char[] colors = new char[]{'R', 'O', 'Y', 'G', 'B', 'V'};

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int total = in.nextInt();
            List<Integer> unicorns = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                unicorns.add(in.nextInt());
            }
//            solve("", unicorns, total, -1, -1);
            System.out.println("Case #" + i + ": " + solve("", unicorns, total, -1, -1));
        }
    }

    private static String solve(String s, List<Integer> unicorns, int total, int last, int first) {
        if (total == 0 && valid(first, last)) {
            return s;
        }
        if (total > 0)
            for (int i = 0; i < 6; ++i) {
                if (unicorns.get(i) != 0 && valid(last, i)) {
                    ArrayList<Integer> unicorns2 = new ArrayList<>(unicorns);
                    unicorns2.set(i, unicorns.get(i) - 1);

                    String ans = solve(s + colors[i], unicorns2, total - 1, i, first == -1 ? i : first);
                    if (!ans.equalsIgnoreCase("IMPOSSIBLE"))
                        return ans;
                }
            }
        return "IMPOSSIBLE";
    }

    public static boolean valid(int a, int b) {
        if (a == -1) return true;
        switch (a) {
            case 0:
                return b == 2 || b == 4 || b == 3;
            case 2:
                return b == 0 || b == 4 || b == 5;
            case 4:
                return b == 0 || b == 2 || b == 1;
            case 1:
                return b == 4;
            case 3:
                return b == 0;
            case 5:
                return b == 2;
        }
        return false;
    }
}