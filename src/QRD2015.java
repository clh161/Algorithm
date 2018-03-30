import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class QRD2015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            System.out.println("Case #" + i + ": " + solve(x, r, c));
        }
    }

    public static String solve(int x, int xLen, int yLen) {
        int area = xLen * yLen;
        //not divisible
        if (area / x <= 1 || area % x != 0)
            return "RICHARD";
        getFirstMove(x, xLen, yLen);

        return "GABRIEL";
    }

    public static boolean[] getFirstMove(int len, int xLen, int yLen) {
        boolean[] path = new boolean[len - 1];
        boolean lastIsRight = false;
        int x = 0;
        int y = 0;
        for (int i = 0; i < len - 1; i++) {
            boolean shouldGoRight = shouldGoRight(lastIsRight, xLen, yLen, x, y);
            path[i] = shouldGoRight;
            lastIsRight = shouldGoRight;
            if (shouldGoRight) {
                x++;
            } else {
                y++;
            }
        }
        return path;
    }

    public static boolean shouldGoRight(boolean lastIsRight, int xLen, int yLen, int x, int y) {
        if (x == xLen - 1)
            return false;
        if (x == xLen - 2 && y != 0)
            return false;
        if (!lastIsRight)
            return true;
        return y == yLen - 2;
    }

}
