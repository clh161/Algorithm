import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class QRA2018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int shield = in.nextInt();
            String programs = in.next();
            System.out.println("Case #" + i + ": " + solve(shield, programs));
        }
    }

    public static String solve(int shield, String programs) {
        int swaps = getSwaps(shield, programs.toCharArray(), 0);
        if (swaps == -1) return "IMPOSSIBLE";
        return String.valueOf(swaps);
    }

    private static int getSwaps(int shield, char[] programs, int currentSwap) {
        if (getDmg(programs) <= shield) return currentSwap;
        int lastC = -1;
        int lastS = -1;
        for (int i = programs.length - 1; i >= 0; i--) {
            if (programs[i] == 'S') lastS = i;
            if (lastS != -1 && programs[i] == 'C') {
                lastC = i;
                break;
            }
        }
        if (lastS == -1 || lastC == -1)
            return -1;
        char temp = programs[lastC];
        programs[lastC] = programs[lastS];
        programs[lastS] = temp;
        return getSwaps(shield, programs, currentSwap + 1);
    }

    public static long getDmg(char[] programs) {
        long dmg = 1;
        long totalDmg = 0;
        for (int i = 0; i < programs.length; i++) {
            if (programs[i] == 'S') totalDmg += dmg;
            else dmg *= 2;
        }
        return totalDmg;
    }

}
